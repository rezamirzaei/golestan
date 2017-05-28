package ir.golestan.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Reza-PC on 1/15/2017.
 */
@Entity
@Table(name = "BS_ORDER")
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany
    @JoinColumn(name = "BOOK_ID")
    @Column
    private List<Book> books;
    @Column
    private Date date;

    public Order(User user, ArrayList<Book> books, Date date) {
        this.user = user;
        this.books = books;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
