package com.practice.lld.Swiggy;

public class StrategyMgr {
	
	private volatile static StrategyMgr strategyMgrInstance = null;
	
	private StrategyMgr() {
		
	}
	
	public static StrategyMgr getStrategyMgr() {
		if (strategyMgrInstance == null) {
			synchronized(StrategyMgr.class) {
				if (strategyMgrInstance == null) {
					strategyMgrInstance = new StrategyMgr();
				}
			}
		}
		return strategyMgrInstance;
	}
	
	IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMgrStrategy(DeliveryMetaData metadata) {
		System.out.println("Based on location, weather and other factors, setting delivery partner matching strategy");
		return new LocBasedDeliveryPartnerMatchingStrategy();
	}

}
