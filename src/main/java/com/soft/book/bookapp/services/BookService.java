package com.soft.book.bookapp.services;

import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {

     List<Book> findAll();

     //Book findById(Long id) throws BookNotFoundException;
}
