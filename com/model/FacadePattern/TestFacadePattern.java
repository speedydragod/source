package com.model.FacadePattern;
/**
 * 外观模式
 * @author kai.long001
 *
 */
public class TestFacadePattern {
	
	public static void main(String[] args) {
		
		ShapeMarket market=new ShapeMarket();
		
		market.drawCircle();
		market.drawRectangle();
		market.drawSquare();
	}
}
