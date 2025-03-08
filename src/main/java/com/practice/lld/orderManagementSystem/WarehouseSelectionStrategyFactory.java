package com.practice.lld.orderManagementSystem;

public class WarehouseSelectionStrategyFactory {
	
	public static WarehouseSelectionStrategy getWarehouseSelectionStrategy(WarehouseSelectionStrategyMethod method) {
		
		if (method == WarehouseSelectionStrategyMethod.CHEAPEST)
			return new CheapestWarehouseSelectionStrategy();
		else if (method == WarehouseSelectionStrategyMethod.NEAREST)
			return new NearestWarehouseSelectionStrategy();
		return null;
	}
}
