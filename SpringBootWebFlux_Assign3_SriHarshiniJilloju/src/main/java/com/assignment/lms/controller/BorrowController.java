package com.assignment.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lms.dto.BorrowDto;
import com.assignment.lms.entity.Borrow;
import com.assignment.lms.service.BorrowService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BorrowController {

	@Autowired
	BorrowService borrowService;

	@GetMapping("/get-borrows")
	public Flux<Borrow> getBorrows() {
		return borrowService.getBorrows();
	}

	@PostMapping("/save-borrow")
	public Mono<Borrow> saveBorrow(@RequestBody Borrow borrow) {
		return borrowService.saveBorrow(borrow);
	}

	@GetMapping("/get-borrow")
	public Mono<BorrowDto> getBorrow(@RequestParam("id") String id) {
		return borrowService.getBorrow(id);
	}
}
