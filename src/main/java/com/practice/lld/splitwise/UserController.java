package com.practice.lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
	
	List<User> users;
	Map<Integer, User> userMap;
	List<Expense> expenses;
	ExpenseController expenseController;
	
	public UserController() {
		this.users = new ArrayList<>();
		this.userMap = new HashMap<>();
		this.expenses = new ArrayList<>();
		this.expenseController = new ExpenseController();
	}
	
	public void addUser(User user) {
		this.users.add(user);
		this.userMap.put(user.userid, user);
	}
	
	public User getUser(int userid) {
		return this.userMap.get(userid);
	}
	
	public void addExpense(int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		Expense expense = this.expenseController.createExpense(eid, description, amount, paidBy, splitType, splits);
		this.expenses.add(expense);
	}
	
	public void printAllTheUserDetails() {
		
		for (User user : this.users) {
			System.out.println(" \n --------------------------- ");
			System.out.println(" User id : " + user.userid + " , name : " + user.userName);
			user.printBalanceSheet();
		}
	}
	
}
