package com.practice.lld.SnakeAndLadderInterview;

import java.util.Random;

public class Dice {
	
	int id;
	int min;
	int max;
	
	public Dice(int id) {
		this.id = id;
		this.min = 1;
		this.max = 6;
	}
	
	public int roll() {
		Random random = new Random();
		return random.nextInt(this.max - this.min+1) + this.min;
	}
}
