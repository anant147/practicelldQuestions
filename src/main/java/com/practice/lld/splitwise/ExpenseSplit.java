package com.practice.lld.splitwise;

import java.util.List;

public interface ExpenseSplit {
	
	boolean validateRequest(List<Split> splits, double total);
}
