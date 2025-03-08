package com.practice.lld.splitwise;

import java.util.List;

public class Expense {
	
	int eid;
	String description;
	double amount;
	User paidBy;
	SplitType splitType;
	List<Split> splits;
	public Expense(int eid, String description, double amount, User paidBy, SplitType splitType,
			List<Split> splits) {
		this.eid = eid;
		this.description = description;
		this.amount = amount;
		this.paidBy = paidBy;
		this.splitType = splitType;
		this.splits = splits;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}
	public SplitType getSplitType() {
		return splitType;
	}
	public void setSplitType(SplitType splitType) {
		this.splitType = splitType;
	}
	public List<Split> getSplits() {
		return splits;
	}
	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}
	@Override
	public String toString() {
		return "Expense [eid=" + eid + ", description=" + description + ", amount=" + amount + ", paidBy=" + paidBy
				+ ", splitType=" + splitType + ", splits=" + splits + "]";
	}
	
	
}
