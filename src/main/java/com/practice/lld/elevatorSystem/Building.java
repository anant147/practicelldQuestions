package com.practice.lld.elevatorSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Building {
	
	List<Floor> floors;
	Map<Integer, Floor> floorMap;
	List<ElevatorCarController> eccList;
	InternalButtonDispatcher ibd;
	ExternalButtonDispatcher ebd;
	
	public Building() {
		this.floors = new ArrayList<>();
		this.floorMap = new HashMap<>();
		this.eccList = new ArrayList<>();
		this.ibd = new InternalButtonDispatcher();
		this.ebd = new ExternalButtonDispatcher();
	}
	
	public void addFloor(Floor fl) {
		this.floors.add(fl);
		this.floorMap.put(fl.floorid, fl);
		fl.setExternalButtonDispatcher(this.ebd);
	}
	
	public void addElevatorCarController(ElevatorCarController ecc) {
		this.eccList.add(ecc);
		ecc.setInternalDispatcher(this.ibd);
		this.ibd.addElevatorController(ecc);
		this.ebd.addElevatorController(ecc);
	}
	
	public void setExternalButtonDispatcher(int floorid, ExternalButtonDispatcher dispatcher) {
		if (this.floorMap.containsKey(floorid)) {
			Floor fl = this.floorMap.get(floorid);
			fl.setExternalButtonDispatcher(dispatcher);
		}
		else {
			System.out.println(" floor : " + floorid + " is not in building");
		}
	}
	
	
	public void moveToDest(int floorid, int destFloor, Direction dir) {
		if (this.floorMap.containsKey(floorid)) {
			Floor fl = this.floorMap.get(floorid);
			ElevatorCarController el = fl.pressButton(dir);
			System.out.println(" elevator selected : " + el.ecid);
			el.moveToDest(destFloor, dir);
		}
		else {
			System.out.println(" floor : " + floorid + " is not in building");
		}
	}
	
	public void processElevatorRequests() {
		for (ElevatorCarController edd : this.eccList) {
			edd.processElevatorRequest();
		}
	}
}
