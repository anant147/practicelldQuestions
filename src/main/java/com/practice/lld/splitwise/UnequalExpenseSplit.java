package com.practice.lld.splitwise;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit {

	@Override
	public boolean validateRequest(List<Split> splits, double amount) {
		
		double total = 0;
		for (Split split : splits) {
			total += split.amount;
		}
		
		return total == amount ? true : false;
	}

}
