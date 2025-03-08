package com.practice.lld.Zerodha;

import java.util.HashMap;
import java.util.Map;

public class StockInventory {
	
	Map<String, Stock> stocksMap;
	
	public StockInventory() {
		this.stocksMap = new HashMap<>();
	}
	
	public void addStock(Stock stock) {
		this.stocksMap.put(stock.name, stock);
	}
	
	public Stock getStock(String name) {
		System.out.println("hello");
		return this.stocksMap.get(name);
	}
}
