package com.practice.lld.elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ExternalButtonDispatcher {
	
	List<ElevatorCarController> elevList;
	
	public ExternalButtonDispatcher() {
		this.elevList = new ArrayList<>();
	}
	
	public void addElevatorController(ElevatorCarController elev) {
		this.elevList.add( elev);
	}
	
	public ElevatorCarController getElevator(int floor, Direction dir) {
		if (this.elevList != null && this.elevList.size()>0) {
			
			ElevatorCarController sel = null;
			
			for (ElevatorCarController elev : this.elevList) {
				int elevCurFloor = elev.elevator.currentFloor;
				Direction elevDir = elev.elevator.dir;
				System.out.println(" elev : " + elev.ecid + " elevCurFloor : " + elevCurFloor + " , elevDir : " + elevDir + " , curr floor : " + floor);
				if ( floor ==  elevCurFloor || (elevCurFloor < floor && elevDir == dir && dir == Direction.UP) || 
						(elevCurFloor > floor && elevDir == dir && dir == Direction.DOWN)) {
					sel = elev;
					break;
				}
				
			}
			
			return sel != null ? sel : this.elevList.get(0);
		}
		else {
			System.out.println(" elevaotor controllers are not configured to external button");
			return null;
		}
	}
}
