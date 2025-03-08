package com.practice.lld.liskovSubstitution;

public class EngineCar implements Car {

	
	public void useEngine() {
		System.out.println("engine is in use");
		
	}

	@Override
	public int wheelCnt() {
		return 0;
	}

}
