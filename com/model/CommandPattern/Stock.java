package com.model.CommandPattern;

/**
 * 股票、股份、库存
 * @author kai.long001
 *
 */
public class Stock {

	
	private String name="ABC";
	//数量
	private int quantity;
	
	public void sell(){
		System.out.println("Stock [ name : "+name
				+" , quantity : "+quantity+" ] sell");
	}
	public void buy(){
		System.out.println("Stock [ name : "+name
				+" , quantity : "+quantity+" ] bought");
	}
}
