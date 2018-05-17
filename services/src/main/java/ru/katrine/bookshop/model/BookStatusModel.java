package ru.katrine.bookshop.model;

import ru.katrine.bookshop.core.BaseModel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "book_statuses")
@SequenceGenerator(name = "book_status_id_seq", sequenceName = "book_status_id_seq", allocationSize = 1)
public class BookStatusModel extends BaseModel {

    @Id
    @Column(name = "book_status_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_status_id_seq")
    private Integer id;

    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
