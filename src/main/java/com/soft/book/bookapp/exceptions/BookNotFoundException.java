package com.soft.book.bookapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book with id: " + id + " not exist");
    }

    public BookNotFoundException(String ISBN) {
        super("Book with ISBN: " + ISBN + " not exist");
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
