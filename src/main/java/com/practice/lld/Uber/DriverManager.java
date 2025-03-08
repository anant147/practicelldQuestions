package com.practice.lld.Uber;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
	
	private volatile static DriverManager driverMgrInstance;
	
	Map<String, Driver> driversMap;
	
	private DriverManager() {
		this.driversMap = new HashMap<>();
	}
	
	public static DriverManager getDriverManager() {
		if (driverMgrInstance == null) {
			synchronized(DriverManager.class) {
				if (driverMgrInstance == null) {
					driverMgrInstance = new DriverManager();
				}
			}
		}
		return driverMgrInstance;
	}
	
	public void addDriver(Driver driver) {
		this.driversMap.put(driver.name, driver);
	}
	
	public Driver getDriver(String name) {
		return this.driversMap.get(name);
	}
}
