/*
 *  ============================================================================================
 *  MovingPattern.java : Extends MovingRectangle and uses for loop to make cool pattern
 *  User can change colours, size and various other properties
 *  YOUR UPI: dpla823
 *  ============================================================================================
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovingPattern extends MovingRectangle {
	private double numCircles;
	
	public MovingPattern() {
		super();
	}
	
	public MovingPattern(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
	public void draw(Graphics g) {	
		//cast graphics into graphics 2D
		Graphics2D graphic2d = (Graphics2D) g;
		//loop through and create circles
		int bool = 0;
		//makes 36 squares
		for (int x=1; x < 37; x++) {			
			Rectangle2D shape = new Rectangle2D.Double(super.getX(), super.getY(), super.width/2, super.height/2);
			final AffineTransform saved = graphic2d.getTransform();
			//converts 10 to radians and rotates shape by 10 degrees
			final AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(x*10), super.getX(), super.getY());
			graphic2d.transform(rotate);
			//paints a different square colour every 9 squares
			if (x%9 == 0) {
				if (bool == 0) {
					graphic2d.setPaint(super.borderColor);
					bool = 1;
				}
				else {
					graphic2d.setPaint(super.fillColor);
					bool = 0;
				}
			}
			else {
				graphic2d.setPaint(super.fillColor);
			}
				
			
			graphic2d.fill(shape);
			graphic2d.setTransform(saved);
		}
		drawHandles(g);
		
	}
	
	public boolean contains(Point p) {
		//needs to make new contains since first square starts in centre of the pattern
		if ((p.y > (super.getY() - super.height/2)) && (p.x > (super.getX() - width/2)) && (p.y < (super.getY() + super.height/2 + super.height)) && (p.x < (super.getX() - width/2 + super.width))) {
			return true;
		}
		return false;
	}
	
}