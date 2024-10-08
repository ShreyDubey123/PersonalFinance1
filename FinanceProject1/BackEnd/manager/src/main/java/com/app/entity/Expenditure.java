package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;

@Entity
public class Expenditure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenditureId;
	private int userId;
	private float amount;
	private String description;
	private String category;
	private String subCategory;
	private String location;
	private int transactionMode; //1:cash, 2:Bank Account(Online)
	private Date date;
	private Time time;
	private int groupId;
	
	public Expenditure(int userId, float amount, String description, String category, String subCategory,
			String location, int transactionMode, Date date, Time time, int groupId) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.location = location;
		this.transactionMode = transactionMode;
		this.date = date;
		this.time = time;
		this.groupId = groupId;
	}
	public int getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(int expenditureId) {
		this.expenditureId = expenditureId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
