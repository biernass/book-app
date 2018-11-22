package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Controller
public class BookWebController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/book-web/list", produces = MediaType.TEXT_HTML_VALUE)
    public String listBook(Model model){
        List<BookDto> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "bookList";
    }

    @GetMapping(value = "book-web/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String bookById(@PathVariable Long id, Model model){
        try {
            BookDto book = bookService.findBookById(id);
            model.addAttribute("book", book);
        } catch (BookNotFoundException e) {
           String message =  messageSource.getMessage("book.failure.search.message",
                    new Object[]{id}, Locale.getDefault());
            model.addAttribute("messageModel", message);

            return "redirect:/message?msg=" + message;
        }
        return "book";
    }



}
