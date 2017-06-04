package com.model.CommandPattern;
/**
 * 经纪人; 中间人，代理人; 旧货商人; 
 * @author kai.long001
 *
 */

import java.util.ArrayList;

public class Broker {

	private ArrayList<Order> orders=new ArrayList<>();
	
	 public void takeOrder(Order order){
	      orders.add(order);		
	   }

	   public void placeOrders(){
	      for (Order order : orders) {
	         order.execute();
	      }
	      orders.clear();
	   }
	
}
