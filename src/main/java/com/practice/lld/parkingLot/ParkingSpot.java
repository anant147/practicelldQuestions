package com.practice.lld.parkingLot;

public abstract class ParkingSpot {
	
	int pid;
	boolean isEmpty;
	Vehicle vehicle;
	int price;
	
	public ParkingSpot(int pid, int price) {
		this.pid = pid;
		this.vehicle = null;
		this.isEmpty = true;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ParkingSpot [pid=" + pid + ", isEmpty=" + isEmpty + ", vehicle=" + vehicle + ", price=" + price + "]";
	}
	
	
	
}
