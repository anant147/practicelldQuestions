package com.practice.lld.paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	int bankId;
	String bankName;
	String address;
	List<InstrumentType> intTypes;
	
	public Bank(int bankId, String bankName, String address, List<InstrumentType> intTypes) {
		this.bankId = bankId;
		this.bankName = bankName;
		this.address = address;
		this.intTypes = intTypes;
	}
	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<InstrumentType> getIntTypes() {
		return intTypes;
	}

	public void setIntTypes(List<InstrumentType> intTypes) {
		this.intTypes = intTypes;
	}

	public void setSupportedInstrumentTypes(List<InstrumentType> instList) {
		this.intTypes = instList;
	}
	
	public void addInstType(InstrumentType type) {
		if (!this.intTypes.contains(type))
			this.intTypes.add(type);
	}
	
	
}
