package com.model.CommandPattern;
/**
 * 命令模式
 * @author kai.long001
 *
 */
public class TestCommandPattern {

	public static void main(String[] args) {
		Stock stock=new Stock();
		
		BuyStock buyStock=new BuyStock(stock);
		SellStock sellStock=new SellStock(stock);
		
		Broker broker=new Broker();
		
		broker.takeOrder(buyStock);
		broker.takeOrder(sellStock);
		
		broker.placeOrders();
	}
	
}
