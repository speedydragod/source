package com.model.FacadePattern;

public class ShapeMarket {
	
	private Circle circle;
	private Rectangle rectangle;
	private Square square;
	
	public ShapeMarket() {
		circle=new Circle();
		rectangle=new Rectangle();
		square=new Square();
	}
	
	public void drawCircle(){
		circle.draw();
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
		
	}
}
