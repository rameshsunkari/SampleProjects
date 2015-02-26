package org.thinkadv.dp.structural.bridge;

public class Pentagon extends AbstractShape {

	public Pentagon(Color c) {
        super(c);
    }
 
    @Override
    public void applyColor() {
    	System.out.print("Pentagon filled with color ");
        getColor().applyColor();
    } 

}
