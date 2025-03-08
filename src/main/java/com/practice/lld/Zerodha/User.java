package com.practice.lld.Zerodha;

public class User {
	
	String userid;
	// double funds
	// List<WatchList> watchLists;
	// Portfolio portfolio
	
	public User(String userid) {
		this.userid = userid;
	}
	
	public String getUserId() {
		return this.userid;
	}
}
