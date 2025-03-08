package com.practice.lld.CarRentalSystem;

public abstract class Vehicle {
	
	int id;
	int vehicleNum;
	VehicleType vt;
	VehicleStatus status;
	int kmDriven;
	int price;
	
	public Vehicle(int id, int vehicleNum, VehicleType vt, int price) {
		this.id = id;
		this.vehicleNum= vehicleNum;
		this.vt = vt;
		this.status = VehicleStatus.ACTIVE;
		this.kmDriven = 0;
		this.price = price;
	}
	
	public Vehicle(int id, int vehicleNum, VehicleType vt, VehicleStatus status, int kmDriven, int price) {
		this.id = id;
		this.vehicleNum = vehicleNum;
		this.vt = vt;
		this.status = status;
		this.kmDriven = kmDriven;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(int vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public VehicleType getVt() {
		return vt;
	}

	public void setStatus(VehicleStatus status) {
		this.status = status;
	}

	public int getKmDriven() {
		return kmDriven;
	}

	public void setKmDriven(int kmDriven) {
		this.kmDriven = kmDriven;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", VehicleNum=" + this.vehicleNum + ", vt=" + vt + ", status=" + status + ", kmDriven="
				+ kmDriven + "]";
	}
	
}
