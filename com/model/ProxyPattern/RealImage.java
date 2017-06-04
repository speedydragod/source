package com.model.ProxyPattern;

public class RealImage implements Image {

	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName=fileName;
		loadFromDisk();
	}
	
	private void loadFromDisk() {
		System.out.println("loading "+ fileName);
	}
	
	@Override
	public void display() {
		System.out.println("displaying "+ fileName);
	}

}
