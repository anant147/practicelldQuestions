package com.practice.lld.parkingLot;

public class ExitGate {
	
	ParkingSpotManagerFactory factory;
	
	public ExitGate(ParkingSpotManagerFactory factory) {
		this.factory = factory;
	}

	public ParkingSpotManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(ParkingSpotManagerFactory factory) {
		this.factory = factory;
	}
	
	public int parkingCalculation(Ticket ticket, int exitTime) {
		
		ticket.setExitTime(exitTime);
		return (exitTime - ticket.entryTime) * ticket.parkingSpot.price;
	}
	
	public void doPayment(Ticket ticket, int price) {
		ticket.setCost(price);
		System.out.println(" payment for ticket : " + ticket.tid + " of " + price + " has been done");
	}
	
	public void removeVehicle(Ticket ticket) {
		ParkingSpotManager psm = factory.getParkingSpotManager(ticket.vehicle.vt);
		psm.removeVehicle(ticket.vehicle);
		ticket.setValid(false);
	}
	
}
