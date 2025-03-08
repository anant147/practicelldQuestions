package com.practice.lld.parkingLot;

public class ParkingSpotFactory {
	
	public ParkingSpot getParkingSpot(int pid, VehicleType vt) {
		
		if (vt.equals(VehicleType.TWO_WHEELER))
			return new TwoWheelerParkingSpot(pid);
		else if (vt.equals(VehicleType.FOUR_WHEELER))
			return new FourWheelerParkingSpot(pid);
		return null;
	}
}
