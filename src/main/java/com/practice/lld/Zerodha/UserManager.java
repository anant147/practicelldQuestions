package com.practice.lld.Zerodha;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	
	static Map<String, User> userMap = new HashMap<>();
	
	public UserManager() {
		userMap = new HashMap<>();
	}
	
	static User getUser(String userid) {
		return userMap.get(userid);
	}
	
	static void addUser(String userid, User user) {
		userMap.put(userid, user);
	}
}
