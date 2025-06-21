package com.assignment.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lms.dto.BookDto;
import com.assignment.lms.entity.Book;
import com.assignment.lms.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/get-books")
	public Flux<Book> getBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping("/save-book")
	public Mono<Book> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/get-book")
	public Mono<BookDto> getBook(@RequestParam("id") String id) {
		return bookService.getBook(id);
	}

}