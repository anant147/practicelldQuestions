package com.practice.lld.orderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
	
	int productCategoryId;
	String categoryName;
	List<Product> products;
	double price;
	
	public ProductCategory(int productCategoryId, String categoryName, double price) {
		this.productCategoryId = productCategoryId;
		this.categoryName = categoryName;
		this.price = price;
		this.products = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void addProducts(List<Product> products) {
		this.products.addAll(products);
	}
	
	public void removeProduct(int count) {
		for (int i=1;i<=count;i++) {
			this.products.remove(0);
		}
	}
	
	public boolean enoughProducts(int count) {
		return count <= this.products.size();
	}
	
	public double getPriceForProduct(int count) {
		System.out.println(" count : " + count + " : price : " + this.price);
		return count * this.price;
	}
}
