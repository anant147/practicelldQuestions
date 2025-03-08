package com.practice.lld.parkingLot;

public class Vehicle {
	
	int vid;
	VehicleType vt;
		
	public Vehicle(int vid, VehicleType vt) {
		this.vid = vid;
		this.vt = vt;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public VehicleType getVt() {
		return vt;
	}
	public void setVt(VehicleType vt) {
		this.vt = vt;
	}
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", vt=" + vt + "]";
	}
	
	
}
