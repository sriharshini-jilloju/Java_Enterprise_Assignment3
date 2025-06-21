package com.assignment.lms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.lms.entity.Borrow;

@Repository
public interface BorrowRepository extends ReactiveMongoRepository<Borrow, String>{

}
