package com.practice.lld.orderManagementSystem;

public class Invoice {
	
	int oid;
	double amount;
	int tax = 10;
	double totalAmount;
	
	public Invoice(int oid, double amount) {
		this.oid = oid;
		this.amount = amount;
		this.totalAmount = getTotalAmount(amount);
	}

	private double getTotalAmount(double amount) {
		return ((this.tax * amount)/100) + amount  ;
	}
}
