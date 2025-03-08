package com.practice.lld.elevatorSystem;

public class ExternalButton {
	
	ExternalButtonDispatcher externalButtonDispatcher;
	
	public void setExternalButtonDispatcher( ExternalButtonDispatcher externalButtonDispatcher) {
		this.externalButtonDispatcher = externalButtonDispatcher;
	}
	
	public ElevatorCarController pressButton(int floor, Direction dir) {
		if (this.externalButtonDispatcher != null) {
			return this.externalButtonDispatcher.getElevator(floor, dir);
		}
		else {
			System.out.println(" cannot process req . as dispatcher is not attached");
			return null;
		}
	}
}
