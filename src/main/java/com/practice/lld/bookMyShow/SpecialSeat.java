package com.practice.lld.bookMyShow;

public class SpecialSeat extends Seat {

	public SpecialSeat(int sid, int row, SeatInfo seatInfo) {
		super(sid, row, seatInfo.price, SeatCategory.SPECIAL );
	}

}
