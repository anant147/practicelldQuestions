package com.practice.lld.Atm;

public class HasState extends AtmState {
	
	@Override
	public void hasCard(Atm atm, Card card, String pin) {
		boolean val = isCorrectPin(card, pin);
		if (!val) {
			System.out.println(" input pin : " + pin + " is wrong");
			exit(atm, card);
			return;
		}
		System.out.println("Has state, user is moved to select state");
		atm.setCurrentAtmState(new SelectState());
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
