package com.practice.lld.CarRentalSystem;

public class VRMainClass {

	public static void main(String[] args) {
		
		VehicleRentalSystem vrs = new VehicleRentalSystem();
		User user1 = new User(1, "ab", "ab");
		Location loc = new Location("abc", "Noida", "UP", 123);
		Store store = new Store(1, loc);
		vrs.addUser(user1);
		vrs.addStore(store);
		
		Vehicle car1 = new Car(1, 123);
		Vehicle bike1 = new Bike(2, 234);
		
		vrs.addVehicle(1, car1);
		vrs.addVehicle(1, bike1);
		
		
		Vehicle cr = vrs.searchVehicle(VehicleType.CAR, loc);
		
		Reservation res = vrs.reserveVehicle(1, user1, cr, 1, 5, 10);
		
		vrs.accessReservation(res);
		
		Bill bill = vrs.getBill(1, res);
		
		System.out.println(" res : " + res);
		
		System.out.println(" bill : " + bill);
		
		Payment payment = vrs.makePayment(1, bill, true);
		
		System.out.println(" payment : " + payment);
	
	}

}
