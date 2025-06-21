package com.assignment.lms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.lms.entity.Member;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

}
