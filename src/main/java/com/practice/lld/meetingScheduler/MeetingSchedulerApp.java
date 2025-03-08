package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingSchedulerApp {
	
	List<Meeting> meetings;
	Map<Integer, Meeting> meetingMap;
	UserController userController;
	MeetingRoomManager meetingRoomManager;
	
	public MeetingSchedulerApp() {
		this.meetingMap = new HashMap<>();
		this.meetings = new ArrayList<>();
		this.userController = new UserController();
		this.meetingRoomManager = new MeetingRoomManager();
	}
	
	public void addUser(User user) {
		this.userController.addUser(user);
	}
	
	public void addUsers(List<User> users) {
		for (User user : users) {
			addUser(user);
		}
	}
	
	public void getUser(int userid) {
		this.userController.getUser(userid);
	}
	
	public void addMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoomManager.addMeetingRoom(meetingRoom);
	}
	
	public void addMeetingRooms(List<MeetingRoom> meetingRooms) {
		for (MeetingRoom mr : meetingRooms) {
			addMeetingRoom(mr);
		}
	}
	
	public Meeting bookMeeting(int mid, User user, int capacity, Interval interval) {
		List<MeetingRoom> avMeetingRooms = this.meetingRoomManager.getAvailbleMeetingRoom(capacity, interval);
		if (avMeetingRooms != null && avMeetingRooms.size()>0) {
			MeetingRoom meetingRoom = avMeetingRooms.get(0);
			this.meetingRoomManager.bookMeetingRoom(meetingRoom, interval);
			Meeting meeting = new Meeting( mid,  meetingRoom,  interval,  capacity,  user);
			addMeeting(meeting);
			return meeting;
		}
		else {
			System.out.println(" No meeting room available");
		}
		return null;
	}

	private void addMeeting(Meeting meeting) {
		this.meetingMap.put(meeting.mid, meeting);
		this.meetings.add(meeting);
	}
	
	public Meeting getMeeting(int mid) {
		Meeting meeting = this.meetingMap.get(mid);
		if (meeting != null) {
			return meeting;
		}
		System.out.println(" no meeting with id : " + mid);
		return null;
	}
	
	public void addUserInMeeting(int mid, User user) {
		Meeting meeting = getMeeting(mid);
		if (meeting != null) {
			meeting.addParticipant(user);
		}
	}
	
	public void notifyParticipantAboutMeeting(int mid) {
		Meeting meeting = getMeeting(mid);
		if (meeting != null) {
			String message = " Meeting : " + meeting.mid + " is schedued by user : " + meeting.organiser.uid + " from " + meeting.interval.start + " to " + meeting.interval.end + " on " + meeting.interval.date + " taking place at meeting room : " + meeting.meetingRoom.mrid;
			meeting.notifyParticipant(message);
		}
	}
	
}
