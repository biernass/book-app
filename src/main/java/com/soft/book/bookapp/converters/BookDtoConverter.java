package com.soft.book.bookapp.converters;

import com.soft.book.bookapp.dto.BookDto;
import com.soft.book.bookapp.entities.Book;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookDtoConverter implements Function<Book, BookDto> {

    @Override
    public BookDto apply(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setAuthor(book.getAuthor().getAuthorName());
        bookDto.setBookCategoryType(book.getBookCategoryType().name());
        bookDto.setId(book.getId());
        bookDto.setISBN(book.getISBN());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublisher(book.getPublisher());
        bookDto.setTitle(book.getTitle());
        bookDto.setInStock(book.getInStock());
        return bookDto;
    }
}
