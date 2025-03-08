package com.practice.lld.Swiggy;

public class DeliveryMetaData {
	Location userLoc;
	Location restaurantLoc;
	String orderid;
	
	public DeliveryMetaData(String orderid, Location userLoc, Location restLoc) {
		this.orderid = orderid;
		this.userLoc = userLoc;
		this.restaurantLoc = restLoc;
	}

	public Location getUserLoc() {
		return userLoc;
	}

	public void setUserLoc(Location userLoc) {
		this.userLoc = userLoc;
	}

	public Location getRestaurantLoc() {
		return restaurantLoc;
	}

	public String getOrderid() {
		return orderid;
	}
	
	
}
