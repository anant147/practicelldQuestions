package com.practice.lld.Atm;

public class Card {
	
	String cardNumber;
	String cvv;
	String expiry;
	String pin;
	BankAccount bankAccount;
	
	public Card(String cardNumber, String pin, BankAccount bankAccount) {
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.cvv = "123";
		this.expiry = "05/29";
		this.bankAccount = bankAccount;
	}
	
	public  void showCurrentBalance() {
		if (this.bankAccount != null) {
			System.out.println( "for user : " + this.bankAccount.accountHolder + ", current available amount : " + this.bankAccount.balance);
		}
		else {
			System.out.println(" no bank account attached to card");
		} 
	}
	
	public void deductBalance(int amount) {
		if (this.bankAccount != null) {
			this.bankAccount.deductBalance(amount);
			System.out.println( amount + " rs deducted from bank account of " + this.bankAccount.accountHolder);
		}
		else {
			System.out.println(" no bank account attached to card");
		}
	}
	
	public void depositMoney(int amount) {
		if (this.bankAccount != null) {
			this.bankAccount.depositMoney(amount);
		}
		else {
			System.out.println(" no bank account attached to card");
		}
	}
	
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cvv=" + cvv + ", expiry=" + expiry + ", pin=" + pin
				+ ", bankAccount=" + bankAccount + "]";
	}
}
