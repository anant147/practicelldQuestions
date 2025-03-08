package com.practice.lld.Atm;

public class TwoThousandRupeesWithdrawProcessor extends CashWithdrawalProcessor {

	public TwoThousandRupeesWithdrawProcessor(CashWithdrawalProcessor next) {
		super(next);
	}
	
	public void withdrawAmount(Atm atm, int amount) {
		System.out.println(" 2000 rs pro, amount : " + amount);
		int notes = amount/2000;
		int remBal = amount%2000;
		
		if (notes != 0) {
			
			int nt = atm.noOfTwoThousandRupeesNotes>=notes ? notes : atm.noOfTwoThousandRupeesNotes;
			if (atm.noOfTwoThousandRupeesNotes>=notes) {
				atm.deductTwoThousandRupeesNotes(notes);
			}
			else {
				remBal = remBal + (notes-atm.noOfTwoThousandRupeesNotes) *2000;
				atm.deductTwoThousandRupeesNotes(atm.noOfTwoThousandRupeesNotes);
			}
			
			System.out.println(" No. of 2000 rs notes deducted : " + nt);
			
		}
		
		if (remBal != 0) {
			this.next.withdrawAmount(atm, remBal);
		}
	}

}
