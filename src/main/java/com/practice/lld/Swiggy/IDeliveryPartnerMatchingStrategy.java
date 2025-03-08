package com.practice.lld.Swiggy;

import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
	
	List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData metadata);
}
