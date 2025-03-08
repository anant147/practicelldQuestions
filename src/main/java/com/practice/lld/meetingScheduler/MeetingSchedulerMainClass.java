package com.practice.lld.meetingScheduler;

import java.util.Arrays;

public class MeetingSchedulerMainClass {

	public static void main(String[] args) {

		MeetingSchedulerApp app = new MeetingSchedulerApp();
		
		// add User
		User user1 = new User(1, "user1");
		User user2 = new User(2, "user2");
		User user3 = new User(3, "user3");
		User user4 = new User(4, "user4");
		User user5 = new User(5, "user5");
		User user6 = new User(6, "user6");
		app.addUsers(Arrays.asList(user1, user2, user3, user4, user5, user6));
		
		// add meeting room
		Location loc1 = new Location(11, 11, 11, "A");
		Location loc2 = new Location(12, 12, 12, "B");
		MeetingRoom meetingRoom1 = new MeetingRoom(21, "room1", loc1, 5);
		MeetingRoom meetingRoom2 = new MeetingRoom(22, "room2", loc2, 5);
		app.addMeetingRooms(Arrays.asList(meetingRoom1, meetingRoom2));
		
		
		// schedule Meeting1
		Interval interval1 = new Interval("27-07-2024", 8, 10);
		Meeting meeting1 = app.bookMeeting(31, user1, 3, interval1);
		if (meeting1 != null) {
			app.addUserInMeeting(meeting1.mid, user2);
			app.addUserInMeeting(meeting1.mid, user3);
			app.notifyParticipantAboutMeeting(meeting1.mid);
		}
		
		System.out.println("\n \n \n ");

		Interval interval2 = new Interval("27-07-2024", 9, 11);
		Meeting meeting2 = app.bookMeeting(32, user4, 3, interval2);
		if (meeting2 != null) {
			app.addUserInMeeting(meeting2.mid, user5);
			app.addUserInMeeting(meeting2.mid, user6);
			app.notifyParticipantAboutMeeting(meeting2.mid);
		}
	}

}
