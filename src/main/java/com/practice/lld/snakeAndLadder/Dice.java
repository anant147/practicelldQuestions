package com.practice.lld.snakeAndLadder;

public class Dice {
	
	int min;
	int max;
	
	Dice(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	public int rollDice() {
		return (int) (Math.random() * (max - min)) + min;
	}
}
