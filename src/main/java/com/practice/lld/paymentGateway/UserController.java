package com.practice.lld.paymentGateway;

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
	
	public void addUser(User user) {
		if ( this.userMap.get(user.userid) == null) {
			this.userMap.put(user.userid, user);
		}
		else {
			System.out.println(" user : " + user.userid + " alredy exists");
		}	
	}
	
	public User getUser(int userid) {
		if (this.userMap.get(userid) != null ) {
			return this.userMap.get(userid);
		}
		System.out.println(" user : " + userid + " not exists");
		return null;
	}
}
