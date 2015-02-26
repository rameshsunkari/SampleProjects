package org.thinkadv.dp.structural.bridge;

public class Triangle extends AbstractShape {

	public Triangle(Color c) {
        super(c);
    }
 
    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        getColor().applyColor();
    } 

}
