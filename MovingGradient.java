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
		this.randomNum = ThreadLocalRandom.current().nextInt(2, 5);
	}
	
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		double step = super.width/randomNum;
		for (int x=0; x<randomNum; x++) {
			Rectangle2D rect = new Rectangle2D.Double(super.getX()+x*step, super.getY(), super.width/randomNum, super.height);
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
	

	/*
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		
		GradientPaint newGradient = new GradientPaint(super.getX(), super.getY(), super.fillColor, super.getX(), super.getY() + super.height, super.borderColor);
		graphic2d.setPaint(newGradient);
		graphic2d.fill(new Rectangle(super.getX(), super.getY(), super.width, super.height));
	
	}
	*/
	

}

