package com.practice.lld.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class OrderMgr {
	
	private volatile static OrderMgr orderMgrInstance = null;
	Map<String, Order> orderMap;
	DeliveryMgr deliveryMgr;
	FoodMgr foodMgr;
	
	private OrderMgr() {
		this.orderMap = new HashMap<>();
		this.deliveryMgr = DeliveryMgr.getDeliveryMgr();
		this.foodMgr = FoodMgr.getFoodMgr();
	}
	
	public static OrderMgr getOrderMgr() {
		if (orderMgrInstance == null) {
			synchronized(OrderMgr.class) {
				if (orderMgrInstance == null) {
					orderMgrInstance = new OrderMgr();
				}
			}
		}
		return orderMgrInstance;
	}
	
	public void addUserForNotificationUpdates(String orderid, Order order) {
		
		NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
		// we can add push or sms notification
		notificationMgr.addNotificationSender(orderid, order.getuserid(), new SMSNotificationSender());
		//this configuration level should be in user class and not in order mgr
	}
	
	public void manageDelivery(String orderid, Order order) {
		DeliveryMetaData metadata = new DeliveryMetaData(orderid, order.getUserLocation(), order.getRestaurantLocation());
		deliveryMgr.manageDelivery(orderid, metadata);
	}
	
	public void manageFood(String orderid, Order order) {
		foodMgr.prepareFood(orderid, order.getRestaurantId(), order.getDishes());
	}
	
	public void createOrder(String orderid, Order order) {
		
		orderMap.put(orderid, order);
		addUserForNotificationUpdates(orderid, order);
		
		manageFood(orderid, order);
		
		manageDelivery(orderid, order);
	}
	
	public Order getOrder(String orderid) {
		return this.orderMap.get(orderid);
	}
}
