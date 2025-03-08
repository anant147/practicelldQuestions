package com.practice.lld.parkingLot;

public class MainClass {
	
	public static void main(String[] args) {
		
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.addParkingSpot(VehicleType.TWO_WHEELER, 1);
		parkingLot.addParkingSpot(VehicleType.FOUR_WHEELER, 2);
		parkingLot.addParkingSpot(VehicleType.TWO_WHEELER, 3);
		parkingLot.addParkingSpot(VehicleType.FOUR_WHEELER, 4);
		
		Vehicle twoWheeler = new Vehicle(10, VehicleType.TWO_WHEELER);
		
		ParkingSpot twoWheelerParkingSpot = parkingLot.findParkingSpot(twoWheeler);
		parkingLot.bookParkingSpot(twoWheelerParkingSpot, twoWheeler);
		Ticket twoWheelerTicket = parkingLot.createTicket(1, 1, twoWheelerParkingSpot, twoWheeler);
		
		System.out.println(" ticket after parking : " + twoWheelerTicket + "\n");
		
		int twoWheelerTicketCost = parkingLot.parkingCalculation(twoWheelerTicket, 5);
		parkingLot.doPayment(twoWheelerTicket, twoWheelerTicketCost);
		parkingLot.removeVehicle(twoWheelerTicket);
		
		System.out.println(" ticket after removing from parking : " + twoWheelerTicket + "\n");

		
		System.out.println("\n \n");
		Vehicle fourWheeler = new Vehicle(11, VehicleType.FOUR_WHEELER);
		ParkingSpot fourWheelerParkingSpot = parkingLot.findParkingSpot(fourWheeler);
		parkingLot.bookParkingSpot(fourWheelerParkingSpot, fourWheeler);
		Ticket fourWheelerTicket = parkingLot.createTicket(2, 2, fourWheelerParkingSpot, fourWheeler);
		
		System.out.println(" ticket after parking : " + fourWheelerTicket + "\n");
		
		int fourWheelerTicketCost = parkingLot.parkingCalculation(fourWheelerTicket, 6);
		parkingLot.doPayment(fourWheelerTicket, fourWheelerTicketCost);
		parkingLot.removeVehicle(fourWheelerTicket);
		
		System.out.println(" ticket after removing from parking : " + fourWheelerTicket + "\n");

		 

	}
}
