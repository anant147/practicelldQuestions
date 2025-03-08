package com.practice.lld.parkingLot;

import java.util.List;

public interface ParkingStrategy {
	
	ParkingSpot getAvailableParkingSpot(List<ParkingSpot> spotList);
}
