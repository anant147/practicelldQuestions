package com.practice.lld.parkingLot;

public class Ticket {
	
	int tid;
	Integer entryTime;
	Integer exitTime;
	Integer cost;
	Vehicle vehicle;
	ParkingSpot parkingSpot;
	boolean isValid = false;
	
	public Ticket(int tid, Integer entryTime, Vehicle vehicle, ParkingSpot spot) {
		this.tid = tid;
		this.entryTime = entryTime;
		this.vehicle = vehicle;
		this.parkingSpot = spot;
		this.isValid = true;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Integer getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Integer entryTime) {
		this.entryTime = entryTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Integer getExitTime() {
		return exitTime;
	}

	public void setExitTime(Integer exitTime) {
		this.exitTime = exitTime;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", cost=" + cost
				+ ", vehicle=" + vehicle + ", parkingSpot=" + parkingSpot + ", isValid=" + isValid + "]";
	}

}
