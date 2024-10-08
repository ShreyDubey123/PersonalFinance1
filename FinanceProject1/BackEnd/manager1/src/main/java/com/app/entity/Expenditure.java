package com.app.entity;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
public class Expenditure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenditureId;
	private float amount;
	private String description;
	private String category;
	private String subCategory;
	private String location;
	private int transactionMode; //1:cash, 2:Bank Account(Online)
	private Date date;
	private LocalTime time;
	
	@OneToOne(mappedBy = "expenditure", cascade = CascadeType.ALL)
    private Lending lending;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;
	
	public Expenditure() {
		super();
	}
	public Expenditure(float amount, String description, String category, String subCategory,
			String location, int transactionMode, Date date, LocalTime time) {
		super();
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.location = location;
		this.transactionMode = transactionMode;
		this.date = date;
		this.time = time;
	}
	public int getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(int expenditureId) {
		this.expenditureId = expenditureId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Lending getLending() {
		return lending;
	}
	public void setLending(Lending lending) {
		this.lending = lending;
		if (lending != null) {
            lending.setExpenditure(this);
        }
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
