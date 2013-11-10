package com.spring.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		throw (new RuntimeException());
	}

	
	public String showName(String name){
		
		this.name = name;
		return name;
//		throw (new RuntimeException());
		
		
	}
	@Override
	public String toString() {
		return "Triangle [name=" + name + "]";
	}
	
	

}
