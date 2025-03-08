package com.practice.lld.paymentGateway;

public class InstrumentDo {
	
	int uid;
	int userid;
	InstrumentType type;
	
	String upiId;
	String upiPin;
	
	String netBankId;
	String password;
	
	String cardNumber;
	String cardPin;
	
	public InstrumentDo(int uid, int userid, InstrumentType type) {
		this.uid = uid;
		this.userid = userid;
		this.type = type;
	}
	
	public static InstrumentDo getInstrumentDoForCard(int uid, int userid, String cardNumber, String cardPin) {
		InstrumentDo id = new InstrumentDo( uid,  userid,  InstrumentType.CARD) ;
		id.cardNumber = cardNumber;
		id.cardPin = cardPin;
		return id;
	}
	
	public static InstrumentDo getInstrumentDoForUpi(int uid, int userid, String upiId,String upiPin) {
		InstrumentDo id = new InstrumentDo( uid,  userid,  InstrumentType.UPI) ;
		id.upiId = upiId;
		id.upiPin = upiPin;
		return id;
	}
	
	public static InstrumentDo getInstrumentDoForNetbank(int uid, int userid, String netBankId,
	String password) {
		InstrumentDo id = new InstrumentDo( uid,  userid,  InstrumentType.NETBANKING) ;
		id.netBankId = netBankId;
		id.password = password;
		return id;
	}
	
	public static CardUserBankInstrument makeCardIntrument(InstrumentDo io ) {
		return new CardUserBankInstrument(io.uid, io.userid, io.cardNumber, io.cardPin);
	}
	
	public static UpiUserBankInstrument makeUpiIntrument(InstrumentDo io ) {
		return new UpiUserBankInstrument(io.uid, io.userid, io.upiId, io.upiPin);
	}
	
	public static NetBankUserBankInstrument makeNetBankingIntrument(InstrumentDo io ) {
		return new NetBankUserBankInstrument(io.uid, io.userid, io.netBankId, io.password);
	}
}
