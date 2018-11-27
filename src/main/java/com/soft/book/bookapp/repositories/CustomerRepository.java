package com.soft.book.bookapp.repositories;

import com.soft.book.bookapp.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
