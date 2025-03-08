package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class Notification {
	
	int nid;
	String message;
	List<User> users;
	
	public Notification(int nid) {
		this.nid = nid;
		this.users = new ArrayList<>();
	}
	
	public void addUsers(List<User> users) {
		this.users.addAll(users);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void setMessage(String message) {
		this.message = message;
		notifyUsers();
	}

	private void notifyUsers() {
		System.out.println("\n notifying participants");
		for (User user : this.users) {
			user.messageNotification(message);
		}
	}
}
