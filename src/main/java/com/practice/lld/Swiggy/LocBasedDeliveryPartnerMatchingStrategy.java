package com.practice.lld.Swiggy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy {

	@Override
	public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData metadata) {
		DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
		
		System.out.println("Quadtrees can be used to get nearest delivery partners, \n Delivery partner manager can be used to get details of partners. \n Returning all delivery partners for demo purposes for now.");
		
		List<DeliveryPartner> deliveryPartners = new ArrayList<>();
		Map<String, DeliveryPartner> deliveryPartnerMap = deliveryPartnerMgr.getDeliveryPartners();
		for (Map.Entry<String, DeliveryPartner> entry : deliveryPartnerMap.entrySet()) {
			deliveryPartners.add(entry.getValue());
		}
		return deliveryPartners;
	}

}
