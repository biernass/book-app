package com.soft.book.bookapp.converters;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Author;
import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookConverter implements Function<BookDto, Book> {

    @Override
    public Book apply(BookDto bookDto) {
        Book book = new Book();
        book.setId(null);
        book.setTitle(bookDto.getTitle());
        book.setAuthor(new Author(bookDto.authorFirstAndLastNameInArray()[0], bookDto.authorFirstAndLastNameInArray()[1]));
        book.setBookCategoryType(BookCategoryType.valueOf(bookDto.getBookCategoryType()));
        book.setIsbn(bookDto.getISBN());
        book.setPrice(bookDto.getPrice());
        book.setPublisher(bookDto.getPublisher());
        book.setInStock(bookDto.getInStock());
        return book;
    }
}
