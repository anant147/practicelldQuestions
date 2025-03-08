package com.practice.lld.orderManagementSystem;

import java.util.Map;


public class NearestWarehouseSelectionStrategy implements WarehouseSelectionStrategy {

	@Override
	public Warehouse selectWareHouse(Map<Integer, Warehouse> warehouseMap, 
			Map<String, Integer> productCountMap, Address deliveryAddress) {
		
		Warehouse ans = null;
		
		int distance = Integer.MAX_VALUE;
		
		for (Map.Entry<Integer, Warehouse> entry : warehouseMap.entrySet()) {
			Warehouse temp = entry.getValue();
			boolean val1 = sameAddress(deliveryAddress, temp.address);
			boolean val2 = temp.isCartProductPresent(productCountMap);
			System.out.println(" val1 : " + val1 + " val2 : " + val2);
			if ( val1 && val2 ) {
				ans = temp;
				break;
			}
			
			int newDist = distance(temp.address, deliveryAddress);
			if (newDist < distance && temp.isCartProductPresent(productCountMap) ) {
				ans = temp;
				distance = newDist;
			}
		}
		
		return ans;
	}

	private int distance(Address address, Address deliveryAddress) {
		return Math.abs( address.pincode - deliveryAddress.pincode);
	}

	private boolean sameAddress(Address delAdr, Address adr) {
		return delAdr.pincode == adr.pincode;
	}
}
