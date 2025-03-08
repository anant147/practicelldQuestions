package com.practice.lld.Uber;

public class DefaultPricingStrategy implements PricingStrategy{

	@Override
	public double calculatePrice(TripMetadata tripMetaData) {
		System.out.println(" based on default strategy, price is 100");
		return 100.0;
	}

}
