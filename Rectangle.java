import java.awt.*;
import java.awt.image.*;

public abstract class Rectangle {
   private int myX, myY, myWidth, myHeight;
   public Rectangle(int x, int y, int w, int h) {
      myX = x;
      myY = y;
      myWidth = w;
      myHeight = h;
   }
	
   public void draw(Graphics g) {
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
}
