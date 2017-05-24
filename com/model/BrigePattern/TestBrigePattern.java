package com.model.BrigePattern;

public class TestBrigePattern {
	 
	public static void main(String[] args) {
		Shape redcCrcle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redcCrcle.draw();
		greenCircle.draw();
	}
	
	
}
