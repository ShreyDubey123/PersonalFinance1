package com.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Investment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentId;
	private int userId;
	private String category;
	private String issuer;
	private float quantity;
	private float unitPrice;
	private Date investmentDate;
	private Date maturityDate;
	private float maturityUnitprice;
	private String description;
	public Investment(int userId, String category, String issuer, float quantity, float unitPrice, Date investmentDate,
			Date maturityDate, float maturityUnitprice, String description) {
		super();
		this.userId = userId;
		this.category = category;
		this.issuer = issuer;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.investmentDate = investmentDate;
		this.maturityDate = maturityDate;
		this.maturityUnitprice = maturityUnitprice;
		this.description = description;
	}
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
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
	public float getMaturityUnitprice() {
		return maturityUnitprice;
	}
	public void setMaturityUnitprice(float maturityUnitprice) {
		this.maturityUnitprice = maturityUnitprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
