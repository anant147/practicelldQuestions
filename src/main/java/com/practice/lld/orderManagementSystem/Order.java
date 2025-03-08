package com.practice.lld.orderManagementSystem;

import java.util.Map;

public class Order {
	
	int oid;
	User user;
	Address deliveryAddress;
	Map<String, Integer> productCountMap;
	Warehouse warehouse;
	double payableAmount;
	Invoice invoice;
	Payment payment;
	OrderStatus orderStatus;
	
	public Order(int oid, User user, Address delAddr, Warehouse warehouse, double amount) {
		this.oid = oid;
		this.user = user;
		user.addOrderForUser(oid);
		this.deliveryAddress = delAddr;
		this.productCountMap = user.cart.productCountMap;
		this.warehouse = warehouse;
		this.invoice = new Invoice(this.oid, amount);
		this.payableAmount = this.invoice.totalAmount;
		this.payment = new Payment(this.oid, this.invoice.totalAmount);
		this.orderStatus = OrderStatus.PENDING;
	}
	
	public void makePayment(PaymentMode mode) {
		this.payment.makePayment(mode);
	}
	
	public void completeOrder() {
		this.warehouse.removeProducts(this.productCountMap);
		this.user.emtpyCartOfUser();
		this.orderStatus = OrderStatus.DELIVERED;
	}
	
	
}
