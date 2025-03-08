package com.practice.lld.CarRentalSystem;

public class Location {
	
	String address;
	String city;
	String state;
	int pincode;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Location(String address, String city, String state, int pincode) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	

	
	
}
