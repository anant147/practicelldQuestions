package com.practice.lld.Swiggy;

import java.util.ArrayList;
import java.util.List;

public class Dish {
	
	String name;
	Cusine cusine;
	String description;
	double price;
	List<String> dishImages;
	List<DishAddOn> addons;
	
	public Dish(String name, Cusine cusine, double price) {
		this.name = name;
		this.cusine = cusine;
		this.price = price;
		this.dishImages = new ArrayList<>();
		this.addons = new ArrayList<>();
	}
	
	public void addOn(DishAddOn addon) {
		this.addons.add(addon);
	}
	
	public double getPrice() {
		double totalPrice = this.price;
		if (this.addons.size()>0) {
			for (DishAddOn da : this.addons) {
				totalPrice += da.price;
			}
		}
		return totalPrice;
	}

	public String getName() {
		return name;
	}

	public Cusine getCusine() {
		return cusine;
	}

	public String getDescription() {
		return description;
	}
	
	
}
