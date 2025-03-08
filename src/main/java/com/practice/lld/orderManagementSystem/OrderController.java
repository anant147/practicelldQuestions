package com.practice.lld.orderManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
	
	List<Order> orders;
	Map<Integer, Order> orderMap;
	Map<User, List<Order>> userOrderMap;
	
	public OrderController() {
		this.orders = new ArrayList<>();
		this.orderMap = new HashMap<>();
		this.userOrderMap = new HashMap<>();
	}
	
	public Order placeOrder(int oid, User user, Address delAddr, Warehouse warehouse, 
			double amount) {
		Order order = new Order( oid,  user,  delAddr,  warehouse,  amount);
		addOrder(order);
		return order;
	}

	private void addOrder(Order order) {
		this.orders.add(order);
		this.orderMap.put(order.oid, order);
		
		User user = order.user;
		List<Order> userOrders = new ArrayList<>();
		if (this.userOrderMap.containsKey(user)) {
			userOrders = this.userOrderMap.get(user);
		}
		else {
			this.userOrderMap.put(user, userOrders);
		}
		
		userOrders.add(order);
	}
	
	public Order getOrder(int oid) {
		if (this.orderMap.containsKey(oid)) {
			return this.orderMap.get(oid);
		}
		System.out.println(" no order of " + oid + " present");
		return null;
	}
	
}
