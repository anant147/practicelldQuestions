package com.practice.lld.Zerodha;

public class Order {
	
	TxnType txnType;
	OrderType orderType;
	Exch exchange;
	double price;
	int qty;
	Stock stock;
	//order status should be updated and once order is successful from exchange, 
    //transactions should be stored (which can be viewed in tradebook)
    //ORDER_STATUS status;
    //time_t orderTime;
    //vector<Transaction*> transactions;
	
	public Order(TxnType txnType, OrderType orderType, Exch exch, double price, int qty, Stock stock) {
		this.txnType = txnType;
		this.orderType = orderType;
		this.exchange = exch;
		this.price = price;
		this.qty = qty;
		this.stock = stock;
	}

	public TxnType getTxnType() {
		return txnType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public Exch getExchange() {
		return exchange;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public Stock getStock() {
		return stock;
	}
	
	
	
}
