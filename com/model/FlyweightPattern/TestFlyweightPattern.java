package com.model.FlyweightPattern;

import java.util.Random;
/**
 * 享元模式
 * @author kai.long001
 *
 */
public class TestFlyweightPattern {
	 private static final String colors[] = 
	      { "Red", "Green", "Blue", "White", "Black" };
	 
	 private static final Random RANDOM=new Random();
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			 Circle circle = 
			            (Circle)ShapeFactory.getCircle(getRandomColor());
			         circle.setX(getRandomX());
			         circle.setY(getRandomY());
			         circle.setRadius(100);
			         circle.draw();
		}
		
	}

	public  static String getRandomColor(){
		return colors[RANDOM.nextInt(colors.length)];
	}
	 
	public static int getRandomX(){
		return RANDOM.nextInt(100);
	}
	public static int getRandomY(){
		return RANDOM.nextInt(100);
	}
}
