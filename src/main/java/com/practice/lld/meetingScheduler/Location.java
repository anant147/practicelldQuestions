package com.practice.lld.meetingScheduler;

public class Location {
	
	int lid;
	String locationName;
	int bid;
	int fid;
	
	public Location(int lid, int bid, int fid, String locationName) {
		this.lid = lid;
		this.bid = bid;
		this.fid = fid;
		this.locationName = locationName;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}	
}
