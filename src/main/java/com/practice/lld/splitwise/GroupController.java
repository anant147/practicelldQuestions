package com.practice.lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupController {
	
	List<Group> groups;
	Map<Integer, Group> groupMap; 
	
	public GroupController() {
		this.groups = new ArrayList<>();
		this.groupMap = new HashMap<>();
	}
	
	public void addGroup(Group group) {
		this.groups.add(group);
		this.groupMap.put(group.gid, group);
	}
	
	private Group getGroup(int gid) {
		return this.groupMap.get(gid);
	}
	
	public void addUser(int gid, User user) {
		Group group = getGroup(gid);
		if (group != null) {
			group.addUser(user);
		}
		else {
			System.out.println(" group : " + gid + " not exists");
		}
	}
	
	public void addExpense(int gid, int eid, String description, double amount, User paidBy, SplitType splitType, 
			List<Split> splits) {
		Group group = getGroup(gid);
		if (group != null) {
			group.addExpense(eid, description, amount, paidBy, splitType, splits);
		}
		else {
			System.out.println(" group : " + gid + " not exists");
		}
	}
}
