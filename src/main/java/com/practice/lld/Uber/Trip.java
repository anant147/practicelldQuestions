package com.practice.lld.Uber;

public class Trip {
	
	int tripId;
	Rider rider;
	Driver driver;
	Location srcLoc;
	Location destLoc;
	TripStatus status;
	double price;
	PricingStrategy pricingStrategy;
	DriverMatchingStrategy driverMatchingStrategy;
	
	public Trip(int tripId, Rider rider, Driver driver, Location srcLoc, Location destLoc,
			double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
		this.tripId = tripId;
		this.rider = rider;
		this.driver = driver;
		this.srcLoc = srcLoc;
		this.destLoc = destLoc;
		this.status = TripStatus.DRIVER_ON_THE_WAY;
		this.price = price;
		this.pricingStrategy = pricingStrategy;
		this.driverMatchingStrategy = driverMatchingStrategy;
	}
	
	public int getTripId() {
		return this.tripId;
	}
	
	public void displayTripDetails() {
		System.out.println();
		System.out.println(" Trip id : " + this.tripId);
		System.out.println(" Rider : " + this.rider.getName());
		System.out.println(" Driver : " + this.driver.getName());
		System.out.println(" Price : " + this.price);
		System.out.println(" src Locations : ("+this.srcLoc.latitude + "," + this.srcLoc.longitude + ") , dest locations : ("+this.destLoc.latitude+","+this.destLoc.longitude+")");
		System.out.println();
	}
}
