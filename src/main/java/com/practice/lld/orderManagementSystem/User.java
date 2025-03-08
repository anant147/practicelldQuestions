package com.practice.lld.orderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	int uid;
	String name;
	Cart cart;
	List<Integer> orderids;
	
	public User(int uid, String name) {
		this.uid = uid;
		this.name = name;
		this.cart = new Cart(uid);
		this.orderids = new ArrayList<>();
	}
	
	public void addProduct(String product, int count) {
		this.cart.addProduct(product, count);
	}
	
	public void removeProduct(String product) {
		this.cart.removeProduct(product);
	}
	
	public void decreaseProduct(String product, int count) {
		this.cart.decreaseProduct(product, count);
	}
	
	public void viewCartOfUser() {
		this.cart.viewCart();
	}
	
	public void emtpyCartOfUser() {
		this.cart.emptyCart();
	}
	
	public void addOrderForUser(int orderid) {
		this.orderids.add(orderid);
	}
	
	public List<Integer> getAllOrderIdsOfUser(){
		return this.orderids;
	}
	
	public boolean isCartNotEmpty() {
		return !this.cart.productCountMap.isEmpty();
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", cart=" + cart + ", orderids=" + orderids + "]";
	}
	
}
