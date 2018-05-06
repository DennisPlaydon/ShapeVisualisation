/*
 *  ============================================================================================
 *  MovingChecker.java : Extends MovingRectangle and uses for loops to create a checker pattern
 *  Contains draw method to that inherits properties from user but not contains
 *  YOUR UPI: dpla823
 *  ============================================================================================
 */


import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovingChecker extends MovingRectangle {
	private double xNumBlock;
	private double yNumBlock;
	
	public MovingChecker() {
		super();
		//creates random numbers between 2 and 11
		int randomNum = ThreadLocalRandom.current().nextInt(2, 11);
		int randomNum1 = ThreadLocalRandom.current().nextInt(2, 11);
		xNumBlock = randomNum;
		yNumBlock = randomNum1;
	}
	
	public MovingChecker(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
		int randomNum = ThreadLocalRandom.current().nextInt(2, 11);
		int randomNum1 = ThreadLocalRandom.current().nextInt(2, 11);
		xNumBlock = randomNum;
		yNumBlock = randomNum1;
	}
	
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		for (int x=0; x < xNumBlock; x++) {
			for (int y=0; y < yNumBlock; y++) {
				Rectangle2D rect = new Rectangle2D.Double(super.getX() + x*(super.width/xNumBlock), super.getY() + y*(super.height/yNumBlock), super.width/xNumBlock, super.height/yNumBlock);
				//alternates colour of squares
				if (x%2 == y%2) {
					graphic2d.setPaint(super.borderColor);
				}
				else {
					graphic2d.setPaint(super.fillColor);
				}
				graphic2d.fill(rect);
			}
		}
		drawHandles(g);
	}
	
}