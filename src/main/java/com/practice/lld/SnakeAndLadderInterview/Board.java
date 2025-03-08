package com.practice.lld.SnakeAndLadderInterview;

import java.util.Map;
import java.util.Random;

public class Board {
	
	int n;
	int size;
	Map<Integer, SpecialEntity> specialEntiiesMap;
	private Random random;
	
	public Board(int n) {
		this.n  = n;
		this.size = n*n;
		this.random = new Random();
		createSnake();
		createLadder();
	}

	private void createLadder() {
		
		for (int i=0;i<this.n;i++) {
			int x= getRandomValue();
			int y = getRandomValue();
			int a = Math.max(x, y);
			int b = Math.min(x, y);
			this.specialEntiiesMap.put(a , new Snake(a, b));
		}
	}

	private void createSnake() {
		for (int i=0;i<this.n;i++) {
			int x= getRandomValue();
			int y = getRandomValue();
			int a = Math.max(x, y);
			int b = Math.min(x, y);
			this.specialEntiiesMap.put(b , new Ladder(b, a));
		}
	}
	
	public SpecialEntity getEntity(int pos) {
		return this.specialEntiiesMap.get(pos);
	}
	
	private int getRandomValue() {
		return this.random.nextInt(this.size);
	}
}
