package com.practice.lld.Uber;

public interface PricingStrategy {
	
	public double calculatePrice(TripMetadata tripMetaData);
}
