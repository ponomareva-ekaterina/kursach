package ru.katrine.bookshop.view.books;

import ru.katrine.bookshop.core.interfaces.IView;
import ru.katrine.bookshop.view.authors.AuthorView;
import ru.katrine.bookshop.view.genres.GenreView;

public class BookView implements IView {

    private Integer id;
    private String name;
    private AuthorView author;
    private GenreView genre;
    private String publishDate;
    private Integer copiesLeft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorView getAuthor() {
        return author;
    }

    public void setAuthor(AuthorView author) {
        this.author = author;
    }

    public GenreView getGenre() {
        return genre;
    }

    public void setGenre(GenreView genre) {
        this.genre = genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getCopiesLeft() {
        return copiesLeft;
    }

    public void setCopiesLeft(Integer copiesLeft) {
        this.copiesLeft = copiesLeft;
    }
}
