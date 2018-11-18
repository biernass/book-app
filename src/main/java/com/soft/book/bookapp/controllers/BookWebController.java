package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class BookWebController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/list", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    public String listBook(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "bookList";
    }
}
