package com.practice.lld.Swiggy;

import java.util.List;

public class DeliveryMgr {
	
	private volatile static DeliveryMgr deliveryMgrInstance = null;
	
	private DeliveryMgr() {}
	
	public static DeliveryMgr getDeliveryMgr() {
		if (deliveryMgrInstance == null) {
			synchronized(DeliveryMgr.class) {
				if (deliveryMgrInstance == null) {
					deliveryMgrInstance = new DeliveryMgr();
				}
			}
		}
		return deliveryMgrInstance;
	}
	
	public void manageDelivery(String orderid, DeliveryMetaData metadata) {
		
		StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
		
		IDeliveryPartnerMatchingStrategy partnerMatchingStrategy = strategyMgr.determineDeliveryPartnerMgrStrategy(metadata);
		
		List<DeliveryPartner> deliveryPartners = partnerMatchingStrategy.matchDeliveryPartners(metadata);
		
		NotificationMgr notiMgr = NotificationMgr.getNotificationMgr();
		
		for (DeliveryPartner deliveryPartner : deliveryPartners) {
			notiMgr.notifyParticularUser(deliveryPartner.name, "Delivery Request", new PushNotificationSender());
		}
		
		DeliveryPartner assignedDeliveryPartner = deliveryPartners.get(0);
		
		notiMgr.notify(orderid, "Delivery partner : " + assignedDeliveryPartner.name + " assigned for order : " + orderid);
		
		assignedDeliveryPartner.performDelivery(orderid, metadata);
	}
}
