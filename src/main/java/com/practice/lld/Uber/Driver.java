package com.practice.lld.Uber;

public class Driver {
	
	String name;
	boolean available;
	Rating rating;
	
	public Driver(String name, Rating rating) {
		this.name = name;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public Rating getRating() {
		return rating;
	}
	
	public void updateAval(boolean aval) {
		this.available = aval;
	}
}
