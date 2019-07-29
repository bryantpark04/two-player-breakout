import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball
{
   private double myX, myY, mydx, mydy; 	// private fields
   private int myDiameter = 10; 	
   public Ball(double x, double y, double dx, double dy) { 	// constructor
		myX = x;
		myY = y;
		mydx = dx;
		mydy = dy;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int) myX, (int) myY, myDiameter, myDiameter);
	}
	public int update() {
		if(myX < 0 || myX > Driver.WIDTH - myDiameter) {
			mydx *= -1;
		}
		if(myY < 0 || myY > Driver.HEIGHT - myDiameter) {
			mydy *= -1;
		}
		//if(myY > Driver.HEIGHT - myDiameter) { 	// condition for loss - move to separate method and call from Panel???
			//return 1;
		//}
		
		myX += mydx;
		myY += mydy;
		
		return 0;
	}
	
	// getters
	public double getX() {
		return myX;
	}
	public double getY() {
		return myY;
	}
	public int getDiameter() {
		return myDiameter;
	}
	public double getdx() {
		return mydx;
	}
	public double getdy() {
		return mydy;
	}
	// setters
	public void setX(double x) {
		myX = x;
	}
	public void setY(double y) {
		myY = y;
	}
	public void setdx(double dx) {
		mydx = dx;
	}
	public void setdy(double dy) {
		mydy = dy;
	}
}
