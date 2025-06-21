package com.assignment.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lms.entity.Member;
import com.assignment.lms.service.MemberService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/get-members")
	public Flux<Member> getMembers() {
		return memberService.getMembers();
	}

	@PostMapping("/save-member")
	public Mono<Member> saveMember(@RequestBody Member member) {
		return memberService.saveMember(member);
	}

	@GetMapping("/get-member")
	public Mono<Member> getMember(@RequestParam("id") String id) {
		return memberService.getMember(id);
	}

}
