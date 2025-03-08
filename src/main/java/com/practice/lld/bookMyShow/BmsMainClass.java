package com.practice.lld.bookMyShow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BmsMainClass {

	public static void main(String[] args) {
		
		BookMyShow bookMyShow = new BookMyShow();
		
		Movie movie1 = new Movie(1,"Gladiator", 180);
		Movie movie2 = new Movie(2, "Avenger", 200);
		Movie movie3 = new Movie(3, "Batman", 190);
		bookMyShow.addMovies("Noida", Arrays.asList(movie1, movie2 ));
		bookMyShow.addMovies("Delhi", Arrays.asList(movie1, movie3 ));
		
		bookMyShow.showAllMovies();
		bookMyShow.showAllMoviesInCity("Delhi");
		bookMyShow.showAllMoviesInCity("Noida");
		
		Theatre t1 = new Theatre(1, "Pvr", "Noida");
		Theatre t2 = new Theatre(2, "Pvr", "Delhi");
		
		bookMyShow.addTheates(Arrays.asList(t1, t2));
		
		System.out.println("\n \n");
		
		bookMyShow.showAllThreatres();
		bookMyShow.showAllTheatresInCity("Noida");
		bookMyShow.showAllTheatresInCity("Delhi");
		
		SeatInfo normalSeatInfo = new SeatInfo(100);
		SeatInfo specialSeatInfo = new SeatInfo(200);
		SeatInfo premiumSeatInfo = new SeatInfo(400);
		
		Seat seat11 = new NormalSeat(1, 1, normalSeatInfo);
		Seat seat12 = new NormalSeat(2, 1, normalSeatInfo);
		Seat seat13 = new SpecialSeat(3, 2, specialSeatInfo);
		Seat seat14 = new SpecialSeat(4, 2, specialSeatInfo);
		Seat seat15 = new PremiumSeat(5, 3, premiumSeatInfo);
		Seat seat16 = new PremiumSeat(6, 3, premiumSeatInfo);

		Screen screen1 = new Screen(1);
		screen1.addSeats(Arrays.asList(seat11, seat12, seat13, seat14, seat15, seat16));
		bookMyShow.addScreensInTheatre(1, Arrays.asList(screen1));
		
		Show show11 = new Show(1, screen1, movie1);
		Show show12 = new Show(2, screen1, movie2);

		bookMyShow.addShowsInTheatre(1, Arrays.asList(show11, show12));
		
		Seat seat21 = new NormalSeat(1, 1, normalSeatInfo);
		Seat seat22 = new NormalSeat(2, 1, normalSeatInfo);
		Seat seat23 = new SpecialSeat(3, 2, specialSeatInfo);
		Seat seat24 = new SpecialSeat(4, 2, specialSeatInfo);
		Seat seat25 = new PremiumSeat(5, 3, premiumSeatInfo);
		Seat seat26 = new PremiumSeat(6, 3, premiumSeatInfo);
		
		Screen screen2 = new Screen(2);
		screen2.addSeats(Arrays.asList(seat21, seat22, seat23, seat24, seat25, seat26));
		bookMyShow.addScreensInTheatre(2, Arrays.asList(screen2));
		
		Show show21 = new Show(1, screen2, movie1);
		Show show22 = new Show(2, screen2, movie3);
		bookMyShow.addShowsInTheatre(2, Arrays.asList(show21, show22));
		
		System.out.println("\n\n");
		
		bookMyShow.getShowWhichHasMovie("Noida", "Gladiator");
		bookMyShow.getShowWhichHasMovie("Noida", "Avenger");
		bookMyShow.getShowWhichHasMovie("Delhi", "Gladiator");
		bookMyShow.getShowWhichHasMovie("Delhi", "Batman");
		
		System.out.println("\n");

		bookMyShow.getPricesofShow(1, 1);
		bookMyShow.showSeatAvailability(1, 1);
		bookMyShow.showBookedSeats(1, 1);
		
		System.out.println("\n");
		
		Map<SeatCategory, Integer> reqSeatMap = new HashMap<>();
		reqSeatMap.put(SeatCategory.NORMAL, 1);	
		reqSeatMap.put(SeatCategory.PREMIUM, 2);
		
		Booking booking = bookMyShow.bookSeats(1, 1, 1, reqSeatMap);
		
		bookMyShow.doPayment(booking);
		
		System.out.println("\n \n");
		bookMyShow.showSeatAvailability(1, 1);
		bookMyShow.showBookedSeats(1, 1);
	}

}
