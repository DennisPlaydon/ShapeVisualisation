import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingGradient extends MovingRectangle {
	
	public MovingGradient() {
		super();
	}
	
	public MovingGradient(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
		
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		GradientPaint newGradient = new GradientPaint(super.getX(), super.getY(), super.fillColor, super.getX() + super.width, super.getY() + super.height, super.borderColor);
		graphic2d.setPaint(newGradient);
		graphic2d.fill(new Rectangle(super.getX(), super.getY(), super.width, super.height));
	}

}
