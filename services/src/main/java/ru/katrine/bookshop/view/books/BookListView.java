package ru.katrine.bookshop.view.books;

import ru.katrine.bookshop.core.interfaces.IView;

import java.util.List;

public class BookListView implements IView {

    private List<BookView> bookList;

    public List<BookView> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookView> bookList) {
        this.bookList = bookList;
    }
}
