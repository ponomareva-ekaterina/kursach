package ru.katrine.bookshop.service.books;



import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import ru.katrine.bookshop.view.books.BookCoverView;

import java.io.*;
import java.util.Base64;
import java.util.List;

public class BookCoverService {

    public String save(InputStream uploadedInputStream, FormDataContentDisposition fileDetail){

        String saveFilePath = getFileStoragePath(fileDetail);

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            File file = new File(saveFilePath);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e){
          e.printStackTrace();
        }

        return saveFilePath;
    }

    public BookCoverView sendBase64(Integer bookId, Integer authorId) {
        String storagePath = getStoragePath();
        File storage = new File(storagePath);
        String imageName = bookId + "-" + authorId;
        String encodedFile = "";
        File[] fileList = storage.listFiles();
        for (File file:
                fileList) {
            String fileName = file.getName().split("\\.")[0];
            String a = "s";
            if(fileName.equals(imageName)){
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStream.read(bytes);
                    encodedFile = "data:image/jpeg;base64, " + Base64.getEncoder().encodeToString(bytes);

                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }

        BookCoverView bookCoverView = new BookCoverView();
        bookCoverView.setBase64(encodedFile);
        return bookCoverView;
    }

    private String getStoragePath(){
        String saveFilePath = BookCoverService.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        saveFilePath = saveFilePath.split("target")[0];
        saveFilePath += "src\\main\\resources\\imagestorage\\bookcovers";
        return saveFilePath;
    }

    private String getFileStoragePath(FormDataContentDisposition fileDetail){
        String saveFilePath = "";
        try {
            saveFilePath = getStoragePath() + "\\" + new String(fileDetail.getFileName().getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e){
            e.getStackTrace();
        }

        return saveFilePath;
    }
}
