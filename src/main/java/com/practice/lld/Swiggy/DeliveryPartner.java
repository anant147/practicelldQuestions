package com.practice.lld.Swiggy;

public class DeliveryPartner extends IPartner {

	public DeliveryPartner(String name) {
		super(name);
	}
	
	public void performDelivery(String orderid, DeliveryMetaData metadata) {
		
		NotificationMgr notiMgr = NotificationMgr.getNotificationMgr();
		
		double restLatitute = metadata.getRestaurantLoc().latitude;
		double restLongitude = metadata.getRestaurantLoc().getLongitude();
		
		notiMgr.notify(orderid, this.name + " going to pick up delivery from location (" + restLatitute + " , " + restLongitude + ")");
		
		sleep();
		
		notiMgr.notify(orderid, this.name + " picked up deivery");
		
		sleep();
		
		notiMgr.notify(orderid, this.name + " on the way to deliver");
		
		sleep();
		
		double userLat = metadata.userLoc.latitude;
		double userLong = metadata.userLoc.longitude;
		notiMgr.notify(orderid, this.name + " has reached location (" + userLat + " , " + userLong + ")");
		
		sleep();
		
		notiMgr.notify(orderid, this.name + " delivered the order!. Congratulations");
	}
	
	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
