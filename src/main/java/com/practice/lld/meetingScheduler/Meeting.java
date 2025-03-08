package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
	
	int mid;
	MeetingRoom meetingRoom;
	Interval interval;
	int capacity;
	User organiser;
	List<User> participants;
	MeetingStatus meetingStatus;
	Notification notification;
	
	public Meeting(int mid, MeetingRoom meetingRoom, Interval interval, int capacity, User organiser) {
		this.mid = mid;
		this.meetingRoom = meetingRoom;
		this.interval = interval;
		this.capacity = capacity;
		this.organiser = organiser;
		this.participants = new ArrayList<>();
		this.participants.add(organiser);
		organiser.addMeeting(mid);
		this.meetingStatus = MeetingStatus.SCEDULED;
		this.notification = new Notification(mid);
	}
	
	public void addParticipant(User user) {
		if (this.participants.size()<this.capacity) {
			this.participants.add(user);
			this.notification.addUser(user);
			user.addMeeting(this.mid);
		}
		else {
			System.out.println(" Meeting capacity has been reached");
		}
	}
	
	public void notifyParticipant(String message) {
		this.notification.setMessage(message);
	}

	@Override
	public String toString() {
		return "Meeting [mid=" + mid + ", meetingRoom=" + meetingRoom + ", interval=" + interval + ", capacity="
				+ capacity + ", organiser=" + organiser + ", participants=" + participants + ", meetingStatus="
				+ meetingStatus + ", notification=" + notification + "]";
	}
	
	
}
