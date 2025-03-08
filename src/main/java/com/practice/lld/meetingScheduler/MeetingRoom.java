package com.practice.lld.meetingScheduler;

public class MeetingRoom {
	
	int mrid;
	String name;
	Location location;
	int capacity;
	
	public MeetingRoom(int mrid, String name, Location location, int capacity) {
		this.mrid = mrid;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}

	public int getMrid() {
		return mrid;
	}

	public void setMrid(int mrid) {
		this.mrid = mrid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "MeetingRoom [mrid=" + mrid + ", name=" + name + ", location=" + location + ", capacity=" + capacity
				+ "]";
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	 
}
