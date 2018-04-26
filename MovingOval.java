import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingOval extends MovingShape {
		
	public MovingOval() {
		super();
	}
	
	public MovingOval(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
		
	public void draw(Graphics g) {
		g.setColor(super.borderColor);
		g.fillOval(super.getX(), super.getY(), super.width, super.height);
		g.setColor(super.fillColor);
		g.drawOval(super.getX(), super.getY(), super.width, super.height);
		drawHandles(g);
	}
	
	
	public boolean contains(Point p) {
		Point EndPt = new Point(super.getX() + super.width, super.getY() + super.height);
		double dx = (2 * p.x - super.getX() - EndPt.x) / (double) super.width;
		double dy = (2 * p.y - super.getY() - EndPt.y) / (double) super.height;
		return dx * dx + dy * dy < 1.0;
	}
}
