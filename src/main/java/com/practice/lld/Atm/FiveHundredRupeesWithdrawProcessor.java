package com.practice.lld.Atm;

public class FiveHundredRupeesWithdrawProcessor extends CashWithdrawalProcessor {

	public FiveHundredRupeesWithdrawProcessor(CashWithdrawalProcessor next) {
		super(next);
	}
	
	public void withdrawAmount(Atm atm, int amount) {
		System.out.println(" 500 rs pro, amount : " + amount);

		int notes = amount/500;
		int remBal = amount%500;
		
		if (notes != 0) {
			
			int nt = (atm.noOfFiveHundredRupeesNotes>=notes) ? notes : atm.noOfFiveHundredRupeesNotes;
			
			if (atm.noOfFiveHundredRupeesNotes>=notes) {
				atm.deductFiveHundredRupeesNotes(notes);
			}
			else {
				remBal = remBal + (notes-atm.noOfFiveHundredRupeesNotes)*500;
				atm.deductFiveHundredRupeesNotes(atm.noOfFiveHundredRupeesNotes);
			}
			
			System.out.println(" No. of 500 rs notes deducted : " + nt);
		}
		
		if (remBal != 0) {
			super.withdrawAmount(atm, remBal);
		}
	}

}
