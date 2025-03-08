package com.practice.lld.paymentGateway;

import java.util.Arrays;

public class PgMainClass {
	
	public static void main(String[] args) {
		
		PaymentGatewayController pg = new PaymentGatewayController();
		
		// add user 1 , user2
		User user1 = new User(1,"abc", "abc@gmail.com");
		User user2  = new User(2, "xyz", "xyz@gmail.com");
		pg.addUser(user1);
		pg.addUser(user2);
	
		// add bank 
		Bank sbi = new Bank(11, "SBI", "CiviLLines", 
				Arrays.asList(InstrumentType.CARD, InstrumentType.UPI, InstrumentType.NETBANKING));
		Bank hdfc = new Bank(12, "HDFC", "CiviLLines", 
				Arrays.asList(InstrumentType.CARD, InstrumentType.UPI, InstrumentType.NETBANKING));
		pg.addBank(hdfc);
		pg.addBank(sbi);
		
		// add user bank account
		pg.addUserBankAccount(1, "SBI", 31, 10000);
		pg.addUserBankAccount(2, "HDFC", 32, 20000);
		
		// add user bnak instrument
		InstrumentDo upi1 = InstrumentDo.getInstrumentDoForUpi(41, 1,  "abcupiid", "abcupipin");
		InstrumentDo card1 = InstrumentDo.getInstrumentDoForCard(42, 1, "abcCardNo", "abcCardPin");
		InstrumentDo netbank1 = InstrumentDo.getInstrumentDoForNetbank(43, 1, "abcNetbank", "abcNetBank");
		pg.addUserInstrument(1, "SBI", upi1);
		pg.addUserInstrument(1, "SBI", card1);
		pg.addUserInstrument(1, "SBI", netbank1);

		
		InstrumentDo upi2 = InstrumentDo.getInstrumentDoForUpi(51, 2,  "xyzupiid", "xyzupipin");
		InstrumentDo card2 = InstrumentDo.getInstrumentDoForCard(52, 2, "xyzCardNo", "xyzCardPin");
		InstrumentDo netbank2 = InstrumentDo.getInstrumentDoForNetbank(53, 2, "xyzNetbank", "xyzNetBank");
		pg.addUserInstrument(2, "HDFC", upi2);
		pg.addUserInstrument(2, "HDFC", card2);
		pg.addUserInstrument(2, "HDFC", netbank2);
		
		
		// show bank account details
		pg.showBalanceOfUser(1, "SBI");
		pg.showBalanceOfUser(2, "HDFC");
		
		System.out.println();

		pg.showAllUserBankAccounts(1);
		pg.showAllUserBankAccounts(2);
		
		// transfer money from user1 to user2
		System.out.println();
		pg.transferMoney(1, "SBI", 2, "HDFC", 5000, upi1);
		
		System.out.println();
		pg.transferMoney(2, "HDFC", 1, "SBI", 10000, netbank2);
		
		// print transaction history of user1 and user2
		System.out.println();
		pg.printTransactionHistory(1);
		
		System.out.println();
		pg.printTransactionHistory(2);


	}
}
