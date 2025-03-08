package com.practice.lld.bookMyShow;

public class NormalSeat extends Seat {

	public NormalSeat(int sid, int row, SeatInfo seatInfo) {
		super(sid, row, seatInfo.price, SeatCategory.NORMAL );
	}

}
