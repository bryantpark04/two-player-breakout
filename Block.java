import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

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
      myImage=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      
      //adding listeners
      addKeyListener(new Key());
      setFocusable(true);
      
      //defining private fields
      myLength=40;
      myWidth=35;
      for(int x=0;x<Driver.WIDTH;x+=40)
      {
         myX=x;
      }
      for(int y=100;y<380;y+=35)
      {
         myY=y;
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
   
   //modifier methods
   public void setX(int x)
   {
      myX=x;
   }
   public void setY(int x)
   {
      myY=y;
   }
   
   //drawing block
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(Color.RED);
      myBuffer.fillRect(myX,myY,myLength,myWidth);
   }
}
