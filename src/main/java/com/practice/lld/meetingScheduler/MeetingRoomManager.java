package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomManager {
	
	List<MeetingRoom> meetingRooms;
	Map<MeetingRoom, MeetingRoomCalender> roomCalenderMap;
	
	public MeetingRoomManager() {
		this.meetingRooms = new ArrayList<>();
		this.roomCalenderMap = new HashMap<>();
	}
	
	public void addMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRooms.add(meetingRoom);
		this.roomCalenderMap.put(meetingRoom, new MeetingRoomCalender(meetingRoom.getMrid()));
	}
	
	public List<MeetingRoom> getAvailbleMeetingRoom(int capacity, Interval interval){
		
		List<MeetingRoom> avRooms = new ArrayList<>();
		
		for (Map.Entry<MeetingRoom, MeetingRoomCalender> entry : this.roomCalenderMap.entrySet()) {
			
			MeetingRoom mr = entry.getKey();
			MeetingRoomCalender mrc = entry.getValue();
			
			if ( capacity <= mr.getCapacity() && mrc.isIntervalAvailable(interval)) {
				avRooms.add(mr);
			}
		}
		
		return avRooms;
	}
	
	public void bookMeetingRoom(MeetingRoom mr, Interval interval) {
		MeetingRoomCalender mrc = this.roomCalenderMap.get(mr);
		if (mrc != null) {
			mrc.addInterval(interval);
			System.out.println(" interval : " + interval + " is added for mr : " + mr.mrid);
		}
		else {
			System.out.println(" no calender for mr : " + mr.getMrid());
		}
	}
	
	public List<Interval> getIntervalForMeetingRoom(int mrid){
		
		MeetingRoom mr = getMeetingRoom(mrid);
		if (mr != null) {
			MeetingRoomCalender mrc = this.roomCalenderMap.get(mr);
			if (mrc != null) {
				return mrc.getAllIntervals();
			}
		}
		
		return new ArrayList<>();
	}
	
	public List<Interval> getIntervalForMeetingRoomAndDate(int mrid, String date){
		
		MeetingRoom mr = getMeetingRoom(mrid);
		if (mr != null) {
			MeetingRoomCalender mrc = this.roomCalenderMap.get(mr);
			if (mrc != null) {
				return mrc.getIntervalsForDate(date);
			}
		}
		
		return new ArrayList<>();
	}

	public MeetingRoom getMeetingRoom(int mrid) {
		
		for (MeetingRoom mr : this.meetingRooms) {
			
			if (mrid == mr.getMrid()) {
				return mr;
			}
		}
		return null;
	}
	
	public void removeMeetingRoom(int mrid) {
		MeetingRoom mr = getMeetingRoom(mrid);
		if (mr != null) {
			this.meetingRooms.remove(mr);
		}
	}
}
