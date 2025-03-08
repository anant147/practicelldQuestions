package com.practice.lld.Uber;

import java.util.Map;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

	@Override
	public Driver matchDriver(TripMetadata tripMetadata) {
		DriverManager driveMgr = DriverManager.getDriverManager();
		
		if (driveMgr.driversMap.size() == 0) {
			System.out.println(" no  drivers ! what service is this !");
			return null;
		}
		
		System.out.println(" using quad tree to see nearest cabs");
		Driver driver = getDriver(driveMgr.driversMap);
		tripMetadata.setDriverRating(driver.rating);
		return driver;
	}

	private Driver getDriver(Map<String, Driver> driversMap) {
		for (Map.Entry<String, Driver> entry : driversMap.entrySet()) {
			return entry.getValue();
		}
		return null;
	}

}
