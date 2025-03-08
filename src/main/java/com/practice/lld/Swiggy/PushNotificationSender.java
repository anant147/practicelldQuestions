package com.practice.lld.Swiggy;

public class PushNotificationSender implements INotificationSender {

	@Override
	public void sendNotification(String userid, String message) {
		System.out.println(" push notification for user : " + userid + " is '" + message + "'" );
	}

}
