package com.practice.lld.couponOnShoppingCart;

public class Main {

	public static void main(String[] args) {
		
		Product item1 = new Item1("FAN", 1000, ProductType.ELECTRONICS_GOODS);
		Product item2 = new Item2("SOFA", 2000, ProductType.FURNITURE_GOODS);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(item2);
		cart.addToCart(item1);
		
		System.out.println("total price after discount :- " + cart.getTotalPrice());
	}

}
