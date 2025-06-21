package com.assignment.lms.dto;


import com.assignment.lms.entity.Book;
import com.assignment.lms.entity.Borrow;
import com.assignment.lms.entity.Member;

public class BorrowDto {

	private Borrow borrow;
	private Member member;
	private Book book;

	public BorrowDto() {
		super();
	}

	public BorrowDto(Borrow borrow, Member member, Book book) {
		super();
		this.borrow = borrow;
		this.member = member;
		this.book = book;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}