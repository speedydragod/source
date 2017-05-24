package com.model.AbstractFactoryPattern;

public class FactoryProducer {

	public static AbstractFactory getFactory(String factoryType){
		if("color".equalsIgnoreCase(factoryType)){
			return new ColorFactory();
		}else if("shape".equalsIgnoreCase(factoryType)){
			return new ShapeFactory();
		}
		return null;
	}
	
}
