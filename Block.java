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
   
   
   
   //block constructor
   public Block()
   {
      //setting up buffer
      myImage=new BufferedImage(Driver.WIDTH,Driver.HEIGHT,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      
      //defining private fields
      myLength=40;
      myWidth=35;
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
}
