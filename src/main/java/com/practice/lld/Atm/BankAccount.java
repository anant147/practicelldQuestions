package com.practice.lld.Atm;

public class BankAccount {
	
	String aid;
	String accountHolder;
	int balance;
	
	@Override
	public String toString() {
		return "BankAccount [aid=" + aid + ", accountHolder=" + accountHolder + ", balance=" + balance + "]";
	}

	public BankAccount(String aid, String accountHolder, int balance) {
		this.aid = aid;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public void deductBalance(int amount) {
		this.balance = this.balance - amount;
	}
	
	public void depositMoney(int amount) {
		this.balance = this.balance + amount;
	}
	
}
