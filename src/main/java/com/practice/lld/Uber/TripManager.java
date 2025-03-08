package com.practice.lld.Uber;

import java.util.HashMap;
import java.util.Map;

public class TripManager {
	
	private volatile static TripManager tripManaagerInstance = null;
	static int nextTripId = 1;
	RiderManager riderManager;
	DriverManager driverManager;
	Map<Integer, TripMetadata> tripsMetaDataInfo;
	Map<Integer, Trip> tripsInfo;
	
	private TripManager() {
		this.riderManager = RiderManager.getRiderManager();
		this.driverManager = DriverManager.getDriverManager();
		this.tripsInfo = new HashMap<>();
		this.tripsMetaDataInfo = new HashMap<>();
	}
	
	public static TripManager getTripManager() {
		if (tripManaagerInstance == null) {
			synchronized(TripManager.class) {
				if (tripManaagerInstance == null) {
					tripManaagerInstance = new TripManager();
				}
			}
		}
		return tripManaagerInstance;
	}
	
	
	
	Map<Integer, Trip> getTripsMap(){
		return this.tripsInfo;
	}
	
	void createTrip(Rider rider, Location srcLoc, Location destLoc) {
		TripMetadata metadata = new TripMetadata( srcLoc, destLoc, rider.rating);
		StrategyManager strategyMgr = StrategyManager.getStrategyManager();
		PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metadata);
		DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determinDriverMatchingStrategy();
		
		Driver driver = driverMatchingStrategy.matchDriver(metadata);
		double tripPrice = pricingStrategy.calculatePrice(metadata);
		
		Trip trip = new Trip(nextTripId, rider, driver, srcLoc, destLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
		int tripId = trip.tripId;
		this.tripsInfo.put(tripId, trip);
		this.tripsMetaDataInfo.put(tripId, metadata);
		nextTripId++;
	}
}
