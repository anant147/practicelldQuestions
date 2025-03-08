package com.practice.lld.paymentGateway;

public class CardUserBankInstrument extends UserBankInstrument {

	String cardNumber;
	String cardPin;
	
	public CardUserBankInstrument(int uid, int userid, String cardNumber, String cardPin ) {
		super(uid, userid, InstrumentType.CARD);
		this.cardNumber = cardNumber;
		this.cardPin = cardPin;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}
	
	@Override
	public String toString() {
		return "UserBankInstrument [uid=" + uid + ", userid=" + userid + ", type=" + type + ", cardNumber " + cardNumber 
				+ ", cardPin " + cardPin + "]";
	}

	@Override
	public boolean matchCredentials(InstrumentDo io) {
		return this.cardNumber.equals(io.cardNumber) && this.cardPin.equals(io.cardPin);
	}
}
