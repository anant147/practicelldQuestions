package com.practice.lld.paymentGateway;

import java.util.HashMap;
import java.util.Map;

public class UserBankAccount {
	
	int ubid;
	User user;
	Bank bank;
	int amount;
	Map<InstrumentType, UserBankInstrument> instMap;
	Notifier notifier;

	
	public UserBankAccount(int ubid, User user, Bank bank, int amount) {
		this.ubid = ubid;
		this.user = user;
		this.bank = bank;
		this.amount = amount;
		this.instMap = new HashMap<>();
		this.notifier = new Notifier();
	}
	
	public void notifyMessage(String message) {
		this.notifier.setMessage("Message for user : " + this.user + " , Message : " + message);
		this.notifier.pubishMessage();
	}
	
	public int getUbid() {
		return ubid;
	}

	public void setUbid(int ubid) {
		this.ubid = ubid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "UserBankAccount [ubid=" + ubid + ", user=" + user.userid + ", bank=" + bank.bankName + ", amount=" + amount + "]";
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Map<InstrumentType, UserBankInstrument> getInstMap() {
		return instMap;
	}

	public void setInstMap(Map<InstrumentType, UserBankInstrument> instMap) {
		this.instMap = instMap;
	}

	public void creditMoney(int amount) {
		this.amount += amount;
	}
	
	public void debitMoney(int amount) {
		this.amount -= amount;
	}
	
	public boolean enoughMoney(int amount) {
		return amount<this.amount;
	}
	
	public void addInstrument(UserBankInstrument ubi) {
		InstrumentType it = ubi.type;
		if (instMap.get(it) == null) {
			instMap.put(it, ubi);
		}
		else {
			System.out.println(" instrument : " + it + " exist for user : " + this.user.userid + " with bank : " + this.bank.bankName);
		}
	}
}
