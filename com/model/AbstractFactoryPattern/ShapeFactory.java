package com.model.AbstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Shape getShape(String shapeType) {
		if(shapeType==null)
			return null;
		if(shapeType.equalsIgnoreCase("rectrangle"))
		{
			return  new Rectangle();
		}else if(shapeType.equalsIgnoreCase("circle"))
		{
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("square"))
		{
			return new Square();
		}
		return null;
	}

}
