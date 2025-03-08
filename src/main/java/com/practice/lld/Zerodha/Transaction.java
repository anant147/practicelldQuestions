package com.practice.lld.Zerodha;

import java.time.LocalDateTime;

public class Transaction {
	
	// users
	// orderid
	LocalDateTime txnTime;
	int quantity;
	double price;
	
	public Transaction() {
		
	}

	public LocalDateTime getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(LocalDateTime txnTime) {
		this.txnTime = txnTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
