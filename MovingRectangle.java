import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MovingRectangle extends MovingShape {
		
	public MovingRectangle() {
		super();
	}
	
	public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
		super(x, y, w, h, mw, mh, c, fc, pathType);
	}
	
	
	public void draw(Graphics g) {
		g.drawRect(100, 150, 70, 50);
	}
	
	
	public boolean contains(Point p) {
		return true;
	}
}
