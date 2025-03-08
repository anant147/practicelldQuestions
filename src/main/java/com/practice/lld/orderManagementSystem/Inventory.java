package com.practice.lld.orderManagementSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	Map<String, ProductCategory> categoryMap;
	
	public Inventory() {
		this.categoryMap = new HashMap<>();
	}
	
	public void addProductCategory(ProductCategory pc){
		this.categoryMap.put(pc.categoryName, pc);
	}
	
	public void addProductInCategory(String category, Product product) {
		if (this.categoryMap.get(category) != null) {
			this.categoryMap.get(category).addProduct(product);
		}
		else {
			System.out.println(" inventory donot have category of " + category);
		}
	}
	
	public void addProductsInCategory(String category, List<Product> products) {
		if (this.categoryMap.get(category) != null) {
			this.categoryMap.get(category).addProducts(products);
		}
		else {
			System.out.println(" inventory donot have category of " + category);
		}
	}
	
	public void removeProduct(String category, int count) {
		if (this.categoryMap.get(category) != null) {
			this.categoryMap.get(category).removeProduct(count);
		}
		else {
			System.out.println(" inventory donot have category of " + category);
		}
	}
	
	public boolean isEnoughProductPresent(String category, int count) {
		if (this.categoryMap.get(category) != null) {
			return this.categoryMap.get(category).enoughProducts(count);
		}
		else {
			System.out.println(" inventory donot have category of " + category);
		}
		return false;
	}
	
	public double getPriceForProduct(String category, int count) {
		if (this.categoryMap.get(category) != null) {
			return this.categoryMap.get(category).getPriceForProduct(count);
		}
		else {
			System.out.println(" inventory donot have category of " + category);
		}
		return 0;
	}
	
}
