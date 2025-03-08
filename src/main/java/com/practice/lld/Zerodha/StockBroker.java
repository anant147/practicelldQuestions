package com.practice.lld.Zerodha;

public class StockBroker {
	
	public static void main(String[] args) {
		
		User user = new User("keerti");
		UserManager.addUser("keerti", user);
		
		Stock SBIStock = new Stock("SBI", 530, Exch.NSE);
		
//		StockInventory stockInventory = new StockInventory();
//		stockInventory.addStock(SBIStock);
//		stockInventory.addStock(new Stock("ITC", 500, Exch.BSE));
		
		
		Order order = new Order(TxnType.SELL, OrderType.MARKET, Exch.NSE, 531, 10, SBIStock);
		OrderMgr orderMgr = new OrderMgr();
		orderMgr.placeOrder("keerti", order);
	}
}
