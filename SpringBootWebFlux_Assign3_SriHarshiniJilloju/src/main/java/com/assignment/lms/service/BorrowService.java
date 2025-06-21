package com.assignment.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lms.dto.BorrowDto;
import com.assignment.lms.entity.Book;
import com.assignment.lms.entity.Borrow;
import com.assignment.lms.entity.Member;
import com.assignment.lms.repository.BookRepository;
import com.assignment.lms.repository.BorrowRepository;
import com.assignment.lms.repository.MemberRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BorrowService {

	@Autowired
	BorrowRepository borrowRepo;

	@Autowired
	BookRepository bookRepo;

	@Autowired
	MemberRepository memberRepo;

	public Flux<Borrow> getBorrows() {
		return borrowRepo.findAll();
	}

	public Mono<Borrow> saveBorrow(Borrow borrow) {
		return borrowRepo.save(borrow).flatMap(savedBorrow -> {

			String bookId = savedBorrow.getBookId();
			String memberId = savedBorrow.getMemberId();

			Mono<Book> bookUpdate = bookRepo.findById(bookId)
					.switchIfEmpty(Mono.error(new IllegalStateException("Book not found: " + bookId))).flatMap(book -> {
						List<String> borrowIds = Optional.ofNullable(book.getBorrowIds()).orElse(new ArrayList<>());
						if (!borrowIds.contains(savedBorrow.getId())) {
							borrowIds.add(savedBorrow.getId());
							book.setBorrowIds(borrowIds);
							return bookRepo.save(book);
						}
						return Mono.just(book);
					});

			Mono<Member> memberUpdate = memberRepo.findById(memberId)
					.switchIfEmpty(Mono.error(new IllegalStateException("Member not found: " + memberId)))
					.flatMap(member -> {
						List<String> borrowIds = Optional.ofNullable(member.getBorrowIds()).orElse(new ArrayList<>());
						if (!borrowIds.contains(savedBorrow.getId())) {
							borrowIds.add(savedBorrow.getId());
							member.setBorrowIds(borrowIds);
							return memberRepo.save(member);
						}
						return Mono.just(member);
					});

			return Mono.when(bookUpdate, memberUpdate).thenReturn(savedBorrow);
		});
	}

	public Mono<BorrowDto> getBorrow(String id) {
		return borrowRepo.findById(id).flatMap(borrow -> {
			Mono<Member> memberMono = memberRepo.findById(borrow.getMemberId());
			Mono<Book> bookMono = bookRepo.findById(borrow.getBookId());

			return Mono.zip(memberMono, bookMono).map(tuple -> new BorrowDto(borrow, tuple.getT1(), tuple.getT2()));
		});
	}

}
