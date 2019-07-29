import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Ball
{
   //private fields
   private double myX, myY;
   private double mydx = 0.0, mydy = 0.0;
   private int myDiameter = 15;		
   public Ball(int x, int y)
   {
      myX = x;
      myY = y;
   }
	
	// instance methods
   public void update()
   {
      if(myX < 0 || myX > Driver.WIDTH - myDiameter) 	// checks if ball is off screen, and updates dx and dy accordingly
      {
         mydx *= -1;
      }
      if(myY < 0 || myY > Driver.HEIGHT - myDiameter)
      {
         mydy *= -1;
      }
   	
      myX += mydx;
      myY += mydy;
   }
   public void draw(Graphics g)
   {
      g.setColor(Color.BLUE);
      g.drawOval((int)myX, (int)myY, myDiameter, myDiameter);
   }
	
	// getters
   public double getX()
   {
      return myX;
   }
   public double getY()
   {
      return myY;
   }
   public double getdx()
   {
      return mydx;
   }
   public double getdy()
   {
      return mydy;
   }
	
	// setters
   public void setX(double x)
   {
      myX = x;
   }
   public void setY(double y)
   {
      myY = y;
   }
   public void setdx(double dx)
   {
      mydx = dx;
   }
   public void setdy(double dy)
   {
      mydy = dy;
   }
   
   //other methods
   public void move(double rightEdge, double bottomEdge)
   {
      setX(getX()+ mydx);                  // move horizontally
        
      if(getX() >= rightEdge - 7.5)  //hit right edge
      {
         setX(rightEdge - 7.5);
         mydx = mydx * -1; 
      }
      setY(getY()+ mydy);                  // move vert        
      if(getY() >= bottomEdge - 7.5)  //hit bottom edge
      {
         setY(bottomEdge - 7.5);
         mydy = mydy * -1; 
      }
      setX(getX()+ mydx);
      if(getX() <= 0 + 7.5)  //hit bottom edge
      {
         setX(0+ 7.5);
         mydx = mydx * -1; 
      }
      setY(getY()+ mydy);
      if(getY() <= 0 + 7.5)  //hit bottom edge
      {
         setY(0+ 7.5);
         mydy = mydy * -1; 
      }
      setX(getX()+ mydx);
         
          
   
         
   
   
   
                        
   }
}
