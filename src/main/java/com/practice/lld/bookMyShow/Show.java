package com.practice.lld.bookMyShow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Show {
	
	int shid;
	Screen screen;
	Movie movie;
	int startTime;
	Map<SeatCategory, Set<Integer>> availableSeats;
	Map<SeatCategory, Set<Integer>> bookedSeats;
	Map<SeatCategory, Integer> seatPrices;
	
	public Show(int shid, Screen screen, Movie movie) {
		this.shid = shid;
		this.screen = screen;
		this.movie = movie;
		this.availableSeats = new HashMap<>();
		this.bookedSeats = new HashMap<>();
		this.seatPrices = new HashMap<>();
		fillAvailableSeats(screen);
		fillSeatPrices(screen);
	}

	private void fillSeatPrices(Screen screen2) {
		Map<SeatCategory, List<Seat>> seatMap = screen.seatMap;
		for (SeatCategory sc : seatMap.keySet()) {
			Seat seat = seatMap.get(sc).get(0);
			seatPrices.put(sc, seat.price);
		}
	}

	@Override
	public String toString() {
		return "Show [shid=" + shid + ", screen=" + screen.scid + ", movie=" + movie.getMname() + ", startTime=" + startTime + "]";
	}

	private void fillAvailableSeats(Screen screen) {
		Map<SeatCategory, List<Seat>> seatMap = screen.seatMap;
		for (SeatCategory sc : seatMap.keySet()) {
			List<Seat> seats = seatMap.get(sc);
			Set<Integer> sids = new HashSet<>();
			seats.forEach( seat -> sids.add(seat.getSid()));
			availableSeats.put(sc, sids);
		}
	}
	
	public void bookAvailableSeat(int sid, SeatCategory category) {
		if (availableSeats.containsKey(category)) {
			Set<Integer> available = availableSeats.get(category);
			if (available.contains(sid)) {
				available.remove(sid);
				bookSeat(sid, category);
			}
			else {
				Set<Integer> booked = bookedSeats.get(category);
				if (booked != null && booked.size()>0 && booked.contains(sid)) {
					System.out.println("show : " + shid +  " seat : " + sid + " of category : " + category + " is already booked, cannot be booked again");
				}
				else {
					System.out.println(" shid : " + shid + ", seat : " + sid + " of category : " + category + " not available");
				}
			}
		}
		else {
			System.out.println(" seats of type : " + category + " not available");
		}
	}

	private void bookSeat(int sid, SeatCategory category) {
		Set<Integer> seats = new HashSet<>();
		if (bookedSeats.containsKey(category))
			seats = bookedSeats.get(category);
		else
			bookedSeats.put(category, seats);
		
		seats.add(sid);
		System.out.println("show : " + shid +  " seat : " + sid + " of category : " + category + " is booked");
	}
	
	public Booking bookSeat(int bid, Map<SeatCategory, Integer> reqSeats) {
		for (SeatCategory sc : reqSeats.keySet()) {
			int val = reqSeats.get(sc);
			 if (!isSeatsAvailable(sc, val)) {
				 return null;
			 }
		}
		
		int amount = 0;
		for (SeatCategory sc : reqSeats.keySet()) {
			int val = reqSeats.get(sc);
			int price = seatPrices.get(sc);
			
			Set<Integer> set = availableSeats.get(sc);
			Set<Integer> nset = new HashSet<>(set);
			int count = 0;
			for (Integer i : nset) {
				bookAvailableSeat(i, sc);
				count++;
				if (count == val)
					break;
			}
			amount += (val * price);
			System.out.println( val + " seats of category :  " + sc + " are booked");
		}
		
		return new Booking( bid, this,  amount, reqSeats);
	}
	
	private boolean isSeatsAvailable(SeatCategory sc, int val) {
		if (availableSeats.containsKey(sc)) {
			int avseats = availableSeats.get(sc).size();
			if (avseats < val) {
				System.out.println(" seat category : " + sc + " , available : " + avseats + " is less than req : " + val);
				return false;
			}
			return true;
		}
		else {
			System.out.println(" seat of category : " + sc + " not available.");
			return false;
		}
	}

	public void showSeatAvailability() {
		System.out.println(" for show : " + shid + ", availability of seats : ");
		
		for (SeatCategory sc : availableSeats.keySet()) {
			Set<Integer> set = availableSeats.get(sc);
			System.out.println("Seat Category : " + sc + " , count of available seats : " + set.size());
			if (set.size()>0) {
				System.out.print("available seat : ");
				for (Integer i : set) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}
	
	public void showBookedSeats() {
		System.out.println(" for show : " + shid + ", booked seats : ");
		
		if (bookedSeats.size()==0) {
			System.out.println("no seat has been booked for now");
		}
		for (SeatCategory sc : bookedSeats.keySet()) {
			Set<Integer> set = bookedSeats.get(sc);
			System.out.println("Seat Category : " + sc + " , count of booked seats : " + set.size());
			if (set.size()>0) {
				System.out.print("booked seat : ");
				for (Integer i : set) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}
	
	public void getPricesOfShow() {
		for (SeatCategory sc : seatPrices.keySet()) {
			System.out.println( sc + " : " + seatPrices.get(sc));
		}
	}
}
