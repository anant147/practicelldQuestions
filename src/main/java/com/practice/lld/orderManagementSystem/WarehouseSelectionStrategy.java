package com.practice.lld.orderManagementSystem;

import java.util.Map;

public interface WarehouseSelectionStrategy {
	
	Warehouse selectWareHouse(Map<Integer, Warehouse> warehouseMap, Map<String, Integer> productCountMap, 
			Address deliveryAddress);
}
