package com.practice.lld.elevatorSystem;

public class Floor {
	
	int floorid;
	ExternalButton externalButton;
	
	public Floor(int floorid) {
		this.floorid = floorid;
		this.externalButton = new ExternalButton();
	}
	
	public void setExternalButtonDispatcher(ExternalButtonDispatcher externalButtonDispatcher) {
		this.externalButton.setExternalButtonDispatcher(externalButtonDispatcher);
	}
	
	public ElevatorCarController pressButton(Direction dir) {
		return this.externalButton.pressButton(this.floorid, dir);
	}
}
