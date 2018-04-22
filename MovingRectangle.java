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
		g.setColor(super.borderColor);
		g.fillRect(super.getX(), super.getY(), super.width, super.height);
		g.setColor(super.fillColor);
		g.drawRect(super.getX(), super.getY(), super.width, super.height);
	}
	
	
	public boolean contains(Point p) {
		if ((p.y < super.getY()) && (p.x > super.getX()) && (p.y > (super.getY() - super.height)) && (p.x < (super.getX() + super.width))) {
			return true;
		}
		return false;
	}
}
