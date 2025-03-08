package com.practice.lld.Uber;

public class Rider {
	
	String name;
	Rating rating;
	
	public Rider(String name, Rating rating) {
		this.name = name;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public Rating getRating() {
		return rating;
	}
	
	
}
