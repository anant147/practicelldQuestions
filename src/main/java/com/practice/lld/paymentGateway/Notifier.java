package com.practice.lld.paymentGateway;

public class Notifier {
	
	String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void pubishMessage() {
		System.out.println(message);
	}
}
