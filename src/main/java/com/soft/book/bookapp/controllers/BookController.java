package com.soft.book.bookapp.controllers;

import com.soft.book.bookapp.converters.BookConverter;
import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping(value = "/books")
    public List<BookDto> findAllBooks() {
        return bookService.findAll();
    }

    @GetMapping(value = "/book/id={id}")
    public BookDto bookById(@PathVariable Long id) {
        BookDto bookDto = bookService.findBookById(id);
        return bookDto;
    }

    @GetMapping(value = "/book/isbn={isbn}")
    public BookDto bookByISBN(@PathVariable String isbn) {
        BookDto bookDto = bookService.findBookByIsbn(isbn);
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

    @PostMapping(value = "/books", consumes = "application/json", produces = "application/json")
    private ResponseEntity<Book> addBook(@RequestBody BookDto bookDto, UriComponentsBuilder uriComponents) {
        if (bookDto != null) {
            Book book = bookService.saveBook(bookDto);
            HttpHeaders httpHeaders = new HttpHeaders();
            URI locationURI =
                    uriComponents.path("/book/id=")
                    .path(String.valueOf(book.getId()))
                    .build()
                    .toUri();
            httpHeaders.setLocation(locationURI);
            return new ResponseEntity<Book>(book, httpHeaders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
