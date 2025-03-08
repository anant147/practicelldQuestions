package com.practice.lld.splitwise;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

	@Override
	public boolean validateRequest(List<Split> splits, double amount) {
		
		double val = amount/splits.size();
		
		for (Split split : splits) {
			if (split.amount != val)
				return false;
		}
		return true;
	}

}
