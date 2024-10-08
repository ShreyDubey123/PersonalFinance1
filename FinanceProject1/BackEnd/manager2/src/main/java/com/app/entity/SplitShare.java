package com.app.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SplitShare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int splitId;
	private float shareAmount;
	@ManyToOne
    @JoinColumn(name = "lending_id")
    private Lending lending;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public int getSplitId() {
		return splitId;
	}
	public void setSplitId(int splitId) {
		this.splitId = splitId;
	}
	public float getShareAmount() {
		return shareAmount;
	}
	public void setShareAmount(float shareAmount) {
		this.shareAmount = shareAmount;
	}
	public Lending getLending() {
		return lending;
	}
	public void setLending(Lending lending) {
		this.lending = lending;
	}
	public User getUser() {
		return user;
	}
	public void setUsers(User user) {
		this.user = user;
	}
	

}
