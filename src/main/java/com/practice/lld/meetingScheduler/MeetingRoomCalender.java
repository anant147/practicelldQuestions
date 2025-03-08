package com.practice.lld.meetingScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomCalender {
	
	int mrid;
	Map<String, List<Interval>> dateIntervalMap;
	
	public MeetingRoomCalender(int mrid) {
		this.mrid = mrid;
		this.dateIntervalMap = new HashMap<>();
	}
	
	public boolean isIntervalAvailable(Interval interval) {
		if (!this.dateIntervalMap.containsKey(interval.getDate()))
			return true;
		
		List<Interval> dateIntervals = this.dateIntervalMap.get(interval.getDate());
		
		for (Interval it : dateIntervals) {
			
			if ( ( it.getStart() < interval.getStart() && interval.getStart() < it.getEnd() )  || 
					( it.getStart() < interval.getEnd() && interval.getEnd() < it.getEnd() ) ) {
				System.out.println(" interval not available. as it with st : " + it.getStart() + " , end : " + it.getEnd() + " already present");
				return false;
			}
		}
		
		System.out.println(" meeting room : " + this.mrid + " is available for interval : " + interval.start + " to " + interval.end + " of " + interval.date);
		return true;
	}
	
	public void addInterval(Interval interval) {
		List<Interval> intervals = new ArrayList<>();
		if (!this.dateIntervalMap.containsKey(interval.getDate())) {
			this.dateIntervalMap.put(interval.getDate(), intervals);
		}
		else {
			intervals = this.dateIntervalMap.get(interval.getDate());
		}
		intervals.add(interval);
	}
	
	public List<Interval> getIntervalsForDate(String date){
		if (!this.dateIntervalMap.containsKey(date)) {
			System.out.println(" no interval booked for date : " + date + " and room : " + this.mrid);
			return null;
		}
		else {
			return this.dateIntervalMap.get(date);
		}
	}
	
	public List<Interval> getAllIntervals(){
		List<Interval> intervals = new ArrayList<>();
		for (Map.Entry<String, List<Interval>> entry : this.dateIntervalMap.entrySet()) {
			intervals.addAll(entry.getValue());
		}
		return intervals;
	}
}
