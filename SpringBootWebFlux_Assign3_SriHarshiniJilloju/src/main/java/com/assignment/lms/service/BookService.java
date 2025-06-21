package com.assignment.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.assignment.lms.dto.BookDto;
import com.assignment.lms.entity.Book;
import com.assignment.lms.entity.Borrow;
import com.assignment.lms.entity.Publisher;
import com.assignment.lms.repository.BookRepository;
import com.assignment.lms.repository.BorrowRepository;
import com.assignment.lms.repository.PublisherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	PublisherRepository publisherRepo;

	@Autowired
	BorrowRepository borrowRepo;

	public Flux<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Mono<Book> saveBook(Book book) {
		return bookRepo.save(book).flatMap(savedBook -> {
			String publisherId = savedBook.getPublisherId();

			return publisherRepo.findById(publisherId).flatMap(publisher -> {
				List<String> bookIds = Optional.ofNullable(publisher.getBookIds()).orElse(new ArrayList<>());

				if (!bookIds.contains(savedBook.getId())) {
					bookIds.add(savedBook.getId());
					publisher.setBookIds(bookIds);
					return publisherRepo.save(publisher);
				} else {
					return Mono.just(publisher);
				}
			}).thenReturn(savedBook);
		});
	}

	public Mono<BookDto> getBook(String id) {
		return bookRepo.findById(id).flatMap(book -> {
			Mono<Publisher> publisherMono = publisherRepo.findById(book.getPublisherId());
			Flux<Borrow> borrowFlux = Flux.fromIterable(Optional.ofNullable(book.getBorrowIds()).orElse(List.of()))
					.flatMap(borrowRepo::findById);

			return Mono.zip(publisherMono, borrowFlux.collectList())
					.map(tuple -> new BookDto(book, tuple.getT1(), tuple.getT2()));
		});
	}

}
