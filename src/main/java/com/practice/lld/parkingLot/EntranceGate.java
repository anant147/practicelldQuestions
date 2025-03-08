package com.practice.lld.parkingLot;


public class EntranceGate {
	
	ParkingSpotManagerFactory factory;
	ParkingSpotManager manager;
	
	public EntranceGate(ParkingSpotManagerFactory factory) {
		this.factory = factory;
	}
	
	private ParkingSpotManager getParkingSpotManager(Vehicle vehicle) {
		return this.factory.getParkingSpotManager(vehicle.vt);
	}
	
	public ParkingSpot findParkingSpot(Vehicle vehicle) {
		ParkingSpotManager psm = getParkingSpotManager(vehicle);
		return psm.findParkingSpot();
	}
	
	public void bookParkingSpot(ParkingSpot spot, Vehicle vehicle) {
		ParkingSpotManager psm = getParkingSpotManager(vehicle);
		psm.parkVehicle(spot,vehicle);
	}
	
	public Ticket generteTicket(int tid, int entryTime, ParkingSpot spot, Vehicle vehicle) {
		return new Ticket( tid,  entryTime,    vehicle, spot);
	}
	
}
