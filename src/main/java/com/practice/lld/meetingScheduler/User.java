package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	int uid;
	String uname;
	List<Integer> meetingIds;
	
	public User(int uid, String uname) {
		this.uid = uid;
		this.uname = uname;
		this.meetingIds = new ArrayList<>();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public void addMeeting(int mid) {
		this.meetingIds.add(mid);
	}
	
	public void messageNotification(String message) {
		System.out.println("User : " + this.uid + ", message received : " + message);
	}
}
