package com.practice.lld.orderManagementSystem;

public class Payment {
	
	int oid;
	double amount;
	PaymentMode paymentMode;
	PaymentStatus paymentStatus;
	
	public Payment(int oid, double amount) {
		this.oid = oid;
		this.amount = amount;
		this.paymentMode = PaymentMode.CASH;
		this.paymentStatus = PaymentStatus.PENDING;
	}
	
	public void makePayment(PaymentMode mode) {
		this.paymentMode = mode;
		this.paymentStatus = PaymentStatus.SUCCESS;
		System.out.println(" payment mode : " + mode + " , amount : " + amount);
	}
}
