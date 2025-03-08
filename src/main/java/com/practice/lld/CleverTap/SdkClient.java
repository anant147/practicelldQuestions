package com.practice.lld.CleverTap;

public class SdkClient {
	
	Producer producer;
	
	public SdkClient() {
		
	}
	
	public OurData produceOurData(int val) {
		return new OurData(val);
	}
}
