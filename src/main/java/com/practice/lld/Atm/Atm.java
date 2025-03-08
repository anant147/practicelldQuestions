package com.practice.lld.Atm;

public class Atm {
	
	public AtmState currentAtmState;
	
	public int atmBalance;
	
	public int noOfTwoThousandRupeesNotes;
	public int noOfFiveHundredRupeesNotes;
	public int noOfOneHundredRupeesNotes;
	
	private Atm(int atmBalance, int noOfTwoThousandRupeesNotes, 
			int noOfFiveHundredRupeesNotes, int noOfOneHundredRupeesNotes) {
		this.atmBalance = atmBalance;
		this.noOfTwoThousandRupeesNotes = noOfTwoThousandRupeesNotes;
		this.noOfFiveHundredRupeesNotes = noOfFiveHundredRupeesNotes;
		this.noOfOneHundredRupeesNotes = noOfOneHundredRupeesNotes;
		this.currentAtmState = new IdleState();
	}
	
	public static Atm ATM_INSTANCE = null;
	
	public static Atm getAtmObject(int atmBalance, int noOfTwoThousandRupeesNotes, 
			int noOfFiveHundredRupeesNotes, int noOfOneHundredRupeesNotes) {
		if (ATM_INSTANCE == null) {
			ATM_INSTANCE = new Atm( atmBalance,  noOfTwoThousandRupeesNotes, 
					 noOfFiveHundredRupeesNotes,  noOfOneHundredRupeesNotes);
		}
		return ATM_INSTANCE;
	}
	
	public Atm getAtmObject() {
		return ATM_INSTANCE;
	}
	
	public void deductMoneyFromAtm(int amount) {
		this.atmBalance = this.atmBalance - amount;
		System.out.println( amount + " rs dedeucted from atm ");
	}
	
	public void deductTwoThousandRupeesNotes(int notes) {
		this.noOfTwoThousandRupeesNotes  = this.noOfTwoThousandRupeesNotes - notes;
	}
	
	public void deductFiveHundredRupeesNotes(int notes) {
		this.noOfFiveHundredRupeesNotes = this.noOfFiveHundredRupeesNotes - notes;
	}
	
	public void deductOneHundredRupeesNotes(int notes) {
		this.noOfOneHundredRupeesNotes = this.noOfOneHundredRupeesNotes - notes;
	}
	
	public void printAtmBalanceDetais() {
		System.out.println(" \n \n Atm balance details : ");
		System.out.println(" Atm balance : " + this.atmBalance);
		System.out.println(" no. of two thousand rupees notes : " + this.noOfTwoThousandRupeesNotes);
		System.out.println(" no. of five hundred rupees notes : " + this.noOfFiveHundredRupeesNotes);
		System.out.println(" no. of one hundred rupees notes : " + this.noOfOneHundredRupeesNotes);
	}

	public AtmState getCurrentAtmState() {
		return currentAtmState;
	}

	public void setCurrentAtmState(AtmState currentAtmState) {
		this.currentAtmState = currentAtmState;
	}

	public int getAtmBalance() {
		return atmBalance;
	}

	public void setAtmBalance(int atmBalance) {
		this.atmBalance = atmBalance;
	}

	public int getNoOfTwoThousandRupeesNotes() {
		return noOfTwoThousandRupeesNotes;
	}

	public void setNoOfTwoThousandRupeesNotes(int noOfTwoThousandRupeesNotes) {
		this.noOfTwoThousandRupeesNotes = noOfTwoThousandRupeesNotes;
	}

	public int getNoOfFiveHundredRupeesNotes() {
		return noOfFiveHundredRupeesNotes;
	}

	public void setNoOfFiveHundredRupeesNotes(int noOfFiveHundredRupeesNotes) {
		this.noOfFiveHundredRupeesNotes = noOfFiveHundredRupeesNotes;
	}

	public int getNoOfOneHundredRupeesNotes() {
		return noOfOneHundredRupeesNotes;
	}

	public void setNoOfOneHundredRupeesNotes(int noOfOneHundredRupeesNotes) {
		this.noOfOneHundredRupeesNotes = noOfOneHundredRupeesNotes;
	}
	
	
	

}
