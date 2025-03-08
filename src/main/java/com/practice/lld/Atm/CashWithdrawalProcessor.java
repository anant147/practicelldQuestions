package com.practice.lld.Atm;

public abstract class CashWithdrawalProcessor {

	CashWithdrawalProcessor next;
	
	public CashWithdrawalProcessor(CashWithdrawalProcessor next) {
		this.next = next;
	}
	
	public void withdrawAmount(Atm atm, int amount) {
		if (this.next != null) {
			this.next.withdrawAmount(atm, amount);
		}
	}
}
