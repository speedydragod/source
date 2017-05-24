package com.model.AbstractFactoryPattern;
/**
 *抽象工厂测试案例 
 *
 */
public class TestAbstractFactory {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
		shapeFactory.getShape("circle").draw();
		shapeFactory.getShape("square").draw();
		shapeFactory.getShape("rectrangle").draw();
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		
		colorFactory.getColor("red").fill();;
		colorFactory.getColor("green").fill();
		colorFactory.getColor("red").fill();
	}

}
