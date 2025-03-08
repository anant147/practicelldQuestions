package com.practice.lld.snakeAndLadder;

public class Player {

	String name;
	int currentPos;
	
	public Player(String name) {
		this.name= name;
		this.currentPos = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}
}
