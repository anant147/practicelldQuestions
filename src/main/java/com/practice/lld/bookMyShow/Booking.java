package com.practice.lld.bookMyShow;

import java.util.Map;

public class Booking {
	
	int bid;
	Payment payment;
	Show show;
	int amount;
	
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", payment=" + payment + ", show=" + show.shid + ", amount=" + amount + "]";
	}

	Map<SeatCategory, Integer> seatMap;
	
	public Booking(int bid, Show show, int amount, Map<SeatCategory, Integer> seatMap) {
		this.bid = bid;
		this.show = show;
		this.amount = amount;
		this.seatMap = seatMap;
		this.payment = new Payment(bid);
	}
	
	public void doPayment() {
		payment.doPayment(amount);
	}
	
	
}
