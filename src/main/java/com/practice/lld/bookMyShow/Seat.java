package com.practice.lld.bookMyShow;

public abstract class Seat {
	
	int sid;
	int price;
	int row;
	SeatCategory seatCategory;
	
	public Seat(int sid, int row, int price, SeatCategory category) {
		this.sid = sid;
		this.row = row;
		this.price = price;
		this.seatCategory = category;
	}
	
	public int getSid() {
		return sid;
	}

	public int getPrice() {
		return price;
	}

	public int getRow() {
		return row;
	}

	public SeatCategory getSeatCategory() {
		return seatCategory;
	}

	@Override
	public String toString() {
		return "Seat [sid=" + sid + ", price=" + price + ", row=" + row + ", seatCategory=" + seatCategory + "]";
	}
	
	
}
