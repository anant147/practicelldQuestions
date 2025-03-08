package com.practice.lld.bookMyShow;

import java.util.List;
import java.util.Map;

public class BookMyShow {
	
	MovieController movieController;
	TheatreController theatreController;
	
	public BookMyShow() {
		this.movieController = new MovieController();
		this.theatreController = new TheatreController();
	}
	
	public void addMovies(String city, List<Movie> movies) {
		for (Movie movie : movies) {
			this.movieController.addMovie(city, movie);
		}
	}
	
	public void showAllMovies() {
		movieController.showAllMovies();
	}
	
	public void showAllMoviesInCity(String city) {
		movieController.showMoviesInCity(city);
	}
	
	public void addTheates(List<Theatre> theatres) {
		for (Theatre theatre : theatres) {
			this.theatreController.addTheatre(theatre);
		}
	}
	
	public void showAllThreatres() {
		this.theatreController.showAllTheatres();
	}
	
	public void showAllTheatresInCity(String city) {
		this.theatreController.showAllTheatresInCity(city);
	}
	
	public void addScreensInTheatre(int tid, List<Screen> screens) {
		this.theatreController.addScreens(tid, screens);
	}
	
	public void addShowsInTheatre(int tid, List<Show> shows) {
		this.theatreController.addShows(tid, shows);
	}
	
	public void getShowWhichHasMovie(String city, String movie) {
		this.theatreController.getShowWhichHasMovie(city, movie);
	}
	
	
	public void getPricesofShow(int tid, int shid) {
		this.theatreController.getPricesofShow(tid, shid);
	}
	
	public Booking bookSeats(int tid, int shid, int bid, Map<SeatCategory, Integer> reqSeats) {
		return this.theatreController.bookSeats(tid, shid, bid, reqSeats);
	}
	
	public void doPayment(Booking booking) {
		booking.doPayment();
	}
	
	public void showSeatAvailability(int tid, int shid) {
		this.theatreController.showSeatAvaiability(tid, shid);
	}
	
	public void showBookedSeats(int tid, int shid) {
		this.theatreController.showBookedSeats(tid, shid);
	}
}
