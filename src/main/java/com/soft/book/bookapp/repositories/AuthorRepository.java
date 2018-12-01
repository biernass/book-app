package com.soft.book.bookapp.repositories;

import com.soft.book.bookapp.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    public Author findDAuthorByFirstNameAndAndLastName(String firstName, String lastName);

}
