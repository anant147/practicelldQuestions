package com.practice.lld.bookMyShow;

public class Payment {
	
	int pid;
	PaymentStatus paymentStatus;
	
	public Payment(int pid) {
		this.pid = pid;
		this.paymentStatus = PaymentStatus.INITIATED;
	}
	
	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", paymentStatus=" + paymentStatus + "]";
	}

	public void doPayment(int amount) {
		this.paymentStatus = PaymentStatus.SUCCESS;
		System.out.println("Payment of " + amount + " is done");
	}
}
