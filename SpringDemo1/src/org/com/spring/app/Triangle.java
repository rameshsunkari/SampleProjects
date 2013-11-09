package org.com.spring.app;

public class Triangle implements Shape{

	private int height;
	private int breadth;

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int height, int breadth) {
		super();
		this.height = height;
		this.breadth = breadth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	@Override
	public String toString() {
		return "Triangle [height=" + height + ", breadth=" + breadth + "]";
	}

	@Override
	public void area() {
		System.out.println("Area of Triangle is :" + 0.5 * (getBreadth() * getHeight()));
		
	}
	

}
