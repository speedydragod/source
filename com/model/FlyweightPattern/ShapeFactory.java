package com.model.FlyweightPattern;

import java.util.HashMap;

public class ShapeFactory {

	private static final HashMap<String, Shape> HASH_MAP=new HashMap<>();
	
	public static Shape getCircle(String color) {
		
		Circle circle = (Circle) HASH_MAP.get(color);
		
		if(circle==null){
			circle=new Circle(color);
			HASH_MAP.put(color, circle);
			System.out.println("Creating circle of color: "+color);
		}
		return circle;
	}
	
}
