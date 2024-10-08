package com.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Investment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentId;
	private String category;
	private String issuer;
	private float quantity;
	private float unitCost;
	private Date investmentDate;
	private Date maturityDate;
	private float maturityUnitPrice;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Investment() {
		super();
	}
	public Investment(String category, String issuer, float quantity, float unitCost, Date investmentDate,
			Date maturityDate, float maturityUnitPrice, String description) {
		super();
		this.category = category;
		this.issuer = issuer;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.investmentDate = investmentDate;
		this.maturityDate = maturityDate;
		this.maturityUnitPrice = maturityUnitPrice;
		this.description = description;
	}
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	public Date getInvestmentDate() {
		return investmentDate;
	}
	public void setInvestmentDate(Date investmentDate) {
		this.investmentDate = investmentDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public float getMaturityUnitPrice() {
		return maturityUnitPrice;
	}
	public void setMaturityUnitPrice(float maturityUnitPrice) {
		this.maturityUnitPrice = maturityUnitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
