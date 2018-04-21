import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingGradient extends MovingRectangle {
		
	public MovingGradient(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
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
		Graphics2D graphic2d = (Graphics2D) g;
		GradientPaint newGradient = new GradientPaint(super.getX(), super.getY(), super.fillColor, super.getX() + super.width, super.getY() + super.height, super.borderColor);
		graphic2d.setPaint(newGradient);
		graphic2d.fill(new Rectangle(super.getX(), super.getY(), super.width, super.height));
	}

}
