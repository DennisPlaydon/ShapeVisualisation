import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovingGradient extends MovingRectangle {
	
	public MovingGradient() {
		super();
	}
	
	public MovingGradient(int topLeftX, int topLeftY, int width, int height, int marginWidth, int marginHeight, Color fillColor, Color borderColor, int pathType) {
		super(topLeftX, topLeftY, width, height, marginWidth, marginHeight, fillColor, borderColor, pathType);
	}
	/*	
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		int randomNum = ThreadLocalRandom.current().nextInt(2, 5);
		double step = super.width / randomNum;
		for (int x=0; x<randomNum; x++) {
			if (x % 2 == 0) {
				GradientPaint newGradient = new GradientPaint(super.getX()+x*step, super.getY(), super.fillColor, super.getX(), super.getY() + super.height, super.borderColor);
			}
			else {
				GradientPaint newGradient = new GradientPaint(super.getX()+x*step, super.getY(), super.fillColor, super.getY() + super.height, super.getX(), super.borderColor);		
			}

			graphic2d.setPaint(newGradient);
			graphic2d.fill(new Rectangle(super.getX()+x*step, super.getY(), super.width, super.height));
		}
		*/
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		GradientPaint newGradient = new GradientPaint(super.getX(), super.getY(), super.fillColor, super.getX() + super.width, super.getY() + super.height, super.borderColor);
		graphic2d.setPaint(newGradient);
		graphic2d.fill(new Rectangle(super.getX(), super.getY(), super.width, super.height));
	
	}

}

