package com.practice.lld.Swiggy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SwiggyMainClass {
	
	public static void main(String[] args) {
		
		// chinese restaurant
		RestaurantOwner owner1 = new RestaurantOwner("owner1");
		Restaurant chineseRest = new Restaurant("chinese wala", owner1, new Location(1,2));
		Dish noodles = new Dish("noodles", Cusine.CHINESE, 200);
		noodles.addOn(new DishAddOn("premium sauce", 20));
		
		Dish friedRice = new Dish("fried rice", Cusine.CHINESE, 180);
		Dish springRolls = new Dish("spring rolls", Cusine.CHINESE, 120);
		Menu chinese_menu = new Menu(Arrays.asList(noodles, friedRice, springRolls));
		chineseRest.addMenu(chinese_menu);
		
		// south indian rest
		RestaurantOwner owner2 = new RestaurantOwner("owner2");
		Restaurant southIndianRest = new Restaurant("south indian", owner2, new Location(3,4));
		Dish idli = new Dish("idli", Cusine.SOUTH_INDIAN, 200);
		Dish dosa = new Dish("dosa", Cusine.SOUTH_INDIAN, 180);
		Dish uthapam = new Dish("uthapam", Cusine.SOUTH_INDIAN, 120);
		Menu southIndianMenu = new Menu(Arrays.asList(idli, dosa, uthapam));
		southIndianRest.addMenu(southIndianMenu);
		
		//Note that restaurant owners can exist without restaurants, we have used aggregation relationship
		//This can lead to owners being present with no restaurants and thus not added in restaurant manager
		//This is how we have designed and we should know consequences of the way we have structured.
		
		RestaurantMgr restMgr = RestaurantMgr.getRestaurantMgr();
		restMgr.addRestaurant(southIndianRest.name, southIndianRest);
		restMgr.addRestaurant(chineseRest.name, chineseRest);
		
		//////////////////////////////////////////////////////////
		
		DeliveryPartner alpha = new DeliveryPartner("alpha");
		DeliveryPartner beta = new DeliveryPartner("beta");
		DeliveryPartner gamma = new DeliveryPartner("gamma");
		
		DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
		deliveryPartnerMgr.addDeliveryPartner("gamma", gamma);
		deliveryPartnerMgr.addDeliveryPartner("beta", beta);
		deliveryPartnerMgr.addDeliveryPartner("alpha", alpha);
		
		///////////////////////////////////////////////////
		
		User keerti = new User("keerti", new Location(11, 12));
		User gaurav = new User("gaurav", new Location(13, 14));
		User yogita = new User("yogita", new Location(15, 16));
		
		UserManager userMgr = UserManager.getUserManager();
		userMgr.addUser(yogita);
		userMgr.addUser(gaurav);
		userMgr.addUser(keerti);
		
		/////////////////////////////////////////////////////////////////////
		
		//I am passing same dish object that was created by res, for C++ folks - it should be different dish object

		Map<Dish, Integer> cart = new HashMap<>();
		cart.put(noodles, 2);
		cart.put(friedRice, 1);
		
		Order order1 = new Order("order1", keerti, chineseRest, cart);
		
		OrderMgr orderMgr = OrderMgr.getOrderMgr();
		orderMgr.createOrder("order1", order1);

	}
}
