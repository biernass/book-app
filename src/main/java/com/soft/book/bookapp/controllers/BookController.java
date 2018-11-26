package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping(value = "/books")
    public List<BookDto> findAllBooks() {
        return bookService.findAll();
    }


    @GetMapping(value = "/book/{id}")
    public BookDto bookById(@PathVariable Long id) {
        BookDto bookDto = bookService.findBookById(id);
        if(bookDto == null) throw new BookNotFoundException(id);
        return bookDto;
    }


}
