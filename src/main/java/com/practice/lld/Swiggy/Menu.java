package com.practice.lld.Swiggy;

import java.util.List;

public class Menu {
	
	List<Dish> dishes;
	
	public Menu(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	public List<Dish> getDishes(){
		return this.dishes;
	}
}
