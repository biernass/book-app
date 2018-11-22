package com.soft.book.bookapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Book> books;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAuthorName(){
        return firstName + " " + lastName;
    }

}
