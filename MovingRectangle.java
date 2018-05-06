/*
 *  ============================================================================================
 *  MovingRectangle.java : Extends MovingShape. Basic rectangle class that is used as a super class 
 *  for others
 *  Contains draw method and contains to check if click is within box
 *  YOUR UPI: dpla823
 *  ============================================================================================
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingRectangle extends MovingShape {
		
	public MovingRectangle() {
		super();
	}
	
	public MovingRectangle(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
		
	public void draw(Graphics g) {
		//create border colour
		g.setColor(super.borderColor);
		g.fillRect(super.getX(), super.getY(), super.width, super.height);
		//fills with user defined colour.
		g.setColor(super.fillColor);
		g.drawRect(super.getX(), super.getY(), super.width, super.height);
		drawHandles(g);
	}
	
	
	public boolean contains(Point p) {
		//first contains class that many other subclasses will link to
		if ((p.y > super.getY()) && (p.x > super.getX()) && (p.y < (super.getY() + super.height)) && (p.x < (super.getX() + super.width))) {
			return true;
		}
		return false;
	}
}
