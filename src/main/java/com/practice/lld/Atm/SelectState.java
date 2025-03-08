package com.practice.lld.Atm;

public class SelectState extends AtmState  {
	
	@Override
	public void selectOperation(Atm atm, Card card, OperationType op) {
		System.out.println("select state , op : " + op);
		
		switch(op) {
		   case CASH_WITHDRAWAL: atm.setCurrentAtmState(new CashWithdrawalState()); 
		       break;
		   case BALANCE_CHECK : atm.setCurrentAtmState(new BalanceCheckState());
		      break;
		   case PIN_CHANGE: atm.setCurrentAtmState(new PinChangeState());
		      break;
		   default:
			   exit(atm, card);
		}
	}
	
	@Override
	public void exit(Atm atm, Card card) {
		System.out.println(" card is removed, user exited");
		atm.setCurrentAtmState(new IdleState());
	}
}
