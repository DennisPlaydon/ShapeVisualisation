/*
 *  ============================================================================================
 *  MovingOval.java : Extends MovingShape and creates basic circle
 *  Contains draw method and contains with formula to see if user clicks within shape.
 *  YOUR UPI: dpla823
 *  ============================================================================================
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingOval extends MovingShape {
	
	//constructors create new MovingShape with super()
	public MovingOval() {
		super();
	}
	
	public MovingOval(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
		
	public void draw(Graphics g) {
		//sets border colour and fills
		g.setColor(super.borderColor);
		g.fillOval(super.getX(), super.getY(), super.width, super.height);
		//sets fill colour
		g.setColor(super.fillColor);
		g.drawOval(super.getX(), super.getY(), super.width, super.height);
		//draws handles around corners
		drawHandles(g);
	}
	
	
	public boolean contains(Point p) {
		//formula to see if click is within the circle
		Point EndPt = new Point(super.getX() + super.width, super.getY() + super.height);
		double dx = (2 * p.x - super.getX() - EndPt.x) / (double) super.width;
		double dy = (2 * p.y - super.getY() - EndPt.y) / (double) super.height;
		return dx * dx + dy * dy < 1.0;
	}
}
