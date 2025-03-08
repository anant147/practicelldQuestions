package com.practice.lld.Cricbuzz;

public class Person {
	
	int pid;
	String name;
	String age;
	String address;
	
	public Person(int pid, String name, String age, String address) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
