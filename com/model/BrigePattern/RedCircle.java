package com.model.BrigePattern;

public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int x, int y, int radius) {
		System.out.println("Drawing Circle[ color:red,radius:"+
				radius+",x "+x+",y "+y+" ]");
	}

}
