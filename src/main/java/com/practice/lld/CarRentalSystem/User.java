package com.practice.lld.CarRentalSystem;

public class User {
	
	int userid;
	String driverid;
	String driverLicense;
	
	public User(int userid, String driverid, String driverLicense) {
		this.userid = userid;
		this.driverid = driverid;
		this.driverLicense = driverLicense;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDriverid() {
		return driverid;
	}
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", driverid=" + driverid + ", driverLicense=" + driverLicense + "]";
	}
	
	
}
