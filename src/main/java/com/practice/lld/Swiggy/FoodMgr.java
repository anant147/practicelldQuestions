package com.practice.lld.Swiggy;

import java.util.Map;

public class FoodMgr {
	
	private volatile static FoodMgr foodMgrInstance = null;
	
	private FoodMgr() {
		
	}
	
	public static FoodMgr getFoodMgr() {
		if (foodMgrInstance == null) {
			synchronized(FoodMgr.class) {
				if (foodMgrInstance == null) {
					foodMgrInstance = new FoodMgr();
				}
			}
		}
		return foodMgrInstance;
	}
	
	public void addRestaurantForNotificationUpdates(String orderid, String restid) {
		NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
		//we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customisable
		notificationMgr.addNotificationSender(orderid, restid, new PushNotificationSender());
	}
	
	/**
	 RestaurantMgr* restaurantMgr = RestaurantMgr::getRestaurantMgr();
	Restaurant* restaurant = restaurantMgr->getRestaurant(pRestaurantId);
	restaurant->prepareFood(pOrderId, pDishes);

	//Restaurant should receive the delivery partner's notifications. 
	//The order in which the restaurant, user & delivery partner are added to the notification mgr
	//will decide which notifications they receive
	//For interviews, This is too much detailing though, we can just mention to interviewer and move forward
	addRestaurantForNotificationUpdates(pOrderId, pRestaurantId);
	 */
	public void prepareFood(String orderId, String restid, Map<Dish, Integer> dishes) {
		RestaurantMgr restMgr = RestaurantMgr.getRestaurantMgr();
		Restaurant rest = restMgr.getRestaurant(restid);
		rest.prepareFood(orderId, dishes);
		
		//Restaurant should receive the delivery partner's notifications. 
		//The order in which the restaurant, user & delivery partner are added to the notification mgr
		//will decide which notifications they receive
		//For interviews, This is too much detailing though, we can just mention to interviewer and move forward
		addRestaurantForNotificationUpdates(orderId, restid);
	}
}
