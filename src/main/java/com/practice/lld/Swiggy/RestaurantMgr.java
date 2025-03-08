package com.practice.lld.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class RestaurantMgr {
	
	private volatile static RestaurantMgr restMgrInstance = null;
	Map<String, Restaurant> restMap;
	
	private RestaurantMgr() {
		this.restMap = new HashMap<>();
	}
	
	public static RestaurantMgr getRestaurantMgr() {
		if (restMgrInstance == null) {
			synchronized(RestaurantMgr.class) {
				if (restMgrInstance == null) {
					restMgrInstance = new RestaurantMgr();
				}
			}
		}
		return restMgrInstance;
	}
	
	public void addRestaurant(String restName, Restaurant rest) {
		this.restMap.put(restName, rest);
	}
	
	public Restaurant getRestaurant(String restName) {
		return this.restMap.get(restName);
	}
}
