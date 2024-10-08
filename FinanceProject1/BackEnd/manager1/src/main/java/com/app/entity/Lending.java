package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Lending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lendingId;
	@OneToOne
    @JoinColumn(name = "expenditure_id")
    private Expenditure expenditure;
	private String lendCategory; //user/group/non-user
	@OneToMany(mappedBy = "lending", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SplitShare> splitShares = new ArrayList<>();
	@ManyToOne
    @JoinColumn(name = "group_id")
    private UserGroup userGroup;
	
	public int getLendingId() {
		return lendingId;
	}
	public void setLendingId(int lendingId) {
		this.lendingId = lendingId;
	}
	public Expenditure getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(Expenditure expenditure) {
		this.expenditure = expenditure;
	}
	public String getLendCategory() {
		return lendCategory;
	}
	public void setLendCategory(String lendCategory) {
		this.lendCategory = lendCategory;
	}
	public List<SplitShare> getSplitShares() {
		return splitShares;
	}
	public void setSplitShares(List<SplitShare> splitShares) {
		this.splitShares = splitShares;
		for (SplitShare splitShare : splitShares) {
            splitShare.setLending(this);
        }
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	
	
}
