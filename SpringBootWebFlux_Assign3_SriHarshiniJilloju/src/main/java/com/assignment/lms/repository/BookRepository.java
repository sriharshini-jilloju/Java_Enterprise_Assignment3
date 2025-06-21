package com.assignment.lms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.lms.entity.Book;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

}
