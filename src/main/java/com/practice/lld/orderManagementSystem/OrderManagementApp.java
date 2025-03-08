package com.practice.lld.orderManagementSystem;

import java.util.List;

public class OrderManagementApp {
	
	UserController userController;
	WarehouseController warehouseController;
	OrderController orderController;
	
	public OrderManagementApp() {
		this.userController = new UserController();
		this.warehouseController = new WarehouseController();
		this.orderController = new OrderController();
	}
	
	public void addUser(User user) {
		this.userController.addUser(user);
	}
	
	public User getUser(int uid) {
		return this.userController.getUser(uid);
	}
	
	public void addProductInUserCart(int uid, String product, int count) {
		User user = getUser(uid);
		if (user != null) {
			user.addProduct(product, count);
		}
	}
	
	public void removeProductInUserCart(int uid, String product) {
		User user = getUser(uid);
		if (user != null) {
			user.removeProduct(product);
		}
	}
	
	public void  decreaseProductInUserCart(int uid, String product, int count) {
		User user = getUser(uid);
		if (user != null) {
			user.decreaseProduct(product, count);
		}
	}
	
	public void viewUserCart(int uid) {
		User user = getUser(uid);
		if (user != null) {
			user.viewCartOfUser();
		}
	}
	
	public void emptyUserCart(int uid) {
		User user = getUser(uid);
		if (user != null) {
			user.emtpyCartOfUser();
		}
	}
	
	public void addWarehouse(Warehouse wh) {
		this.warehouseController.addWarehouse(wh);
	}
	
	public Warehouse getWarehouse(int wid) {
		return this.warehouseController.getWarehouse(wid);
	}
	
	public Warehouse selectWarehouse(User user, Address delAddr, WarehouseSelectionStrategyMethod method) {
		if (user != null) {
			if (user.isCartNotEmpty()) {
				System.out.println(" method : " + method);
				return this.warehouseController.selectWarehouse(method, user.cart.productCountMap, delAddr);
			}
			else {
				System.out.println(" cart of user : " + user.uid + " is empty");
			}
		}
		return null;
	}
	
	public void addProductCategory(int wid, ProductCategory productCategory) {
		Warehouse wh = getWarehouse( wid);
		if (wh != null) {
			wh.addProductCategory(productCategory);
		}
	}
	
	public void addProductForCategory(int wid, String pc, Product product) {
		Warehouse wh = getWarehouse( wid);
		if (wh != null) {
			wh.addProductForCategory(pc, product);
		}
	}
	
	public void addProductForCategory(int wid, String pc, List<Product> products) {
		Warehouse wh = getWarehouse( wid);
		if (wh != null) {
			wh.addProductsForCategory(pc, products);
		}
	}
	
	public Order placeOrder(int oid, int uid, Address delAddress, WarehouseSelectionStrategyMethod method) {
		User user = getUser(uid);
		
		if (user != null) {
			
			if (!user.isCartNotEmpty()) {
				System.out.println(" cart of user : " + uid + " not empty. ");
				return null;
			}
			
			Warehouse warehouse = getWarehouseForOrder(user, delAddress, method);
			if (warehouse != null ) {
				double price = warehouse.getPriceForProducts(user.cart.productCountMap);
				System.out.println("price : " + price);
				return this.orderController.placeOrder(oid, user, delAddress, warehouse, price);
			}
		}
		return null;
	}
	
	public Order getOrder(int oid) {
		return this.orderController.getOrder(oid);
	}
	
	public void makePayment(int oid, PaymentMode mode) {
		Order order = getOrder(oid);
		if (order != null) {
			order.makePayment(mode);
		}
	}
	
	public void completeOrder(int oid) {
		Order order = getOrder(oid);
		if (order != null) {
			order.completeOrder();
		}
	}
	
	private Warehouse getWarehouseForOrder(User user , Address delAddr, WarehouseSelectionStrategyMethod method) {
		Warehouse wh = selectWarehouse(user, delAddr, method);
		if (wh != null) {
			System.out.println(" warehouse : " + wh.wid + " is obtained for user : " + user.uid + " by method : " + method);
			return wh;
		}
		
		method = WarehouseSelectionStrategyMethod.CHEAPEST == method ? WarehouseSelectionStrategyMethod.NEAREST : WarehouseSelectionStrategyMethod.CHEAPEST;
		wh = selectWarehouse(user, delAddr, method);
		if (wh != null) {
			System.out.println(" warehouse : " + wh.wid + " is obtained for user : " + user.uid + " by method : " + method);
			return wh;
		}
		
		System.out.println(" no warehouse is found for user : " + user.uid);
		return wh;
	}
	
}
