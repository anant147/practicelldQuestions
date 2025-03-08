package com.practice.lld.bookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
	
	Map<String, List<Theatre>> theatreMap;
	List<Theatre> allTheatres;
	Map<Integer, Theatre> tmap;
	
	public TheatreController() {
		this.theatreMap = new HashMap<>();
		this.allTheatres = new ArrayList<>();
		this.tmap = new HashMap<>();
	}
	
	public void addTheatre(Theatre theatre) {
		String city = theatre.city;
		List<Theatre> theatres = new ArrayList<>();
		if (!theatreMap.containsKey(city)) {
			theatreMap.put(city, theatres);
		}
		else {
			theatres = theatreMap.get(city);
		}
		theatres.add(theatre);
		
		if (!allTheatres.contains(theatre)) {
			allTheatres.add(theatre);
			tmap.put(theatre.tid, theatre);
		}
	}
	
	public void showAllTheatres() {
		System.out.println(" show all theatres : ");
		printThreatres(allTheatres);
	}

	private void printThreatres(List<Theatre> ths) {
		for (Theatre th : ths) {
			System.out.println(th);
		}
	}
	
	public void showAllTheatresInCity(String city) {
		if (theatreMap.containsKey(city)) {
			System.out.println(" showing all theatres in city : " + city);
			printThreatres(theatreMap.get(city));
		}
		else {
			System.out.println(" there is no theatre in city : " + city);
		}
	}
	
	public void addScreens(int tid, List<Screen> screens) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			for (Screen sc : screens) {
				t.addScreen(sc);
			}
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public void addShows(int tid, List<Show> shows) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			for (Show sh : shows) {
				t.addShow(sh);
			}
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public void addSeats(int tid, int scid, List<Seat> seats) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			t.addSeats(scid, seats);
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public void getShowWhichHasMovie(String city, String movie) {
		if (theatreMap.containsKey(city)) {
//			System.out.println(" get shows : ");
			List<Show> shows = new ArrayList<>();
			List<Theatre> ths = theatreMap.get(city);
//			System.out.println(" ths : " + ths.size() + ", city : " + city);
			for (Theatre th : ths) {
				shows.addAll(th.getShowsWithMovie(movie));
			}
			
//			System.out.println(" get shows : " + shows.size());
			
			System.out.println(" get show , city : " + city + " , movie : " + movie);
			for (Show sh : shows) {
				System.out.println(sh);
			}
			
		}
		else {
			System.out.println(" there is no theatre in city : " + city);
		}
	}
	
	public void getPricesofShow(int tid, int shid) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			t.getPricesOfShow(shid);
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public void showSeatAvaiability(int tid, int shid) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			t.showSeatAvailabiity(shid);
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public void showBookedSeats(int tid, int shid) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			t.showBookedSeats(shid);
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
		}
	}
	
	public Booking bookSeats(int tid, int shid, int bid, Map<SeatCategory, Integer> reqSeats) {
		if (tmap.containsKey(tid)) {
			Theatre t = tmap.get(tid);
			t.getPricesOfShow(shid);
			return t.bookSeats(shid, bid, reqSeats);
		}
		else {
			System.out.println(" theatre : " + tid + " does not exists");
			return null;
		}
	}
}
