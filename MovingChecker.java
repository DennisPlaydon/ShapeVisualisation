import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovingChecker extends MovingRectangle {
	int xNumBlock;
	int yNumBlock;
	
	public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType) {
		super(x, y, w, h, mw, mh, c, fc, pathType);
		int randomNum = ThreadLocalRandom.current().nextInt(2, 11);
		xNumBlock = randomNum;
		yNumBlock = randomNum;
	}
	
	public void draw(Graphics g) {
		for (int x=0; x < xNumBlock; x++) {
			for (int y=0; y < yNumBlock; y++) {
				g.drawRect(super.x, super.y, super.width/xNumBlock, super.height/yNumBlock);
			}
		}
		
		//Rectangle2D rect = new Rectangle2D.Double(super.x, super.y, super.width/xNumBlock, super.height/yNumBlock);
	}
	
}