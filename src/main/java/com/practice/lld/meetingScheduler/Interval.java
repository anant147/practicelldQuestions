package com.practice.lld.meetingScheduler;

public class Interval {
	
	String date;
	int start;
	int end;
	
	public Interval(String date, int start, int end) {
		this.date = date;
		this.start = start;
		this.end = end;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [date=" + date + ", start=" + start + ", end=" + end + "]";
	}
	
}
