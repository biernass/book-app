package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping(name = "/books")
    public List<BookDto> findAllBooks(){
        return bookService.findAll();
    }

}
