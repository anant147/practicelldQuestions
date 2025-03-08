package com.practice.lld.Zerodha;

public class Stock {
	String name;
	double price;
	Exch xch;
	
	public Stock(String name, double price, Exch xch) {
		this.name = name;
		this.price = price;
		this.xch = xch;
	}
	
	
}
