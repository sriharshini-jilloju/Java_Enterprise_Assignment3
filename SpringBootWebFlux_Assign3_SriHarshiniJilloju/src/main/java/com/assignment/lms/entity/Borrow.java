package com.assignment.lms.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "borrows")
public class Borrow {

	@Id
	private String id;

	private Date dueDate;
	private Date returnDate;
	private Date issueDate;

	private String bookId;
	private String memberId;

	public Borrow() {
		super();
	}

	public Borrow(Date dueDate, Date returnDate, Date issueDate, String bookId, String memberId) {
		super();
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.issueDate = issueDate;
		this.bookId = bookId;
		this.memberId = memberId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}