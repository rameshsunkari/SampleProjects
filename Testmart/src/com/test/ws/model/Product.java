package com.test.ws.model;

public class Product {
	
	private String name;
	private String sku;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(String name, String sku, int i) {
		super();
		this.name = name;
		this.sku = sku;
		this.price = i;
	}
	
}
