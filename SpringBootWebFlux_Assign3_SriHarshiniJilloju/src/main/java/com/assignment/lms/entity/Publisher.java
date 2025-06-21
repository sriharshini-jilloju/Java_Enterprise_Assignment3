package com.assignment.lms.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publishers")
public class Publisher {

	@Id
	private String id;

	private String name;
	private String address;

	private List<String> bookIds;

	public Publisher() {
		super();
	}

	public Publisher(String id, String name, String address, List<String> bookIds) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.bookIds = bookIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<String> bookIds) {
		this.bookIds = bookIds;
	}

}
