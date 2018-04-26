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

/*
public class MovingPattern extends MovingOval {
	private double numCircles;
	
	public MovingPattern() {
		super();
	}
	
	public MovingPattern(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
		//create random int for how many circles to create later
		int randomNum = ThreadLocalRandom.current().nextInt(6, 11);
		numCircles = randomNum;
	}
	
	public void draw(Graphics g) {
		//cast graphics into graphics 2D
		Graphics2D graphic2d = (Graphics2D) g;
		//loop through and create circles
		for (int x=0; x < numCircles; x++) {
			//reduces the width and height by 10(x)% every iteration
			Ellipse2D.Double oval = new Ellipse2D.Double(super.getX() + x*(super.width/numCircles), super.getY() + x*(super.height/numCircles), super.width*(1-(x*0.1)), super.height*(1-(x*0.1)));		
			//alternates colour every iteration
			if (x%2 == 0) {
				graphic2d.setPaint(super.borderColor);
			}
			else {
				graphic2d.setPaint(super.fillColor);
			}
			graphic2d.fill(oval);
		}
		drawHandles(g);
		
	}
	
}
*/
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
		for (int x=1; x < 37; x++) {		
			Rectangle shape = new Rectangle(super.getX(), super.getY(), super.width, super.height);
			final AffineTransform saved = graphic2d.getTransform();
			final AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(x*10), super.getX(), super.getY());
			graphic2d.transform(rotate);
			if (x%2 == 0) {
				graphic2d.setPaint(super.fillColor);
			}
			else {
				graphic2d.setPaint(super.borderColor);
			}
			graphic2d.fill(shape);
			graphic2d.setTransform(saved);
			

		}
		//drawHandles(g);
		
	}
	
}