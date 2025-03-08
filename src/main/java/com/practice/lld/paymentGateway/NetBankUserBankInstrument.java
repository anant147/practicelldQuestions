package com.practice.lld.paymentGateway;

public class NetBankUserBankInstrument extends UserBankInstrument {
	
	String netBankId;
	String password;
	
	public NetBankUserBankInstrument(int uid, int userid, String netBankId, String password) {
		super(uid, userid, InstrumentType.NETBANKING);
		this.netBankId = netBankId;
		this.password = password;
	}

	public String getNetBankId() {
		return netBankId;
	}

	public void setNetBankId(String netBankId) {
		this.netBankId = netBankId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserBankInstrument [uid=" + uid + ", userid=" + userid + ", type=" + type + ", netBankId " + netBankId 
				+ ", password " + password + "]";
	}

	@Override
	public boolean matchCredentials(InstrumentDo io) {
		return this.netBankId.equals(io.netBankId) && this.password.equals(io.password);
	}
}
