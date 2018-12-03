package com.soft.book.bookapp.services;

import com.soft.book.bookapp.converters.BookConverter;
import com.soft.book.bookapp.converters.BookDtoConverter;
import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Author;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;
import com.soft.book.bookapp.exceptions.BookNotFoundException;
import com.soft.book.bookapp.repositories.AuthorRepository;
import com.soft.book.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookDatabaseServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookDtoConverter bookDtoConverter;

    @Autowired
    private BookConverter bookConverter;


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
            throw new BookNotFoundException("Book with id: " + id + " not found");
        }
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        Optional<Book> bookOptional = bookRepository.findBookByIsbn(isbn);
        if (bookOptional.isPresent()) {
            return bookDtoConverter.apply(bookOptional.get());
        } else {
            throw new BookNotFoundException("Book with ISBN: " + isbn + " not found");
        }
    }

    @Override
    public List<BookDto> findBooksByCategory(BookCategoryType bookCategoryType) {
        Iterable<Book> books = bookRepository.findAllByBookCategoryType(bookCategoryType);
        List<BookDto> bookDtoList = StreamSupport.stream(books.spliterator(), true)
                .map(bookDtoConverter)
                .collect(Collectors.toList());

        if (bookDtoList.size() == 0) {
            throw new BookNotFoundException("Any book in category: " + bookCategoryType.name());
        }
        return bookDtoList;
    }

    @Override
    public Book saveBook(BookDto bookDto) {

        Optional<Author> author = authorRepository.findAuthorByFirstNameAndAndLastName
                (bookDto.authorFirstAndLastNameInArray()[0],
                        bookDto.authorFirstAndLastNameInArray()[1]);

        if (author.isPresent()) {
            Book book = bookConverter.apply(bookDto);
            authorRepository.save(author.get());
            book.setAuthor(author.get());
            return bookRepository.save(book);

        } else {
            return bookRepository.save(bookConverter.apply(bookDto));
        }
    }

    @Override
    public Book update(Long id, BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Optional<Author> author = authorRepository.findAuthorByFirstNameAndAndLastName
                (bookDto.authorFirstAndLastNameInArray()[0],
                        bookDto.authorFirstAndLastNameInArray()[1]);
        if (bookOptional.isPresent()) {
            Book book = bookConverter.apply(bookDto);
            authorRepository.save(author.get());
            book.setAuthor(author.get());
            book.setId(id);
            return bookRepository.save(book);
        } else {
            throw new BookNotFoundException("Cannot update book with id: " + id + " because book with this id not exist");
        }
    }
}

