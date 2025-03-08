package com.practice.lld.bookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theatre {
	
	int tid;
	String tname;
	String city;
	List<Screen> screens;
	List<Show> shows;

	public Theatre(int tid, String tname, String city) {
		this.tid = tid;
		this.tname = tname;
		this.city = city;
		this.screens = new ArrayList<>();
		this.shows = new ArrayList<>();
	}

	public int getTid() {
		return tid;
	}

	@Override
	public String toString() {
		return "Theatre [tid=" + tid + ", tname=" + tname + ", city=" + city + "]";
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	public void addShow(Show show) {
		this.shows.add(show);
	}
	
	public void addScreen(Screen screen) {
		this.screens.add(screen);
	}
	
	public void addSeats(int scid, List<Seat> seats) {
		Screen screen = getScreen(scid);
		if (screen != null) {
			for (Seat seat : seats) {
				screen.addSeat(seat);
			}
		}
		else {
			System.out.println(" screen : " + scid + " is not present in theatre : " + this.tid);
		}
	}

	private Screen getScreen(int scid) {
		for (Screen sc : screens) {
			if (scid == sc.scid)
				return sc;
		}
		return null;
	}
	
	public List<Show> getShowsWithMovie(String movie){
		List<Show> shs = new ArrayList<>();
		for (Show show : shows) {
			if (movie.equals(show.movie.mname))
				shs.add(show);
		}
		return shs;
	}
	
	public void getPricesOfShow(int shid) {
		Show show = getShow(shid);
		if (show != null) {
			show.getPricesOfShow();
		}
		else {
			System.out.println(" there is no show : " + shid + " in theatre : " + this.tid);
		}
	}

	private Show getShow(int shid) {
		for (Show show : shows) {
			if (shid == show.shid)
				return show;
		}
		return null;
	}
	
	public Booking bookSeats(int shid, int bid, Map<SeatCategory, Integer> reqSeats) {
		Show show = getShow(shid);
		if (show != null) {
			return show.bookSeat(bid, reqSeats);
		}
		else {
			System.out.println(" there is no show : " + shid + " in theatre : " + this.tid);
			return null;
		}
	}
	
	public void showSeatAvailabiity(int shid) {
		Show show = getShow(shid);
		if (show != null) {
			show.showSeatAvailability();
		}
		else {
			System.out.println(" there is no show : " + shid + " in theatre : " + this.tid);
		}
	}
	
	public void showBookedSeats(int shid) {
		Show show = getShow(shid);
		if (show != null) {
			show.showBookedSeats();
		}
		else {
			System.out.println(" there is no show : " + shid + " in theatre : " + this.tid);
		}
	}
}
