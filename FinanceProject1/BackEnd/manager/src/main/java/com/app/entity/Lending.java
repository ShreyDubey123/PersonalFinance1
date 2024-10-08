package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lendingId;
	private int expenditureId;
	private int byUserId;
	private int toUserId;
	private int groupId; //for non-group transaction groupId=0
	public Lending(int expenditureId, int byUserId, int toUserId, int groupId) {
		super();
		this.expenditureId = expenditureId;
		this.byUserId = byUserId;
		this.toUserId = toUserId;
		this.groupId = groupId;
	}
	public int getLendingId() {
		return lendingId;
	}

	public void setLendingId(int lendingId) {
		this.lendingId = lendingId;
	}

	public int getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(int expenditureId) {
		this.expenditureId = expenditureId;
	}
	public int getByUserId() {
		return byUserId;
	}
	public void setByUserId(int byUserId) {
		this.byUserId = byUserId;
	}
	public int getToUserId() {
		return toUserId;
	}
	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
