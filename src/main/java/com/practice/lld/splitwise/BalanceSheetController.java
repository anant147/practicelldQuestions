package com.practice.lld.splitwise;

import java.util.List;

public class BalanceSheetController {

	public void updateUserBalanceSheetForExpense(Expense expense) {
		
		double amount = expense.amount;
		User paidBy = expense.paidBy;
		List<Split> splits = expense.splits;
		
		UserExpenseBalanceSheet sheet = paidBy.userBalanceSheet;
		sheet.totalPayment = sheet.totalPayment + amount;
		
		for (Split split : splits) {
			User splitUser = split.user;
			UserExpenseBalanceSheet sh = splitUser.userBalanceSheet;
			
			if (paidBy.userid == splitUser.userid) {
				sh.totalExpense = sh.totalExpense + split.amount;
			}
			else {
				Balance balance = new Balance();
				if (sheet.friendsBalance.containsKey(splitUser)) {
					balance = sheet.friendsBalance.get(splitUser);
				}
				else {
					sheet.friendsBalance.put(splitUser, balance);
				}
				balance.amountGetBack = balance.amountGetBack + split.amount;
				sheet.totalGetback = sheet.totalGetback + split.amount;
				
				sh.totalOwe = sh.totalOwe + split.amount;
				sh.totalExpense = sh.totalExpense + split.amount;
				
				Balance shBal = new Balance();
				if (sh.friendsBalance.containsKey(paidBy)) {
					shBal = sh.friendsBalance.get(paidBy);
				}
				else {
					sh.friendsBalance.put(paidBy, shBal);
				}
				
				shBal.amountOwe = shBal.amountOwe + split.amount;
			}
		}
	}
}
