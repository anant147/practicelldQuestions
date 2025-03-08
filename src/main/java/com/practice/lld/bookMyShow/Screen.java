package com.practice.lld.bookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
	
	int scid;
	Map<SeatCategory, List<Seat>> seatMap;
	
	public Screen(int scid){
		this.scid = scid;
		this.seatMap = new HashMap<>();
	}
	
	public void addSeat(Seat seat) {
		SeatCategory sc = seat.seatCategory;
		List<Seat> seats = new ArrayList<>();
		if (!seatMap.containsKey(sc)) {
			seatMap.put(sc, seats);
		}
		else {
			seats = seatMap.get(sc);
		}
		seats.add(seat);
	}
	
	public void addSeats(List<Seat> seats) {
		for (Seat seat : seats) {
			addSeat(seat);
		}
	}
	
	public void showSeatCategory() {
		System.out.println(" seat categories :- ");
		for (SeatCategory sc : seatMap.keySet()) {
			System.out.print(sc + " ");
		}
		System.out.println();
	}
	
	public void showAllSeats() {
		System.out.println("all seats :- ");
		
		for (SeatCategory sc : seatMap.keySet()) {
			List<Seat> seats = seatMap.get(sc);
			for (Seat st : seats) {
				System.out.println(st);
			}
		}
		
	}
}
