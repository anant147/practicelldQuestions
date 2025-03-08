package com.practice.lld.Uber;

import java.util.Map;

public class Uber {

	public static void main(String[] args) {
		
		Rider keertiRider = new Rider("Keerti", Rating.THREE_STARS);
		Rider gauravRider = new Rider("Gaurav", Rating.FIVE_STARS);
		RiderManager riderMgr = RiderManager.getRiderManager();
		riderMgr.addRider(gauravRider);
		riderMgr.addRider(keertiRider);
		
		Driver yogitaDriver = new Driver("Yogita",Rating.THREE_STARS);
		Driver riddiDriver = new Driver("Riddhi", Rating.FOUR_STARS);
		DriverManager driverMgr = DriverManager.getDriverManager();
		driverMgr.addDriver(riddiDriver);
		driverMgr.addDriver(yogitaDriver);
		
		TripManager tripMgr = TripManager.getTripManager();
		
		System.out.println(" creating trip for keerti from location(10,10) to location(30, 30)");
		tripMgr.createTrip(keertiRider, new Location(10, 10), new Location(30, 30));
		
		System.out.println(" creating trip for gaurav from location (200,200) to location(500, 500)");
		tripMgr.createTrip(gauravRider, new Location(200, 200), new Location(500, 500));
		
		// displaying all trips
		
		Map<Integer, Trip> tripMap = tripMgr.getTripsMap();
		
		for (Map.Entry<Integer, Trip> entry : tripMap.entrySet()) {
			entry.getValue().displayTripDetails();
		}
		
	}

}
