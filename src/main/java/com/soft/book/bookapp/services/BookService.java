package com.soft.book.bookapp.services;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;

import java.util.List;

public interface BookService {

     List<BookDto> findAll();

     BookDto findBookById(Long id);

     BookDto findBookByIsbn(String isbn);

     List<BookDto> findBooksByCategory(BookCategoryType bookCategoryType);

     Book saveBook(BookDto bookDto);

}
