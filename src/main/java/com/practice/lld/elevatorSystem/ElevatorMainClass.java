package com.practice.lld.elevatorSystem;

public class ElevatorMainClass {

	public static void main(String[] args) {
		
		Building building = new Building();
		building.addFloor(new Floor(0));
		building.addFloor(new Floor(1));
		building.addFloor(new Floor(2));
		building.addFloor(new Floor(3));
		building.addFloor(new Floor(4));
		building.addFloor(new Floor(5));
		
		building.addElevatorCarController(new ElevatorCarController(1));
		building.addElevatorCarController(new ElevatorCarController(2));
		
		building.moveToDest(1, 3, Direction.UP);
		building.moveToDest(2, 4, Direction.UP);
		
		building.processElevatorRequests();
		
		building.moveToDest(1, 5, Direction.UP);
		building.moveToDest(2, 3, Direction.UP);
		building.moveToDest(3, 1, Direction.DOWN);
		building.moveToDest(3, 2, Direction.DOWN);
		
		building.processElevatorRequests();
		
		
	}

}
