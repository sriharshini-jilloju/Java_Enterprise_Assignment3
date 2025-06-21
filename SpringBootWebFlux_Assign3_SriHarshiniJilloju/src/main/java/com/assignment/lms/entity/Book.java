package com.assignment.lms.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

	@Id
	private String id;

	private String title;
	private String author;
	private Double price;
	private Boolean available;
	private String publisherId;
	private List<String> borrowIds;

	public Book() {
		super();
	}

	public Book( String title, String author, Double price, Boolean available, String publisherId,
			List<String> borrowIds) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.available = available;
		this.publisherId = publisherId;
		this.borrowIds = borrowIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public List<String> getBorrowIds() {
		return borrowIds;
	}

	public void setBorrowIds(List<String> borrowIds) {
		this.borrowIds = borrowIds;
	}

	

}
