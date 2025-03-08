package com.practice.lld.Atm;

public class AtmRoom {
	
	public Atm atm;
	
	public AtmRoom(int atmBalance, int noOfTwoThousandRupeesNotes, 
			int noOfFiveHundredRupeesNotes, int noOfOneHundredRupeesNotes) {
		this.atm = Atm.getAtmObject(atmBalance, noOfTwoThousandRupeesNotes, noOfFiveHundredRupeesNotes, noOfOneHundredRupeesNotes);
	}
	
	public void cashWithdrawal(User user, String pin, int amount) {
		Card card = user.card;
		atm.getCurrentAtmState().insertCard(atm, card);
		atm.getCurrentAtmState().hasCard(atm, card, pin);
		atm.getCurrentAtmState().selectOperation(atm, card, OperationType.CASH_WITHDRAWAL);
		atm.getCurrentAtmState().cashWithdrawl(atm, card, amount);
	}
	
	public void checkBalance(User user, String pin) {
		Card card = user.card;
		atm.getCurrentAtmState().insertCard(atm, card);
		atm.getCurrentAtmState().hasCard(atm, card, pin);
		atm.getCurrentAtmState().selectOperation(atm, card, OperationType.BALANCE_CHECK);
		atm.getCurrentAtmState().checkBalance(atm, card);
	}
	
	public void pinChange(User user, String oldpin, String newpin) {
		Card card = user.card;
		atm.getCurrentAtmState().insertCard(atm, card);
		atm.getCurrentAtmState().hasCard(atm, card, oldpin);
		atm.getCurrentAtmState().selectOperation(atm, card, OperationType.PIN_CHANGE);
		atm.getCurrentAtmState().pinChange(atm, card, oldpin, newpin);
	}
	
	public void printAtmDetails() {
		this.atm.printAtmBalanceDetais();
	}
}
