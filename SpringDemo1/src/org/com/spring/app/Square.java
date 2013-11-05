package org.com.spring.app;

import org.springframework.beans.factory.annotation.Required;

public class Square implements Shape {

	private int side;

	public Square() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}

	public Square(int side) {
		super();
		this.side = side;
	}

	public int getSide() {
		return side;
	}

	@Required
	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public void area() {
		System.out.println("Area of Square is: " + (getSide() * getSide()));

	}

}
