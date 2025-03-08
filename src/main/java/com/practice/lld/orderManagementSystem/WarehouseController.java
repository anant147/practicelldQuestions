package com.practice.lld.orderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class WarehouseController {
	
	Map<Integer, Warehouse> warehouseMap;
	WarehouseSelectionStrategy strategy;
	
	public WarehouseController(){
		this.warehouseMap = new HashMap<>();
		this.strategy = new NearestWarehouseSelectionStrategy();
	}
	
	public void addWarehouse(Warehouse warehouse) {
		this.warehouseMap.put(warehouse.wid, warehouse);
	}
	
	public Warehouse getWarehouse(int wid) {
		if (this.warehouseMap.containsKey(wid)) {
			return this.warehouseMap.get(wid);
		}
		System.out.println(" no warehouse of " + wid + " present");
		return null;
	}
	

	public void removeWarehouse(Warehouse warehouse) {
		this.warehouseMap.remove(warehouse.wid);
	}
	
	public Warehouse selectWarehouse(WarehouseSelectionStrategyMethod method, Map<String, Integer> productCountMap, 
			Address deliveryAddress) {
		this.strategy = WarehouseSelectionStrategyFactory.getWarehouseSelectionStrategy(method);
		return strategy.selectWareHouse(this.warehouseMap, productCountMap, deliveryAddress);
	}
	
}
