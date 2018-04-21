import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingOval extends MovingShape {
		
	public MovingOval() {
		super();
	}
	
	public MovingOval(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
		/** constuctor to create a shape
     * @param x         the x-coordinate of the new shape
     * @param y        the y-coordinate of the new shape
     * @param w         the width of the new shape
     * @param h         the height of the new shape
     * @param mw         the margin width of the animation panel
     * @param mh        the margin height of the animation panel
     * @param c        the colour of the new shape
     * @param typeOfPath         the path of the new shape
     */
		super(x, y, w, h, mw, mh, c, fc, pathType);
	}
		
	public void draw(Graphics g) {
		System.out.print("Draw method");
		/*
		g.setColor(super.borderColor);
		g.fillOval(super.getX(), super.getY(), super.width, super.height);
		g.setColor(super.fillColor);
		g.drawOval(super.getX(), super.getY(), super.width, super.height);
		*/
	}
	
	
	public boolean contains(Point p) {
		Point EndPt = new Point(super.getX() + super.width, super.getY() + super.height);
		double dx = (2 * p.x - x - EndPt.x) / (double) super.width;
		double dy = (2 * p.y - y - EndPt.y) / (double) super.height;
		return dx * dx + dy * dy < 1.0;
	}
}
