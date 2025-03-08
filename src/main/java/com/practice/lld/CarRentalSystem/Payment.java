package com.practice.lld.CarRentalSystem;

public class Payment {
	
	@Override
	public String toString() {
		return "Payment [paymnetid=" + paymnetid + ", bill=" + bill + ", status=" + status + "]";
	}
	int paymnetid;
	Bill bill;
	PaymentStatus status;
	public int getPaymnetid() {
		return paymnetid;
	}
	public void setPaymnetid(int paymnetid) {
		this.paymnetid = paymnetid;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public Payment(int paymnetid, Bill bill) {
		this.paymnetid = paymnetid;
		this.bill = bill;
		this.status = PaymentStatus.INITIATED;
	}
	
	
}
