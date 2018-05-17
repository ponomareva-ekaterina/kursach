package ru.katrine.bookshop.model;

import ru.katrine.bookshop.core.BaseModel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "bought_books")
@SequenceGenerator(name = "bougth_book_id_seq", sequenceName = "bougth_book_id_seq", allocationSize = 1)
public class BoughtBookModel extends BaseModel {

    @Id
    @Column(name = "bougth_book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bougth_book_id_seq")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id")
    private BookModel book;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_status_id")
    private BookStatusModel bookStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public BookStatusModel getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatusModel bookStatus) {
        this.bookStatus = bookStatus;
    }
}
