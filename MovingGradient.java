/*
 *  ============================================================================================
 *  MovingGradient.java : Extends MovingRectangle and creates a new rectangle with a gradient
 *  Contains draw method to that inherits properties from user
 *  YOUR UPI: dpla823
 *  ============================================================================================
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MovingGradient extends MovingRectangle {
	private int randomNum;
	
	public MovingGradient() {
		super();
		this.randomNum = ThreadLocalRandom.current().nextInt(2, 5);
	}
	
	public MovingGradient(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
		//create random number to control how many gradient colours
		this.randomNum = ThreadLocalRandom.current().nextInt(2, 5);
	}
	
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		double step = super.width/randomNum;
		//creates number of columns according to random number created earlier
		for (int x=0; x<randomNum; x++) {
			Rectangle2D rect = new Rectangle2D.Double(super.getX()+x*step, super.getY(), super.width/randomNum, super.height);
			//alternates the gradient. In even columns, gradient goes from top to bottom and odd goes bottom to top
			if (x % 2 == 0) {
				GradientPaint newGradient = new GradientPaint(super.getX(), super.getY(), super.fillColor, super.getX(), super.getY() + super.height, super.borderColor);
				graphic2d.setPaint(newGradient);
			}
			else {
				GradientPaint newGradient = new GradientPaint(super.getX(), super.getY()+super.height, super.fillColor, super.getX(), super.getY(), super.borderColor);
				graphic2d.setPaint(newGradient);
			}

			graphic2d.fill(rect);
			drawHandles(g);
		}
	}
	
}

