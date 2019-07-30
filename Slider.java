/**
 * A Slider is a Rectangle that maintains information about its dimensions and position. 
 * A Slider knows how to move left and right.
 * @author Bryant Park
 * @author Gregory Byun
 * @version 2019-07-30
 */

import java.awt.*;
import java.awt.image.*;

public class Slider extends Rectangle
{
   /**
    * Constructs a Slider of width x and height y.
    * @param x    initial width
    * @param y    initial height
    */
   public Slider(int x, int y) {
      super(x, y, 60, 10);
   }
	
	// movement methods
   // possible addition - dx changes depending on difficulty?
   /**
    * Shifts the Slider's position to the left by 5 pixels
    */
   public void moveLeft() {	
      setX(getX() - 5);
      if(getX() + getWidth() / 2.0 < 0) {
         setX((int) (Driver.WIDTH - getWidth() / 2.0));
      }
   }
   /**
    * Shifts the Slider's position to the right by 5 pixels
    */
   public void moveRight() {
      setX(getX() + 5);
      if(getX() + getWidth() / 2.0 > Driver.WIDTH) {
         setX((int) (0 - getWidth() / 2.0));
      }
   }
}
