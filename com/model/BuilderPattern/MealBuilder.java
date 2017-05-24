package com.model.BuilderPattern;

public class MealBuilder {

	public Meal getVegBurger(){
		Meal meal=new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
		}

	public Meal getChickenBurger(){
		Meal meal=new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
		}
}
