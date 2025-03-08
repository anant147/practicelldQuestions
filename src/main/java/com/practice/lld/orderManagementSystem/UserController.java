package com.practice.lld.orderManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
	
	List<User> users;
	Map<Integer, User> userMap;
	
	public UserController() {
		this.users = new ArrayList<>();
		this.userMap = new HashMap<>();
	}
	
	public void addUser(User user) {
		this.users.add(user);
		this.userMap.put(user.uid, user);
	}
	
	public List<User> getAllUser() {
		return this.users;
	}
	
	public User getUser(int userid) {
		if (this.userMap.containsKey(userid)) {
			return this.userMap.get(userid);
		}
		else {
			System.out.println(" no user of " + userid + " present ");
		}
		return null;
	}
}
