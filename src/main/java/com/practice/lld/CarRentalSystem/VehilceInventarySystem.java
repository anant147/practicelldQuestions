package com.practice.lld.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class VehilceInventarySystem {
	
	VehicleType vt;
	List<Vehicle> vehList;
	
	public VehilceInventarySystem(VehicleType vt) {
		this.vt = vt;
		this.vehList = new ArrayList<>();
	}

	public List<Vehicle> getVehList() {
		return vehList;
	}

	public void setVehList(List<Vehicle> vehList) {
		this.vehList = vehList;
	}
	
	public void addVehicle(Vehicle vehicle) {
		if (this.vt.equals(vehicle.vt)) {
			this.vehList.add(vehicle);
		}
		else {
			System.out.println(" vehicle type not same as that of inventary");
		}
	}
	
	public void removeVehice(Vehicle vehicle) {
		this.vehList.remove(vehicle);
	}
	
	public Vehicle getAvailableVehicle() {
		for (Vehicle v : this.vehList) {
			if (VehicleStatus.ACTIVE.equals(v.status))
				return v;
		}
		System.out.println(" currently no vehicle available");
		return null;
	}
	
	public void reserveVehicle(Vehicle v) {
		v.setStatus(VehicleStatus.IN_USE);
		System.out.println(" Vehicle : " + v.id + " and type : " + v.vt + " has been booked");
	}
	
	public void returnVehicle(Vehicle v) {
		v.setStatus(VehicleStatus.ACTIVE);
	}
}
