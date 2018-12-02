package com.soft.book.bookapp.repositories;

import com.soft.book.bookapp.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findAuthorByFirstNameAndAndLastName(String firstName, String lastName);

}
