package ru.katrine.bookshop.service.books;

import ru.katrine.bookshop.core.EntityBaseService;
import ru.katrine.bookshop.dao.books.BookDAO;
import ru.katrine.bookshop.model.BookModel;
import ru.katrine.bookshop.service.authors.AuthorService;
import ru.katrine.bookshop.service.genres.GenreService;
import ru.katrine.bookshop.view.books.BookView;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookService extends EntityBaseService<BookView, BookModel, BookDAO> {

    @Inject
    AuthorService authorService;

    @Inject
    GenreService genreService;

    @Inject
    public BookService(BookDAO dao) {
        this.entityDAO = dao;
    }

    @Transactional
    public BookView add(BookView bookView) throws Exception{
        BookModel bookModel = fromViewToModel(bookView);

        entityDAO.edit(bookModel);

        return fromModelToView(bookModel);
    }

    public BookModel fromViewToModel(BookView view) throws Exception{
        BookModel model = new BookModel();

        if(view.getId() != -1){
            model.setId(view.getId());
        }

        model.setName(view.getName());
        model.setCopiesLeft(view.getCopiesLeft());

        model.setAuthor(authorService.fromViewToModel(view.getAuthor()));
        model.setGener(genreService.fromViewToModel(view.getGenre()));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        LocalDateTime date = LocalDateTime.parse(view.getPublishDate().replaceAll("Z$", "+0000"), format);
        date = date.plusHours(3);
        model.setPublishDate(date);

        return model;
    }

    public BookView fromModelToView(BookModel model) throws Exception{
        BookView view = new BookView();

        view.setId(model.getId());
        view.setName(model.getName());
        view.setAuthor(authorService.fromModelToView(model.getAuthor()));
        view.setGenre(genreService.fromModelToView(model.getGener()));
        view.setPublishDate(model.getPublishDate().toString());
        view.setCopiesLeft(model.getCopiesLeft());

        return view;
    }
}
