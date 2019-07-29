import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Slider
{
	private int myX, myY, myWidth = 60, myHeight = 10;
	public Slider(int x, int y) {
		myX = x;
		myY = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(myX, myY, myWidth, myHeight);
	}
	
	// getters
	public int getX() {
		return myX;
	}
	public int getY() {
		return myY;
	}
	public int getWidth() {
		return myWidth;
	}
	public int getHeight() {
		return myHeight;
	}
	// setters
	public void setX(int x) {
		myX = x;
	}
	public void setY(int y) {
		myY = y;
	}
	public void setWidth(int w) {
		myWidth = w;
	}
	// movement methods
	// possible addition - dx changes depending on difficulty?
	public void moveLeft() {
		myX -= 5;
		if(myX + myWidth / 2.0 < 0) {
			myX = (int) (Driver.WIDTH - myWidth / 2.0);
		}
	}
	public void moveRight() {
		myX += 5;
		if(myX + myWidth / 2.0 > Driver.WIDTH) {
			myX = (int) (0 - myWidth / 2.0);
		}
	}
}
