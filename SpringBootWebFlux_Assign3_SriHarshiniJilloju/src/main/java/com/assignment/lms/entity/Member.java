package com.assignment.lms.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {

	@Id
	private String id;

	private String name;
	private String address;
	private Date memDate;
	private String memType;
	private Date expiryDate;

	List<String> borrowIds;

	public Member() {
		super();
	}

	public Member(String id, String name, String address, Date memDate, String memType, Date expiryDate,
			List<String> borrowIds) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.memDate = memDate;
		this.memType = memType;
		this.expiryDate = expiryDate;
		this.borrowIds = borrowIds;
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

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<String> getBorrowIds() {
		return borrowIds;
	}

	public void setBorrowIds(List<String> borrowIds) {
		this.borrowIds = borrowIds;
	}

}
