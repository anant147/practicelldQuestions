package com.practice.lld.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	
	private volatile static UserManager userMgrInst = null;
	
	Map<String, User> userMap;
	
	private UserManager() {
		this.userMap = new HashMap<>();
	}
	
	public static UserManager getUserManager() {
		if (userMgrInst == null) {
			synchronized(UserManager.class) {
				if (userMgrInst == null) {
					userMgrInst = new UserManager();
				}
			}
		}
		
		return userMgrInst;
	}
	
	public User getUser(String name) {
		return this.userMap.get(name);
	}
	
	public void addUser(User user) {
		 this.userMap.put(user.name, user);
	}
	
	
}
