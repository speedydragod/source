package com.model.ProxyPattern;
/**
 * 代理模式
 * @author kai.long001
 *1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 * 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 */
public class TestProxyPattern {

	public static void main(String[] args) {
		
		Image image=new ProxyImage("image_10.bmp");
		
		image.display();
		System.out.println("");
		
		image.display();
		
	}
}
