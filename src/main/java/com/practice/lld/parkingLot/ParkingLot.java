package com.practice.lld.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

	EntranceGate entranceGate;
	ExitGate exitGate;
	ParkingSpotManagerFactory spotManagerFactory;
	ParkingSpotFactory spotFactory;
	Map<Vehicle, Ticket> ticketMap;

	
	public ParkingLot() {
		this.spotManagerFactory = new ParkingSpotManagerFactory();
		this.entranceGate = new EntranceGate(this.spotManagerFactory);
		this.exitGate = new ExitGate(this.spotManagerFactory);
		this.spotFactory = new ParkingSpotFactory();
		this.ticketMap = new HashMap<>();
	}

	public EntranceGate getEntranceGate() {
		return entranceGate;
	}

	public void setEntranceGate(EntranceGate entranceGate) {
		this.entranceGate = entranceGate;
	}

	public ParkingSpotManagerFactory getSpotManagerFactory() {
		return spotManagerFactory;
	}

	public void setSpotManagerFactory(ParkingSpotManagerFactory spotManagerFactory) {
		this.spotManagerFactory = spotManagerFactory;
	}
	
	public void addParkingSpot(VehicleType vehicleType, int pid) {
		ParkingSpotManager psm = spotManagerFactory.getParkingSpotManager(vehicleType);
		psm.addParkingSpot(this.spotFactory.getParkingSpot(pid, vehicleType));
	}
	
	public void removeParkingSpot(ParkingSpot spot, VehicleType vt) {
		ParkingSpotManager psm = spotManagerFactory.getParkingSpotManager(vt);
		psm.removeParkingSpot(spot);

	}
	
	public ParkingSpot findParkingSpot(Vehicle vehicle) {
		return entranceGate.findParkingSpot(vehicle);
	}
	
	public void bookParkingSpot(ParkingSpot spot, Vehicle vehicle) {
		entranceGate.bookParkingSpot(spot, vehicle);
	}
	
	public Ticket createTicket(int tid, int time, ParkingSpot spot, Vehicle vehicle) {
		Ticket ticket = entranceGate.generteTicket(tid, time, spot, vehicle);
		this.ticketMap.put(vehicle, ticket);
		return ticket;
	}
	
	public int parkingCalculation(Ticket ticket, int exitTime) {
		return this.exitGate.parkingCalculation(ticket, exitTime);
	}
	
	public void doPayment(Ticket ticket, int cost) {
		 this.exitGate.doPayment(ticket, cost);
	}
	
	public void removeVehicle(Ticket ticket) {
		this.exitGate.removeVehicle(ticket);
		this.ticketMap.remove(ticket.vehicle);
	}
}
