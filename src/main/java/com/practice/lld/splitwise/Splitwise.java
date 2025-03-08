package com.practice.lld.splitwise;

import java.util.List;

public class Splitwise {
	
	UserController userController;
	GroupController groupController;
	
	public Splitwise() {
		this.userController = new UserController();
		this.groupController = new GroupController();
	}
	
	public void addUser(User user) {
		this.userController.addUser(user);
	}
	
	public void addExpenseWithout(int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		this.userController.addExpense(eid, description, amount, paidBy, splitType, splits);
	}
	
	public void printUserDetails() {
		this.userController.printAllTheUserDetails();
	}
	
	private boolean isUserPresent(int userid) {
		return this.userController.getUser(userid) != null;
	}
	
	public void addGroup(Group group) {
		this.groupController.addGroup(group);
	}
	
	public void addUserInGroup(int gid, User user) {
		if (isUserPresent(user.userid)) {
			this.groupController.addUser(gid, user);
		}
		else {
			System.out.println(" user : " + user.userid + " is not present");
		}
	}
	
	public void addExpenseInGroup(int gid, int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		this.groupController.addExpense(gid, eid, description, amount, paidBy, splitType, splits);
	}
	
	
}
