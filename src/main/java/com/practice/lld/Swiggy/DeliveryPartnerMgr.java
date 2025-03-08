package com.practice.lld.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class DeliveryPartnerMgr {
	
	private volatile static DeliveryPartnerMgr deliveryPartnerMgrInstance = null;
	
	Map<String, DeliveryPartner> deliveryPartnerMap;
	
	private DeliveryPartnerMgr() {
		this.deliveryPartnerMap = new HashMap<>();
	}
	
	public static DeliveryPartnerMgr getDeliveryPartnerMgr() {
		if (deliveryPartnerMgrInstance == null) {
			synchronized(DeliveryPartnerMgr.class) {
				if (deliveryPartnerMgrInstance == null) {
					deliveryPartnerMgrInstance = new DeliveryPartnerMgr();
				}
			}
		}
		return deliveryPartnerMgrInstance;
	}
	
	public Map<String, DeliveryPartner> getDeliveryPartners(){
		return this.deliveryPartnerMap;
	}
	
	public void addDeliveryPartner(String name, DeliveryPartner deliveryPartner) {
		this.deliveryPartnerMap.put(name, deliveryPartner);
	}
	
	public DeliveryPartner getDeliveryPartner(String name) {
		return this.deliveryPartnerMap.get(name);
	}
	
}
