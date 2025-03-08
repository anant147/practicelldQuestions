package com.practice.lld.Uber;

public class StrategyManager {
	
	private volatile static StrategyManager strategyManagerInstance = null;
	
	private StrategyManager() {
		
	}
	
	public static StrategyManager getStrategyManager() {
		if (strategyManagerInstance == null) {
			synchronized(StrategyManager.class) {
				if (strategyManagerInstance == null) {
					strategyManagerInstance = new StrategyManager();
				}
			}
		}
		return strategyManagerInstance;
	}
	
	public PricingStrategy determinePricingStrategy(TripMetadata tripMetadata) {
		System.out.println(" based on location and other factors ,setting pricing strategy");
		return new RatingBasedPricingStrategy();
	}
	
	public DriverMatchingStrategy determinDriverMatchingStrategy() {
		System.out.println("based on location and other factors, setting matching strategy");
		return new LeastTimeBasedMatchingStrategy();
	}
	
	
}
