package com.practice.lld.parkingLot;

import java.util.List;

public class AvailableParkingStrategy implements ParkingStrategy {

	@Override
	public ParkingSpot getAvailableParkingSpot(List<ParkingSpot> spotList) {
		
		for (ParkingSpot spot : spotList) {
			if (spot.vehicle == null && spot.isEmpty)
				return spot;
		}
		return null;
	}

}
