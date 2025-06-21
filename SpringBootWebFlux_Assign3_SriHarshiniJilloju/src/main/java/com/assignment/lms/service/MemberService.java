package com.assignment.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lms.entity.Member;
import com.assignment.lms.repository.MemberRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepo;

	public Flux<Member> getMembers() {
		return memberRepo.findAll();
	}

	public Mono<Member> saveMember(Member member) {
		return memberRepo.save(member);
		
	}

	public Mono<Member> getMember(String id) {
		return memberRepo.findById(id);
	}

}