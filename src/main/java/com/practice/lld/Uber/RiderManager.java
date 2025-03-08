package com.practice.lld.Uber;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
	
	private volatile static RiderManager riderMgrInstance;
	
	Map<String, Rider> ridersMap;
	
	private RiderManager() {
		this.ridersMap = new HashMap<>();
	}
	
	public static RiderManager getRiderManager() {
		if (riderMgrInstance == null) {
			synchronized(RiderManager.class){
				if (riderMgrInstance == null) {
					riderMgrInstance = new RiderManager();
				}
			}
		}
		return riderMgrInstance;
	}
	
	public void addRider(Rider rider) {
		this.ridersMap.put(rider.name, rider);
	}
	
	public Rider getRider(String name) {
		return this.ridersMap.get(name);
	}
	
}
