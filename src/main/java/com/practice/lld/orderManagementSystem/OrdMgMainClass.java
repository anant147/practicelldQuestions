package com.practice.lld.orderManagementSystem;

import java.util.Arrays;

public class OrdMgMainClass {
	
	public static void main(String[] args) {
		OrderManagementApp app = new OrderManagementApp();
		
		// add User
		User user1 = new User(1, "user1");
		user1.addProduct("Pen", 1);
		user1.addProduct("Pencil", 1);
		app.addUser(user1);
		
		
		User user2 = new User(2, "user2");
		user2.addProduct("Pen", 1);
		user2.addProduct("Pencil", 1);
		app.addUser(user2);
		
		// Address 
		Address addr1 = new Address(11,"Noida", "UP");
		Address addr2 = new Address(12,"Ghaziabad", "UP");
		Address addr3 = new Address(13,"Mohannagar", "UP");


		
		// Warehouse
		Inventory inv1 = new Inventory();
		ProductCategory pc1 = new ProductCategory(21, "Pen", 10);
		Product pd1 = new Product(31, "pen1");
		Product pd2 = new Product(32, "pen2");
		pc1.addProducts(Arrays.asList(pd1, pd2));
		inv1.addProductCategory(pc1);

		
		ProductCategory pc2 = new ProductCategory(22, "Pencil", 15);
		Product pd3 = new Product(35, "pencil1");
		Product pd4 = new Product(36, "pencil2");
		pc2.addProducts(Arrays.asList(pd3, pd4));
		inv1.addProductCategory(pc2);
		
		
		Warehouse wh1 = new Warehouse(41, inv1, addr1);
	    
		app.addWarehouse(wh1);
		
		/////
		Inventory inv2 = new Inventory();
		ProductCategory pc3 = new ProductCategory(61, "Pen", 8);
		Product pd21 = new Product(62, "pen1");
		Product pd22 = new Product(63, "pen2");
		pc3.addProducts(Arrays.asList(pd21, pd22));
		inv2.addProductCategory(pc3);

		
		ProductCategory pc4 = new ProductCategory(64, "Pencil", 12);
		Product pd23 = new Product(65, "pencil1");
		Product pd24 = new Product(66, "pencil2");
		pc4.addProducts(Arrays.asList(pd23, pd24));
		inv2.addProductCategory(pc4);
		
		Warehouse wh2 = new Warehouse(67, inv2, addr3);
		app.addWarehouse(wh2);
		
		// order 
		Order order1 = app.placeOrder(51, 1, addr1, WarehouseSelectionStrategyMethod.NEAREST);
		
		if (order1 != null) {
			order1.makePayment(PaymentMode.CASH);
			order1.completeOrder();
		}
		
		System.out.println("\n\n");
		// order
		Order order2 = app.placeOrder(52, 2, addr1, WarehouseSelectionStrategyMethod.CHEAPEST);
		
		if (order2 != null) {
			order2.makePayment(PaymentMode.UPI);
			order2.completeOrder();
		}
		
		
	}
}
