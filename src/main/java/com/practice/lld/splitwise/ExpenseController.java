package com.practice.lld.splitwise;

import java.util.List;

public class ExpenseController {
	
	BalanceSheetController balanceSheetController;
	
	public ExpenseController(){
		this.balanceSheetController = new BalanceSheetController();
	}
	
	public Expense createExpense(int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		
		boolean isValid = SplitFactory.getExpenseSplit(splitType).validateRequest(splits, amount);
		if (!isValid) {
			System.out.println(" eid : " + eid + " is not valid");
			return null;
		}
		
		Expense expense = new Expense(eid, description, amount, paidBy, splitType, splits);
		this.balanceSheetController.updateUserBalanceSheetForExpense(expense);
		return expense;
		
	}
}
