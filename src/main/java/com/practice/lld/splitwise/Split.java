package com.practice.lld.splitwise;

public class Split {
	
	User user;
	double amount;
	int percentage;
	public Split(User user, double amount, int percentage) {
		super();
		this.user = user;
		this.amount = amount;
		this.percentage = percentage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Split [user=" + user + ", amount=" + amount + ", percentage=" + percentage + "]";
	}
	
	
}
