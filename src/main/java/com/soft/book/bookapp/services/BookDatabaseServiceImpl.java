package com.soft.book.bookapp.services;

import com.soft.book.bookapp.converters.BookDtoConverter;
import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookDatabaseServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDtoConverter bookDtoConverter;


    @Override
    public List<BookDto> findAll() {
        Iterable<Book> books = bookRepository.findAll();
        return StreamSupport.stream(books.spliterator(), true)
                .map(bookDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return bookDtoConverter.apply(book);
        } else {
            throw new BookNotFoundException(id);
        }
    }
}
