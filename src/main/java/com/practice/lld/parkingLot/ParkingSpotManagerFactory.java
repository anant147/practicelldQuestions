package com.practice.lld.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotManagerFactory {
	
	Map<VehicleType, ParkingSpotManager> parkingSpotMap;
	
	public ParkingSpotManagerFactory(){
		this.parkingSpotMap = new HashMap<>();
	}
	
	public ParkingSpotManager getParkingSpotManager(VehicleType vt) {
		if (!parkingSpotMap.containsKey(vt)) {
			if (VehicleType.TWO_WHEELER.equals(vt))
				parkingSpotMap.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingSpotManager());
			else if (VehicleType.FOUR_WHEELER.equals(vt))
				parkingSpotMap.put(VehicleType.FOUR_WHEELER, new FourWheelerParkingSpotManager());

		}
		return parkingSpotMap.get(vt);
	}
	
	
}
