package com.model.BuilderPattern;

public class TestBuilderPattern {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegBurger = mealBuilder.getVegBurger();
		
		System.out.println("veg meal");
		vegBurger.showItems();
		System.out.println("Total Cost:"+vegBurger.getCost());
		
		Meal chickenBurger = mealBuilder.getChickenBurger();
		
		System.out.println("non-veg meal");
		chickenBurger.showItems();
		System.out.println("Total Cost:"+chickenBurger.getCost());
		
	}
}
