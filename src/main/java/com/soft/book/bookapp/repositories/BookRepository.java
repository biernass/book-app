package com.soft.book.bookapp.repositories;

import com.soft.book.bookapp.entities.Book;
import com.soft.book.bookapp.entities.BookCategoryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findBookByIsbn(String isbn);

    Iterable<Book> findAllByBookCategoryType(BookCategoryType bookCategoryType);

}
