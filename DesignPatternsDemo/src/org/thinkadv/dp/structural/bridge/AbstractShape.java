package org.thinkadv.dp.structural.bridge;

public abstract class AbstractShape implements Shape {
	private Color color;

	public AbstractShape() {

	}

	public AbstractShape(Color color) {
		super();
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}