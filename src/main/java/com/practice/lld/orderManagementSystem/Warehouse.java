package com.practice.lld.orderManagementSystem;

import java.util.List;
import java.util.Map;

public class Warehouse {
	
	int wid;
	Inventory inventory;
	Address address;
	
	public Warehouse(int wid,Inventory inventory, Address address) {
		this.wid = wid;
		this.address = address;
		this.inventory = inventory;
	}
	
	public int getWid() {
		return wid;
	}
	
	public void setWid(int wid) {
		this.wid = wid;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addProductCategory(ProductCategory pc) {
		this.inventory.addProductCategory(pc);
	}
	
	public void addProductForCategory(String pc, Product product) {
		this.inventory.addProductInCategory(pc, product);
	}
	
	public void addProductsForCategory(String pc, List<Product> products) {
		this.inventory.addProductsInCategory(pc, products);
	}
	
	public void removeProductForCategory(String pc, int count) {
		if (isEnoughProductPresent(pc, count)) {
			this.inventory.removeProduct(pc, count);
		}
	}
	
	public void removeProducts(Map<String, Integer> cartProduct) {
		for (Map.Entry<String, Integer> entry : cartProduct.entrySet()) {
			 removeProductForCategory(entry.getKey(), entry.getValue()) ;
		}
	}
	
	public boolean isEnoughProductPresent(String pc, int count) {
		return this.inventory.isEnoughProductPresent(pc, count);
	}
	
	public double getPriceForProducts(Map<String, Integer> productCountMap) {
		double amount = 0;
		
		for (String pc : productCountMap.keySet()) {
			Integer count = productCountMap.get(pc);
			System.out.println(pc + " : " + count);
			amount = amount + this.inventory.getPriceForProduct(pc, count);
		}
		return amount;
	}
	
	public boolean isCartProductPresent(Map<String, Integer> cartProduct) {
		
		for (Map.Entry<String, Integer> entry : cartProduct.entrySet()) {
			if ( !isEnoughProductPresent(entry.getKey(), entry.getValue()) ) {
				return false;
			}
		}
		return true;
	}
	
	
}
