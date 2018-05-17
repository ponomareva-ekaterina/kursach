package ru.katrine.bookshop.controllers.books;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import ru.katrine.bookshop.core.BaseController;
import ru.katrine.bookshop.service.books.BookCoverService;
import ru.katrine.bookshop.view.books.BookCoverView;
import ru.katrine.bookshop.view.books.BookListView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path(BaseController.BASE_API_PATH + "/book/cover")
public class BookCoverController {


    @Inject
    private BookCoverService bookCoverService;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @FormDataParam("info") FormDataBodyPart fileInfo) {

        String uploadedFilePath = bookCoverService.save(uploadedInputStream, fileDetail);

        return Response.status(200).entity(uploadedFilePath).build();
    }

    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_JSON)
    public BookCoverView sendBase64(@Context HttpHeaders headers, @Context HttpServletResponse response, @Context HttpServletRequest request){
        Integer bookId = request.getParameter("bookId") != null ? Integer.parseInt(request.getParameter("bookId")) : -1;
        Integer authorId = request.getParameter("authorId") != null ? Integer.parseInt(request.getParameter("authorId")) : -1;

        return bookCoverService.sendBase64(bookId, authorId);
    }

}
