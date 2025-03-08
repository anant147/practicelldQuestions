package com.practice.lld.Swiggy;

import java.util.List;

public class DishAddOn {
	
	String name;
	String description;
	double price;
	boolean isAvail;
	List<String> images;
	
	public DishAddOn(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAvail() {
		return isAvail;
	}

	public List<String> getImages() {
		return images;
	}
	
	
}
