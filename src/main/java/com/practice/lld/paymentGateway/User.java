package com.practice.lld.paymentGateway;

public class User {
	
	int userid;
	String name;
	String email;
	
	public User(int userid, String name, String email) {
		this.userid = userid;
		this.name = name;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + "]";
	}
	
}
