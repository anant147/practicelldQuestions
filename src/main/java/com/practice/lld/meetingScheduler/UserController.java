package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
	
	List<User> users;
	Map<Integer, User> userMap;
	
	public UserController() {
		this.userMap = new HashMap<>();
		this.users = new ArrayList<>();
	}
	
	public User getUser(int uid) {
		User user = this.userMap.get(uid);
		if (user != null)
			return user;
		System.out.println(" no user with id : " + uid);
		return null;
	}
	
	public void addUser(User user) {
		this.userMap.put(user.uid, user);
		this.users.add(user);
	}
	
	
}
