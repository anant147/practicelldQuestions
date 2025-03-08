package com.practice.lld.Uber;

public class TripMetadata {
	
	Location srcLoc;
	Location destLoc;
	Rating riderRating;
	Rating driverRating;
	
	public TripMetadata(Location srcLoc, Location destLoc, Rating riderRating) {
		this.srcLoc = srcLoc;
		this.destLoc = destLoc;
		this.driverRating = Rating.UNASSIGNED;
		this.riderRating = riderRating;
	}
	
	public Rating getRiderRating() {
		return this.riderRating;
	}
	
	public Rating getDriverRating() {
		return this.driverRating;
	}
	
	public void setDriverRating(Rating rating) {
		this.driverRating = rating;
	}
}
