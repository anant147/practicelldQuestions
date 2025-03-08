package com.practice.lld.liskovSubstitution;

public class ElectricCar implements Car {

	public void useEngine() {
		try {
			throw new Exception("no engine");
		}
		catch(Exception e) {
			System.out.println("ex :- " + e.getLocalizedMessage());
		}
	}

	@Override
	public int wheelCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
