package com.practice.lld.Zerodha;

public class OrderValidator {
	
	boolean validateOrder(String userid, Order order) {
		User user = UserManager.getUser(userid);
		
		if (order.getTxnType() == TxnType.BUY) {
			System.out.println(" checking if user : " + user.getUserId() + " has enough founds to buy. ");
			System.out.println(" for now , let's assume user is a good person and return true");
		}
		else {
			System.out.println(" checking if user : " + user.userid + " has enough stocks to sell in portfolio ");
			System.out.println(" for now , let's assume user is a good person and return true");
		}
		return true;
	}
}
