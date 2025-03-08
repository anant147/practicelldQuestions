package com.practice.lld.elevatorSystem;

public class InternalButton {
	
	int eid;
	InternalButtonDispatcher internalDispatcher;
	
	public InternalButton(int eid) {
		this.eid = eid;
	}
	
	public void setInternalDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.internalDispatcher = internalDispatcher;
	}
	
	public void pressButton(int destFloorId, Direction dir ) {
		if (this.internalDispatcher != null) {
			this.internalDispatcher.pressButton(this.eid, destFloorId, dir);
		}
		else {
			System.out.println(" cannot process req. as internal dispatcher not integrated");
		}
	}
}
