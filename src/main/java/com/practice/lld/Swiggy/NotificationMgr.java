package com.practice.lld.Swiggy;

import java.util.HashMap;
import java.util.Map;

public class NotificationMgr {
	
	private volatile static NotificationMgr notiMgrInstance = null;
	Map<String, Map<String, INotificationSender>> notificationSenderMap = null;
	
	private NotificationMgr() {
		this.notificationSenderMap = new HashMap<>();
	}
	
	public static NotificationMgr getNotificationMgr() {
		if (notiMgrInstance == null) {
			synchronized(NotificationMgr.class) {
				if (notiMgrInstance == null) {
					notiMgrInstance = new NotificationMgr();
				}
			}
		}
		return notiMgrInstance;
	}
	
	public void addNotificationSender(String orderid, String userid, INotificationSender sender) {
		Map<String, INotificationSender> temp = new HashMap<>();
		
		if (this.notificationSenderMap.containsKey(orderid)) {
			temp = this.notificationSenderMap.get(orderid);
		}
		else {
			this.notificationSenderMap.put(orderid, temp);
		}
		
		temp.put(userid, sender);
	}
	
	public void removeNotificationSender(String orderid, String userid, INotificationSender sender) {
		Map<String, INotificationSender> temp = this.notificationSenderMap.get(orderid);
		if (temp != null && temp.containsKey(userid)) {
			temp.remove(userid);
		}
	}
	
	public void notify(String orderId, String message) {
		Map<String, INotificationSender> temp = this.notificationSenderMap.get(orderId);
		
		if ( temp != null && temp.size()>0) {
			
			for(Map.Entry<String, INotificationSender> entry : temp.entrySet()) {
				entry.getValue().sendNotification(entry.getKey(), message);
			}
		}
	}
	
	public void notifyParticularUser(String userid, String msg, INotificationSender sender) {
		sender.sendNotification(userid, msg);
	}
}
