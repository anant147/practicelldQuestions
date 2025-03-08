package com.practice.lld.orderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	int uid;
	Map<String, Integer> productCountMap;
	
	public Cart(int uid) {
		this.uid = uid;
		this.productCountMap = new HashMap<>();
	}
	
	public void addProduct(String productCategory, int count) {
		this.productCountMap.put(productCategory, this.productCountMap.getOrDefault(productCategory, 0) + count );
	}
	
	public void removeProduct(String productCategory) {
		this.productCountMap.remove(productCategory);
	}
	
	public void decreaseProduct(String productCategory, int count) {
		if (this.productCountMap.containsKey(productCategory)) {
			int val = this.productCountMap.get(productCategory) - count;
			
			if (val > 0) {
				this.productCountMap.put(productCategory, val);
			}
			else {
				removeProduct(productCategory);
			}
		}
	}
	
	public void viewCart() {
		if (!this.productCountMap.isEmpty()) {
			System.out.println(" products (with count) in the cart of user : " + this.uid);
			for (Map.Entry<String, Integer> entry : this.productCountMap.entrySet()) {
				System.out.println( entry.getKey() + " : " + entry.getValue());
			}
		}
		else {
			System.out.println(" cart of user : " + this.uid + " is empty ");
		}
	}
	
	public void emptyCart() {
		System.out.println(" cart of user : " + this.uid + " is made empty");
		this.productCountMap = new HashMap<>();
	}

	@Override
	public String toString() {
		return "Cart [uid=" + uid + ", productCountMap=" + getProductCountMapStr(this.productCountMap) + "]";
	}

	private String getProductCountMapStr(Map<String, Integer> map) {
		
		if (map.isEmpty()) {
			return "cart is empty";
		}
		StringBuilder strb = new StringBuilder("");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			strb.append(" | " + entry.getKey() + " : " + entry.getValue());
		}
		strb.append(" | ");
		return strb.toString();
	}
	
}
