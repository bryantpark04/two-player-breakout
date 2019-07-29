import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Block
{
   //privatizing fields
   private BufferedImage myImage;
   private Graphics myBuffer;
   private int myLength;
   private int myWidth;
   private int myX;
   private int myY;
   
   //block constructor
   public Block()
   {
      //setting up buffer
      myImage=new BufferedImage(Driver.WIDTH,Driver.HEIGHT,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      
      //defining private fields
      myLength=40;
      myWidth=35;
      for(int x=0;x<600;x+=40)
      {
         myX=x;
      }
      for(int x=0;x<280;x+=35)
      {
         myY=x;
      }

         
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
   
   //other methods
    private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2.0D) + Math.pow(y1 - y2, 2.0D));
   }

   public boolean inBlock(Ball ball)
   {
      for (int x = getX(); x <= getX() + getLength(); x++)
         for (int y = getY(); y <= getY() + getWidth(); y++)
            if (distance(x, y, ball.getX(), ball.getY()) <= 7.5)
               return true;
      return false;
   }
}
