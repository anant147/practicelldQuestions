package com.practice.lld.CarRentalSystem;

import java.util.Date;

public class Reservation {
	
	@Override
	public String toString() {
		return "Reservation [reserveId=" + reserveId + ", user=" + user + ", vehicle=" + vehicle + ", bookingDate="
				+ bookingDate + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + ", reserveStatus="
				+ reserveStatus + "]";
	}

	int reserveId;
	User user;
	Vehicle vehicle;
	Date bookingDate;
	int bookedFrom;
	int bookedTo;
	ReservationStatus reserveStatus
	;
	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(int bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public int getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(int bookedTo) {
		this.bookedTo = bookedTo;
	}
	public ReservationStatus getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(ReservationStatus reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	
	public Reservation(int reserveId, User user, Vehicle vehicle, Date bookingDate) {
		this.reserveId = reserveId;
		this.user = user;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.reserveStatus = ReservationStatus.SCHEDULED;
	}
	public Reservation(int reserveId, User user, Vehicle vehicle, Date bookingDate, int bookedFrom,
			int bookedTo) {
		super();
		this.reserveId = reserveId;
		this.user = user;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.reserveStatus = ReservationStatus.SCHEDULED;
	}
	
	public int calcuatePrice() {
		return this.vehicle.price * (this.bookedTo-this.bookedFrom);
	}
	
	
}
