package com.practice.lld.Atm;

public class IdleState extends AtmState{
	
	@Override
	public void insertCard(Atm atm, Card card) {
		System.out.println(" IdleState , Card with holder : " + card.bankAccount.accountHolder + " has been inserted");
		atm.setCurrentAtmState(new HasState());
	}
}
