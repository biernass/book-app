package com.soft.book.bookapp.dto;

import com.soft.book.bookapp.entities.BookCategoryType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class BookDto {

    private Long id;

    private String title;

    private String publisher;

    private String author;

    private String  bookCategoryType;

    private String ISBN;

    private BigDecimal price;

    private Long inStock;


    public BookDto() {
    }

    public BookDto(Long id, String title, String publisher,
                   String author, String bookCategoryType, String ISBN, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.bookCategoryType = bookCategoryType;
        this.ISBN = ISBN;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookCategoryType(String bookCategoryType) {
        this.bookCategoryType = bookCategoryType;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookCategoryType() {
        return bookCategoryType;
    }

    public String getISBN() {
        return ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setInStock(Long inStock) {
        this.inStock = inStock;
    }
}
