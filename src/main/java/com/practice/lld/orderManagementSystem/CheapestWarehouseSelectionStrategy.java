package com.practice.lld.orderManagementSystem;

import java.util.Map;

public class CheapestWarehouseSelectionStrategy implements WarehouseSelectionStrategy {
	
	
	@Override
	public Warehouse selectWareHouse( Map<Integer, Warehouse> warehouseMap,
			Map<String, Integer> productCountMap, Address deliveryAddress) {
		
		Warehouse ans = null;
		
		double maxcost = Integer.MAX_VALUE;
		
		for (Map.Entry<Integer, Warehouse> entry : warehouseMap.entrySet()) {
			
			Warehouse temp = entry.getValue();
			
			boolean val= temp.isCartProductPresent(productCountMap);
			System.out.println(" val : " + val);
			if (val) {
				double price = temp.getPriceForProducts(productCountMap);
				if (price < maxcost) {
					ans = temp;
					maxcost = price;
				}
			}
		}
		
		return ans;
	}

}
