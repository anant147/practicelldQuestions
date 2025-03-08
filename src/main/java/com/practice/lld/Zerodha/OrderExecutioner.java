package com.practice.lld.Zerodha;

public class OrderExecutioner {
	
	public void executeOrder(Order order) {
		EXCHConnector exchConnector = EXCHConnector.getExchConnector();
		exchConnector.placeOrder(order);
	}
}
