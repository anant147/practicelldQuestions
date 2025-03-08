package com.practice.lld.elevatorSystem;

public class ElevatorCar {
	
	int eid;
	Display display;
	int currentFloor;
	Direction dir;
	Status status;
	InternalButton internalButton;
	
	public ElevatorCar(int eid) {
		this.eid = eid;
		this.display = new Display();
		this.currentFloor = 0;
		this.dir = Direction.UP;
		this.status = Status.IDLE;
		this.internalButton=new InternalButton(eid);
	}
	
	public void setInternalDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.internalButton.setInternalDispatcher(internalDispatcher);
	}
	
	public void move( int floor, Direction dir) {
		this.internalButton.pressButton(floor, dir);
	}
	
	public void display() {
		display.display(currentFloor, dir);
	}
}
