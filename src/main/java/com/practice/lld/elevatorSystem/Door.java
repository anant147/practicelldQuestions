package com.practice.lld.elevatorSystem;

public class Door {
	
	public void open(int elevator, int floor ) {
		System.out.println(" door of elevator : " + elevator + " at floor : " + floor + " opens");
	}
	
	public void close(int elevator, int floor ) {
		System.out.println(" door of elevator : " + elevator + " at floor : " + floor + " closes");
	}
}
