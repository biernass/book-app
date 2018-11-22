package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(method = RequestMethod.GET, name = "/books")
    public List<BookDto> findAllBooks(){
        return bookService.findAll();
    }

//    @GetMapping(name = "/book/{id}")
//    public BookDto bookById(@PathVariable Long id){
//        try {
//            return bookService.findBookById(id);
//        } catch (BookNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/{id}")
    public BookDto bookById(@PathVariable Long id) {
        try {
            return bookService.findBookById(id);
        } catch (BookNotFoundException e) {
            logger.error("Product with id = " + id + " was not found");
        }

        return null;
    }

}
