package com.practice.lld.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ParkingSpotManager {
	
	List<ParkingSpot> spotList;
	ParkingStrategy strategy;
	Map<Vehicle, ParkingSpot> vehilceParkingMap;
	
	public ParkingSpotManager() {
		this.spotList = new ArrayList<>();
		this.strategy = new AvailableParkingStrategy();
		this.vehilceParkingMap = new HashMap<>();
	}
	
	public ParkingSpotManager(List<ParkingSpot> spotList) {
		this.spotList = spotList;
		this.strategy = new AvailableParkingStrategy();
		this.vehilceParkingMap = new HashMap<>();
	}

	public List<ParkingSpot> getSpotList() {
		return spotList;
	}

	public void setSpotList(List<ParkingSpot> spotList) {
		this.spotList = spotList;
	}

	public ParkingStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ParkingStrategy strategy) {
		this.strategy = strategy;
	}
	
	public ParkingSpot findParkingSpot() {
		return strategy.getAvailableParkingSpot(spotList);
	}
	
	public void addParkingSpot(ParkingSpot spot) {
		this.spotList.add(spot);
	}
	
	public void removeParkingSpot(ParkingSpot spot) {
		this.spotList.remove(spot);
	}
	
	public void parkVehicle(ParkingSpot spot, Vehicle vehicle) {
		if (spot != null) {
			vehilceParkingMap.put(vehicle, spot);
			spot.setEmpty(false);
			spot.setVehicle(vehicle);
			System.out.println(" vehicle with id " + vehicle.vid + " and type : " + vehicle.getVt() + " is parked to spot : " + spot.pid);
		}
		else {
			System.out.println(" no parking spot availble for vid : " + vehicle.getVid());
		}
	}
	
	public void removeVehicle(Vehicle vehicle) {
		ParkingSpot spot = vehilceParkingMap.get(vehicle);
		if (spot != null) {
			spot.setEmpty(true);
			spot.setVehicle(null);
			vehilceParkingMap.remove(vehicle);
			System.out.println(" vehicle with id " + vehicle.vid + " and type : " + vehicle.getVt() + " is removed from parking spot : " + spot.pid);
		}
		else {
			System.out.println(" vehicle : " + vehicle.getVid() + " is not parked anywhere");
		}
	}
	
}
