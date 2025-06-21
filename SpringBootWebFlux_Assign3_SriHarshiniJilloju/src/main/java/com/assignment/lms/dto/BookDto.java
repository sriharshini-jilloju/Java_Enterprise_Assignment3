package com.assignment.lms.dto;

import java.util.List;

import com.assignment.lms.entity.Book;
import com.assignment.lms.entity.Borrow;
import com.assignment.lms.entity.Publisher;

public class BookDto {
	
	private Book book;
	private Publisher publisher;
	private List<Borrow> borrows;
	
	public BookDto() {
		super();
	}

	public BookDto(Book book, Publisher publisher, List<Borrow> borrows) {
		super();
		this.book = book;
		this.publisher = publisher;
		this.borrows = borrows;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}
	
	
	
}
