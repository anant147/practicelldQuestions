package com.practice.lld.CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
	
	int storeid;
	Map<VehicleType, VehilceInventarySystem> inventory;
	Location loc;
	List<Reservation> reservations;
	List<Bill> bills;
	List<Payment> payments;
	
	public Store(int storeid, Location loc){
		this.storeid = storeid;
		this.loc = loc;
		this.inventory = new HashMap<>();
		this.reservations = new ArrayList<>();
		this.bills = new ArrayList<>();
		this.payments = new ArrayList<>();
	}
	
	public void addVehicle(Vehicle vehicle) {
		VehilceInventarySystem vinv = inventory.get(vehicle.vt);
		if (vinv == null) {
			vinv = VehilceInventarySystemFactory.getVehilceInventarySystem(vehicle.vt);
			inventory.put(vehicle.vt, vinv);
		}
		vinv.addVehicle(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		VehilceInventarySystem vinv = inventory.get(vehicle.vt);
		if (vinv != null) {
			vinv.removeVehice(vehicle);
		}
		else {
			System.out.println(" for store : " + this.storeid + ", vehicle : " + vehicle.id + " not present");
		}
	}
	
	public Vehicle getAvailableVehicle(VehicleType vt) {
		VehilceInventarySystem vinv = inventory.get(vt);
		if (vinv != null) {
			Vehicle vehicle = vinv.getAvailableVehicle();
			if (vehicle != null) {
				System.out.println(" availabe vehicle : " + vehicle.getId());
				return vehicle;
			}
			
		}
		System.out.println(" store : " + this.storeid + " do not have vehicle of " + vt + " type");
		return null;
	}
	
	public Reservation reserveVehicle(User user, Vehicle vehicle, int reserveId, int bookedFrom, int bookedTo) {
		VehilceInventarySystem vinv = inventory.get(vehicle.vt);
		if (vinv != null) {
			vinv.reserveVehicle(vehicle);
			return createReservation( user,  vehicle,  reserveId,  bookedFrom,  bookedTo);
		}
		System.out.println(" cannot reserve the vehicle. As there is no inventary of " + vehicle.vt );
		return null;
	}

	private Reservation createReservation(User user, Vehicle vehicle, int reserveId, int bookedFrom, int bookedTo) {
		Reservation reservation = new Reservation(reserveId, user, vehicle, new Date(), bookedFrom, bookedTo);
		this.reservations.add(reservation);
		return reservation;
	}
	
	public void cancelReservation(Reservation reservation) {
		makeVehicleActive(reservation.vehicle);
		reservation.setReserveStatus(ReservationStatus.CANCELLED);
		System.out.println("");
	}

	private void makeVehicleActive(Vehicle vehicle) {
		vehicle.setStatus(VehicleStatus.ACTIVE);
	}
	
	public void accessReservation(Reservation res){
		res.setReserveStatus(ReservationStatus.IN_PROGRESS);
		System.out.println(" user : " + res.user.userid + " is accessing its reservation : " + res.reserveId);
	}
	
	public int calculateReservationPrice(Reservation res) {
		int price = res.calcuatePrice();
		System.out.println(" cost of res : " + price);
		return price;
	}
	
	public Bill makeBill(int billid, Reservation reservation) {
		int amount = calculateReservationPrice(reservation);
		Bill bill = new Bill(billid, reservation, amount);
		this.bills.add(bill);
		return bill;
	}
	
	public Payment makePayment(int paymentid, Bill bill, boolean doPayment) {
		Payment payment = getPaymentObject(paymentid,  bill);
		
		if (!doPayment) {
			payment.setStatus(PaymentStatus.FAILED);
		}
		else {
			payment.setStatus(PaymentStatus.SUCCESS);
			markBillAsDone(payment.bill);
			markReservationAsCompleted(payment.bill.reservation);
			makeVehicleActive(payment.bill.reservation.vehicle);
		}
		
		System.out.println(" detail of payment : " + payment);
		return payment;
	}

	private void markReservationAsCompleted(Reservation reservation) {
		reservation.setReserveStatus(ReservationStatus.COMPLETED);
		System.out.println(" status of res is update to " + reservation.reserveStatus);
	}

	private void markBillAsDone(Bill bill) {
		bill.setPaymentdone(true);
		System.out.println(" payment of bill : " + bill.getBillid() + " is done");
	}

	private Payment getPaymentObject(int paymentid, Bill bill) {
		
		for (Payment payment : this.payments) {
			if (paymentid == payment.paymnetid)
				return payment;
		}
		
		Payment payment = new Payment(paymentid, bill);
		this.payments.add(payment);
		return payment;
	}
}
