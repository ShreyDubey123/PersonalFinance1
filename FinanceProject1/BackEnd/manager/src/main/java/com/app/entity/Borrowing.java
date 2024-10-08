package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Borrowing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;
	private int userId;
	private int borrowedFrom; //if from registered friend, then friendId else 0 
	private String name; //if from registered friend, then friend name else issuer name
	private float amount;
	private String description;
	private String location;
	private int transactionMode; //1:cash, 2:BankAccount 
	private Date date;
	private Time time;
	public Borrowing(int userId, int borrowedFrom, String name, float amount, String description, String location,
			int transactionMode, Date date, Time time) {
		super();
		this.userId = userId;
		this.borrowedFrom = borrowedFrom;
		this.name = name;
		this.amount = amount;
		this.description = description;
		this.location = location;
		this.transactionMode = transactionMode;
		this.date = date;
		this.time = time;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBorrowedFrom() {
		return borrowedFrom;
	}
	public void setBorrowedFrom(int borrowedFrom) {
		this.borrowedFrom = borrowedFrom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(int transactionMode) {
		this.transactionMode = transactionMode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}
