package com.app.entity;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incomeId;
	private String incomeSource;
	private float incomeAmount;
	private String Description;
	private String modeOfPayment;
	private Date date;
	private LocalTime time;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne(mappedBy = "income", cascade = CascadeType.ALL)
    private Borrowing borrowing;
	
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Borrowing getBorrowing() {
		return borrowing;
	}
	public void setBorrowing(Borrowing borrowing) {
		this.borrowing = borrowing;
		if (borrowing != null) {
            borrowing.setIncome(this);
		}
	}
	public float getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(float incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	
}
