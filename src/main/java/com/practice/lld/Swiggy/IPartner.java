package com.practice.lld.Swiggy;

public abstract class IPartner {
	
	String name;
	Rating rating;
	
	public IPartner(String name) {
		this.name = name;
		this.rating = Rating.UNASSIGNED;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Rating getRating() {
		return this.rating;
	}
}
