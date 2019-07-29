import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Block
{
	private int myX, myY, myWidth = 58, myHeight = 28;
	public Block(int x, int y) {
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
}
