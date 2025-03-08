package com.practice.lld.SnakeAndLadderInterview;

public class Player {
	
	int id;
	String name;
	int currentPos;
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		this.currentPos = 0;
	}
	
	public void addValue(int val) {
		this.currentPos += val;
	}
	
	public int getCurrentPos() {
		return this.currentPos;
	}

}
