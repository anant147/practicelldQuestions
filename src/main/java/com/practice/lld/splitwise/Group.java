package com.practice.lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {
	
	int gid;
	String name;
	List<User> users;
	List<Expense> expenses;
	ExpenseController expenseController;
	
	public Group(int gid, String name) {
		this.gid = gid;
		this.name = name;
		this.users = new ArrayList<>();
		this.expenses = new ArrayList<>();
		this.expenseController = new ExpenseController();
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void addExpense(int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		Expense expense = expenseController.createExpense(eid, description, amount, paidBy, splitType, splits);
		if (expense != null) {
			this.expenses.add(expense);
		}
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public ExpenseController getExpenseController() {
		return expenseController;
	}

	public void setExpenseController(ExpenseController expenseController) {
		this.expenseController = expenseController;
	}
	
	
}
