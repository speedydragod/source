package com.model.BuilderPattern;

import java.util.ArrayList;

public class Meal {
	
	private	ArrayList<Item> items=new ArrayList<>();

	public void addItem(Item item){
		items.add(item);
	}
	
	public float getCost(){
		return items.stream().map(i->i.price()).reduce(0f, Float::sum);
	}
	
	public void showItems(){
		items.stream().forEach(item->{
			System.out.print("Item : "+item.name());
			System.out.print(", packing "+item.packing().pack());
			System.out.println(", price "+item.price());
		});
	}
}
