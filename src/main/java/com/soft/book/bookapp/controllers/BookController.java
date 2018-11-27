package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping(value = "/books")
    public List<BookDto> findAllBooks() {
        return bookService.findAll();
    }

    @GetMapping(value = "/book/id={id}")
    public BookDto bookById(@PathVariable Long id) {
        BookDto bookDto = bookService.findBookById(id);
//        if (bookDto == null) throw new BookNotFoundException("Book with id: " + id + " not exist");
        return bookDto;
    }

    @GetMapping(value = "/book/isbn={isbn}")
    public BookDto bookByISBN(@PathVariable String isbn) {
        BookDto bookDto = bookService.findBookByIsbn(isbn);
        if (bookDto == null) throw new BookNotFoundException("Book with ISBN: " + isbn + " not exist");
        return bookDto;
    }

    @GetMapping(value = "/bookcategory/{category}")
    public List<BookDto> booksByCategory(@PathVariable String category) {
        for (BookCategoryType bt : BookCategoryType.values()) {
            boolean exist = category.toUpperCase().equals(bt.name().toUpperCase());
            if (exist == true) {
                return bookService.findBooksByCategory(bt);
            }
        }
        throw new BookNotFoundException("This category not exist");
    }
}
