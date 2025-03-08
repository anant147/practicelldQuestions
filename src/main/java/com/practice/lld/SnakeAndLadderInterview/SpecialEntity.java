package com.practice.lld.SnakeAndLadderInterview;

public abstract class SpecialEntity {
	
	int st;
	int ed;
	SpecialEntityType type;
	
	public SpecialEntity(int x, int y, SpecialEntityType type) {
		this.st = x;
		this.ed= y;
		this.type = type;
	}
	
}
