import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Slider
{
   //privatizing fields
   private BufferedImage myImage;
   private Graphics myBuffer;
   private int myLength;
   private int myWidth;
   private int myX;
   private int myY;
   
   //slider constructor 
	public Slider() 
	{
      //setting up buffer
      myImage=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      
      //adding listeners
      addKeyListener(new Key());
      setFoucsable(true);
      
      //defining private fields
      myLength=75;
      myWidth=35;
      myX=262;
      myY=460;
   }
   
   //accessor methods
   public int getLength()
   {
      return myLength;
   }
   public int getWidth()
   {
      return myWidth;
   }
   public int getX()
   {
      return myX;
   }
   public int getY()
   {
      return myY;
   }
   
   //modifier methods
   public void setX(int x)
   {
      myX=x;
   }
   public void setY(int x)
   {
      myY=y;
   }
   
   //drawing the slider
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(Color.BLUE);
      myBuffer.fillRect(myX,myY,myLength,myWidth);
   }
   
   //movement
   public void moveLeft()
   {
      myBuffer.setColor(Color.BLUE);
      myBuffer.fillRect(myX-5,myY,myLength,myWidth);
   }
   public void moveRight()
   {
      myBuffer.setColor(Color.BLUE);
      myBuffer.fillRect(myX+5,myY,myLength,myWidth);
   }
   
   //offscreen correction
   public void offScreen()
   {
      while(myX<0)
      {
         setX(getX()+Driver.WIDTH);
      }
      while(myX>0)
      {
         setX(getX()-Driver.WIDTH);
      }
   }
}
