package com.practice.lld.Atm;

public class CashWithdrawalState extends AtmState {
	
	@Override
	public void cashWithdrawl(Atm atm, Card card, int amount) {
		
		System.out.println(" cash withdrawal state, amount to be taken : " + amount);
		
		if (!hasBalanceInCard(card, amount)) {
			System.out.println(amount + "  rs not present in card ");
		}
		else if (!hasBalanceInAtm(atm, amount)) {
			System.out.println(amount + "  rs not present in atm ");
		}
		else {
			atm.deductMoneyFromAtm(amount);
			card.deductBalance(amount);
			CashWithdrawalProcessor processor = new TwoThousandRupeesWithdrawProcessor( new FiveHundredRupeesWithdrawProcessor( new OneHundredRupeesWithdrawProcessor( null)));
			processor.withdrawAmount(atm, amount);
		}
		
		exit(atm, card);
		
	}
	
	private boolean hasBalanceInAtm(Atm atm, int amount) {
		return atm.atmBalance>=amount;
	}

	private boolean hasBalanceInCard(Card card, int amount) {
		return card.bankAccount.balance>=amount;
	}

	@Override
	public void exit(Atm atm, Card card) {
		System.out.println(" card is removed, user exited");
		atm.setCurrentAtmState(new IdleState());
	}
}
