package ru.katrine.bookshop.view.books;

import ru.katrine.bookshop.core.interfaces.IView;

public class BookCoverView implements IView {

    private String base64;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
