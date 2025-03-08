package com.practice.lld.Swiggy;

public class LocBasedDeliveryChargecalculationStrategy implements DeliveryChargeCalculationStrategy {

	@Override
	public double calculateDeliveryCharge(DeliveryMetaData metadata) {
		System.out.println(" delivery charge is decided based on location. setting to 20 as default value for now");
		return 20;
	}

}
