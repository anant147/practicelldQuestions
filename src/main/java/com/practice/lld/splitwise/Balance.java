package com.practice.lld.splitwise;

public class Balance {
	
	double amountOwe;
	double amountGetBack;
	public double getAmountOwe() {
		return amountOwe;
	}
	public void setAmountOwe(double amountOwe) {
		this.amountOwe = amountOwe;
	}
	public double getAmountGetBack() {
		return amountGetBack;
	}
	public void setAmountGetBack(double amountGetBack) {
		this.amountGetBack = amountGetBack;
	}
	public Balance() {
		this.amountOwe = 0;
		this.amountGetBack = 0;
	}
	@Override
	public String toString() {
		return "Balance [amountOwe=" + amountOwe + ", amountGetBack=" + amountGetBack + "]";
	}
	
	
}
