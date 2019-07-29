import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Block
{
   //privatizing fields
   private int myLength;
   private int myWidth;
   
   
   
   //block constructor
   public Block()
   { 	
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
