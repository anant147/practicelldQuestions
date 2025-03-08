package com.practice.lld.Swiggy;

public class User {
	
	String name;
	Location location;
		
	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public User(String name, Location location) {
		this.name = name;
		this.location = location;
	}
	
	
}
