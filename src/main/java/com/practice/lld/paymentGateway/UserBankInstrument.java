package com.practice.lld.paymentGateway;

public abstract class UserBankInstrument {
	
	int uid;
	int userid;
	InstrumentType type;
	
	public UserBankInstrument(int uid, int userid, InstrumentType type) {
		this.uid = uid;
		this.userid = userid;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public InstrumentType getType() {
		return type;
	}

	public void setType(InstrumentType type) {
		this.type = type;
	}
	
	public abstract boolean matchCredentials(InstrumentDo io);
	
}
