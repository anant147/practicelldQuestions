package com.practice.lld.Swiggy;

public class SMSNotificationSender implements INotificationSender {

	@Override
	public void sendNotification(String userid, String message) {
		System.out.println(" sms notification for user : " + userid + " is '"+message+"'");
	}

}
