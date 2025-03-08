package com.practice.lld.Zerodha;

public class EXCHConnector {
	
	private volatile static EXCHConnector exchConnectorInstance = null;
	
	private EXCHConnector() {}
	
	public static EXCHConnector getExchConnector() {
		if (exchConnectorInstance == null) {
			synchronized(EXCHConnector.class) {
				if (exchConnectorInstance == null) {
					exchConnectorInstance = new EXCHConnector();
				}
			}
		}
		return exchConnectorInstance;
	}
	
	public void placeOrder(Order order) {
		System.out.println("Order sent to exchange");
	}
}
