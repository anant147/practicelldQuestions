package com.practice.lld.Zerodha;

public class OrderMgr {
	
	OrderValidator validator;
	OrderExecutioner executioner;
	
	public OrderMgr() {
		this.validator = new OrderValidator();
		this.executioner = new OrderExecutioner();
	}
	
	public void placeOrder(String userid, Order order) {
		if (this.validator.validateOrder(userid, order)) {
			this.executioner.executeOrder(order);
		}
		else {
			System.out.println(" cann't execute the order");
		}
	}
}
