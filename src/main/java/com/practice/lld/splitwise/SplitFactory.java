package com.practice.lld.splitwise;

public class SplitFactory {
	
	public static ExpenseSplit getExpenseSplit(SplitType splitType) {
		if (SplitType.EQUAL.equals(splitType))
			return new EqualExpenseSplit();
		else if (SplitType.UNEQUAL.equals(splitType))
			return new UnequalExpenseSplit();
		else if (SplitType.PERCENTAGE.equals(splitType))
			return new PercentageExpenseSplit();
		return null;
	}
}
