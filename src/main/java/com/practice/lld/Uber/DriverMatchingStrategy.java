package com.practice.lld.Uber;

public interface DriverMatchingStrategy {
	
	public Driver matchDriver(TripMetadata tripMetadata);
}
