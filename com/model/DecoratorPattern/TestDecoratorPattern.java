package com.model.DecoratorPattern;
/**
 * 装饰器模式
 * @author kai.long
 *
 */
public class TestDecoratorPattern {

	public static void main(String[] args) {
		
		Shape circle=new Circle();
		
		Shape redCircle=new RedShapeDecorator(circle);
		
		Shape redRectangle=new RedShapeDecorator(new Rectangle());
		
		System.out.println("circle without border");
		circle.draw();
		
		System.out.println("\ncircle with red border");
		redCircle.draw();
		
		System.out.println("\nrectangle with red border");
		redRectangle.draw();
	}
}
