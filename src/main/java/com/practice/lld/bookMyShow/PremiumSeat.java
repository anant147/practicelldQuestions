package com.practice.lld.bookMyShow;

public class PremiumSeat extends Seat {

	public PremiumSeat(int sid, int row, SeatInfo seatInfo) {
		super(sid, row, seatInfo.price, SeatCategory.PREMIUM );
	}
}
