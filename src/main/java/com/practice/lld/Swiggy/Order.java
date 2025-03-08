package com.practice.lld.Swiggy;

import java.util.Map;

public class Order {
	
	String orderid;
	User user;
	Restaurant restaurant;
	Map<Dish, Integer> dishes;
	
	String discountCode;
	String paymentId;
	OrderStatus status;
	
	public Order(String orderid, User user, Restaurant restaurant, Map<Dish, Integer> dishes) {
		this.orderid = orderid;
		this.user = user;
		this.restaurant = restaurant;
		this.dishes = dishes;
		this.status = OrderStatus.PLACED;
	}
	
	public String getOrderId() {
		return this.orderid;
	}
	
	public String getuserid() {
		return this.user.name;
	}
	
	public String getRestaurantId() {
		return this.restaurant.getId();
	}
	
	public Map<Dish, Integer> getDishes(){
		return this.dishes;
	}
	
	public Location getUserLocation() {
		return this.user.location;
	}
	
	public Location getRestaurantLocation() {
		return this.restaurant.location;
	}
	
	
}
