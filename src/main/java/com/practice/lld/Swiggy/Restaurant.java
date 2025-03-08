package com.practice.lld.Swiggy;

import java.util.Map;

public class Restaurant {
	
	String name;
	boolean isAvail;
	Location location;
	Menu menu;
	RestaurantOwner owner;
	
	public Restaurant(String name, RestaurantOwner owner, Location loc) {
		this.name = name;
		this.location = loc;
		this.owner = owner;
	}
	
	public void addMenu(Menu menu) {
		this.menu = menu;
	}
	
	String getId() {
		return this.name;
	}
	
	Location getLocation() {
		return this.location;
	}
	
	public boolean prepareFood(String orderid, Map<Dish, Integer> dishes) {
		
		System.out.println("Restaurant accepting the order and starting to prepare it ");
		
		NotificationMgr notiMgr = NotificationMgr.getNotificationMgr();
		
		notiMgr.notify(orderid, "Food is being prepared in restaurant");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notiMgr.notify(orderid, "Food is ready and can be picked up from restaurant");
		return true;
	}
}
