package ru.katrine.bookshop.view.genres;

import ru.katrine.bookshop.core.interfaces.IView;

public class GenreView implements IView {

    private Integer id;
    private String name;

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
}
