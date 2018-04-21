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
	
	public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
		super(x, y, w, h, mw, mh, c, fc, pathType);
		int randomNum = ThreadLocalRandom.current().nextInt(2, 11);
		xNumBlock = randomNum;
		yNumBlock = randomNum;
	}
	
	public void draw(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		for (int x=0; x < xNumBlock; x++) {
			for (int y=0; y < yNumBlock; y++) {
				Rectangle2D rect = new Rectangle2D.Double(super.getX() + x*(super.width/xNumBlock), super.getY() + y*(super.height/yNumBlock), super.width/xNumBlock, super.height/xNumBlock);
				//g.drawRect(super.x, super.y, super.width/xNumBlock, super.height/yNumBlock);
				if (x%2 == y%2) {
					graphic2d.setPaint(super.borderColor);
				}
				else {
					graphic2d.setPaint(super.fillColor);
				}
				graphic2d.fill(rect);
			}
		}
	}
	
}