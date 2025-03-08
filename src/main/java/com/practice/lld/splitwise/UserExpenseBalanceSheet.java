package com.practice.lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
	
	Map<User, Balance> friendsBalance;
	double totalExpense;
	double totalPayment;
	double totalOwe;
	double totalGetback;
	
	public UserExpenseBalanceSheet() {
		this.friendsBalance = new HashMap<>();
		this.totalExpense = 0;
		this.totalPayment = 0;
		this.totalGetback = 0;
		this.totalOwe = 0;
	}

	public Map<User, Balance> getFriendsBalance() {
		return friendsBalance;
	}

	public void setFriendsBalance(Map<User, Balance> friendsBalance) {
		this.friendsBalance = friendsBalance;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public double getTotalOwe() {
		return totalOwe;
	}

	public void setTotalOwe(double totalOwe) {
		this.totalOwe = totalOwe;
	}

	public double getTotalGetback() {
		return totalGetback;
	}

	public void setTotalGetback(double totalGetback) {
		this.totalGetback = totalGetback;
	}

	@Override
	public String toString() {
		return "UserExpenseBalanceSheet [friendsBalance=" + friendsBalance + ", totalExpense=" + totalExpense
				+ ", totalPayment=" + totalPayment + ", totalOwe=" + totalOwe + ", totalGetback=" + totalGetback + "]";
	}

}
