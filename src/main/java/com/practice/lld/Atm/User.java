package com.practice.lld.Atm;

public class User {
	
	String userid;
	String userName;
	Card card;
	BankAccount bankAccount;
	
	public User(String userid, String userName, int balance) {
		this.userid = userid;
		this.userName = userName;
		this.bankAccount = new BankAccount(userid, userName, balance);
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(String cardNumber, String pin) {
		this.card = new Card(cardNumber, pin, this.bankAccount);
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", card=" + card + ", bankAccount=" + bankAccount
				+ "]";
	}
}
