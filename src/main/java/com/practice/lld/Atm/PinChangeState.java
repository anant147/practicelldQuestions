package com.practice.lld.Atm;

public class PinChangeState extends AtmState {
	
	public void pinChange(Atm atm, Card card, String oldpin, String newpin) {
		System.out.println(" pin change state, user : " + card.bankAccount.accountHolder);
		boolean val = isCorrectPin(card, oldpin);
		if (!val) {
			System.out.println(" input old pin : " + oldpin + " is wrong, so new pin cannot be set");
			exit(atm, card);
			return;
		}
		else {
			card.pin = newpin;
			System.out.println(" new pin is set for user : " + card.bankAccount.accountHolder);
		}
		exit(atm, card);
	}
	
	private boolean isCorrectPin(Card card, String pin) {
		return card.pin.equals(pin);
	}
	
	
	@Override
	public void exit(Atm atm, Card card) {
		System.out.println(" card is removed, user exited");
		atm.setCurrentAtmState(new IdleState());
	}
}
