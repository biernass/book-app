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
}
