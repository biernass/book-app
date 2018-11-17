package com.soft.book.bookapp.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String publisher;

    private String author;

    @Enumerated(EnumType.STRING)
    private BookCategoryType bookCategoryType;

    private String ISBN;

    private BigDecimal price;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategoryType getBookCategoryType() {
        return bookCategoryType;
    }

    public void setBookCategoryType(BookCategoryType bookCategoryType) {
        this.bookCategoryType = bookCategoryType;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
