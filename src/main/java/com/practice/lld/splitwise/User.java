package com.practice.lld.splitwise;

public class User {
	
	int userid;
	String userName;
	UserExpenseBalanceSheet userBalanceSheet;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserExpenseBalanceSheet getUserBalanceSheet() {
		return userBalanceSheet;
	}
	public void setUserBalanceSheet(UserExpenseBalanceSheet userBalanceSheet) {
		this.userBalanceSheet = userBalanceSheet;
	}
	
	public User(int userid, String userName) {
		this.userid = userid;
		this.userName = userName;
		this.userBalanceSheet = new UserExpenseBalanceSheet();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", userBalanceSheet=" + userBalanceSheet + "]";
	}
	
	public void printBalanceSheet() {
		System.out.println(" total payment " + this.userBalanceSheet.totalPayment);
		System.out.println(" total expense " + this.userBalanceSheet.totalExpense);
		System.out.println(" total owe " + this.userBalanceSheet.totalOwe);
		System.out.println(" total get back " + this.userBalanceSheet.totalGetback);
		
		System.out.println(" relations with other users");
		
		for (User user : this.userBalanceSheet.friendsBalance.keySet()) {
			Balance balance = this.userBalanceSheet.friendsBalance.get(user);
			System.out.println(" user : " + user.getUserid() + " , owe : " + balance.amountOwe + " , getback : " + balance.amountGetBack);
		}
		System.out.println();

	}
	
}
