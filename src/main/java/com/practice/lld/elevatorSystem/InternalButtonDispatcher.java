package com.practice.lld.elevatorSystem;

import java.util.HashMap;
import java.util.Map;

public class InternalButtonDispatcher {
	
	Map<Integer, ElevatorCarController> elevatorMap;
	
	public InternalButtonDispatcher() {
		this.elevatorMap = new HashMap<>();
	}
	
	public void addElevatorController(ElevatorCarController elev) {
		this.elevatorMap.put(elev.ecid, elev);
	}
	
	public void pressButton(int eid, int destFloorid, Direction dir) {
		if (this.elevatorMap.containsKey(eid)) {
			ElevatorCarController ecc = this.elevatorMap.get(eid);
			ecc.submitRequest(destFloorid, dir);
		}
		else {
			System.out.println(" there is no elevaotor : " + eid);
		}
	}
}
