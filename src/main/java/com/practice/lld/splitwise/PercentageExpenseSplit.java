package com.practice.lld.splitwise;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {

	@Override
	public boolean validateRequest(List<Split> splits, double amount) {
		
		int val = 0;
		
		for (Split split : splits) {
			val += split.percentage;
		}
		
		if (val != 100)
			return false;
		
		for (Split split : splits) {
			split.amount = (split.percentage * amount)/100;
		}
		
		return true;
	}

}
