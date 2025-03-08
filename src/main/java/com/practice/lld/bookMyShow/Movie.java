package com.practice.lld.bookMyShow;

public class Movie {
	
	int mid;
	String mname;
	int duration;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Movie(int mid, String mname, int duration) {
		this.mid = mid;
		this.mname = mname;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", duration=" + duration + "]";
	}
	
}
