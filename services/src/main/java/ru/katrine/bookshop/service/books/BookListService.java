package ru.katrine.bookshop.service.books;

import ru.katrine.bookshop.core.EntityBaseService;
import ru.katrine.bookshop.dao.books.BookListDAO;
import ru.katrine.bookshop.model.BookModel;
import ru.katrine.bookshop.view.books.BookListView;
import ru.katrine.bookshop.view.books.BookView;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class BookListService extends EntityBaseService<BookListView, BookModel, BookListDAO> {

    @Inject
    BookService bookService;

    @Inject
    public BookListService(BookListDAO dao) {
        this.entityDAO = dao;
    }

    @Transactional
    public BookListView get(Integer offset, Integer limit, String sortKey, String direction, String searchKey, String searchName) throws Exception {
        List<BookView> bookViewList = new ArrayList<>();

        List<BookModel> bookModelList = entityDAO.get(offset, limit, sortKey, direction, searchKey, searchName);

        for (BookModel model:
             bookModelList) {
            bookViewList.add(bookService.fromModelToView(model));
        }

        BookListView bookListView = new BookListView();
        bookListView.setBookList(bookViewList);
        return bookListView;
    }
}
