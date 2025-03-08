package com.practice.lld.Zerodha;

import java.util.Map;

public class WatchList {
	
	String name;
	Map<String,Stock> stocks;
	
	public WatchList(String name) {
		this.name = name;
	}
	
	public void addStockToWatchList(Stock stock, String name) {
		this.stocks.put(name, stock);
	}
	
	public void removeStockFromWatchList(String name) {
		this.stocks.remove(name);
	}
}
