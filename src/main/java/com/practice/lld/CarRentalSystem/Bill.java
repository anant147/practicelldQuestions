package com.practice.lld.CarRentalSystem;

public class Bill {
	
	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", reservation=" + reservation + ", amount=" + amount + ", isPaymentdone="
				+ isPaymentdone + "]";
	}

	int billid;
	Reservation reservation;
	int amount;
	boolean isPaymentdone;
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isPaymentdone() {
		return isPaymentdone;
	}
	public void setPaymentdone(boolean isPaymentdone) {
		this.isPaymentdone = isPaymentdone;
	}
	
	public Bill(int billid, Reservation reservation, int amount) {
		this.billid = billid;
		this.reservation = reservation;
		this.amount = amount;
		this.isPaymentdone = false;
	}
	
	
}
