package com.practice.lld.paymentGateway;

public class UpiUserBankInstrument extends UserBankInstrument {
	
	String upiId;
	String upiPin;
	
	public UpiUserBankInstrument(int uid, int userid, String upiId , String upiPin) {
		super(uid, userid, InstrumentType.UPI);
		this.upiId = upiId;
		this.upiPin = upiPin;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getUpiPin() {
		return upiPin;
	}

	public void setUpiPin(String upiPin) {
		this.upiPin = upiPin;
	}
	
	@Override
	public String toString() {
		return "UserBankInstrument [uid=" + uid + ", userid=" + userid + ", type=" + type + ", upiId " + upiId 
				+ ", upiPin " + upiPin + "]";
	}

	@Override
	public boolean matchCredentials(InstrumentDo io) {
		return this.upiId.equals(io.upiId) && this.upiPin.equals(io.upiPin);
	}
}
