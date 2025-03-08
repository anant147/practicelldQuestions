package com.practice.lld.Atm;

public class OneHundredRupeesWithdrawProcessor extends CashWithdrawalProcessor {

	public OneHundredRupeesWithdrawProcessor(CashWithdrawalProcessor next) {
		super(next);
	}
	
	public void withdrawAmount(Atm atm, int amount) {
		System.out.println(" 100 rs pro, amount : " + amount);
		int notes = amount/100;
		atm.deductOneHundredRupeesNotes(notes);
		System.out.println(" No. of 100 rs notes deducted : " + notes);
	}

}
