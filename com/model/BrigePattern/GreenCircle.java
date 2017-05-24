package com.model.BrigePattern;

public class GreenCircle implements DrawAPI {

	@Override
	public void drawCircle(int x, int y, int radius) {
		System.out.println("Drawing Circle[ color:green,radius:"+
				radius+",x "+x+",y "+y+" ]");
	}

}
