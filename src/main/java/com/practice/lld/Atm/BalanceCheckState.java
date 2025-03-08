package com.practice.lld.Atm;

public class BalanceCheckState extends AtmState{
	
	public void checkBalance(Atm atm, Card card) {
		System.out.println(" checking balance of user : " + card.bankAccount.accountHolder);
		System.out.println(" balance : " + card.bankAccount.balance);
		exit(atm, card);
	}
	
	@Override
	public void exit(Atm atm, Card card) {
		System.out.println(" card is removed, user exited");
		atm.setCurrentAtmState(new IdleState());
	}
}
