package com.soft.book.bookapp.services;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.exceptions.BookNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BookService {

     List<BookDto> findAll();

     BookDto findBookById(Long id);
}
