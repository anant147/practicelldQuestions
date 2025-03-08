package com.practice.lld.Atm;

public abstract class AtmState {
	
	public void insertCard(Atm atm, Card card) {
		System.out.println(" oops! this operation not possible");
	}
	
	public void hasCard(Atm atm, Card card, String pin) {
		System.out.println(" oops! this operation not possible");
	}
	
	public void selectOperation(Atm atm, Card card, OperationType op) {
		System.out.println(" oops! this operation not possible");
	}
	
	public void cashWithdrawl(Atm atm, Card card, int amount) {
		System.out.println(" oops! this operation not possible");
	}
	
	public void checkBalance(Atm atm, Card card) {
		System.out.println(" oops! this operation not possible");
	}
	
	public void pinChange(Atm atm, Card card, String oldpin, String newpin) {
		System.out.println(" oops! this operation not possible");
	}
		
	public void exit(Atm atm, Card card) {
		System.out.println(" oops! this operation not possible");
	}
}
