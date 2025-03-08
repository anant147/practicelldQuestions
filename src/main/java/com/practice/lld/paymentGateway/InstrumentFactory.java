package com.practice.lld.paymentGateway;

public class InstrumentFactory {
	
	public static UserBankInstrument makeUserBankInstrument(InstrumentDo id) {
		if (InstrumentType.CARD == id.type) {
			return InstrumentDo.makeCardIntrument(id);
		}
		else if (InstrumentType.NETBANKING == id.type) {
			return InstrumentDo.makeNetBankingIntrument(id);
		}
		else if (InstrumentType.UPI == id.type) {
			return InstrumentDo.makeUpiIntrument(id);
		}
		System.out.println(" no instrument will be made, as no valid instr type is provided in input");
		return null;
	}
}
