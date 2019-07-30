import java.awt.*;
import java.awt.image.*;

public class Slider extends Rectangle
{
   public Slider(int x, int y) {
      super(x, y, 60, 10);
   }
	
	// movement methods
	// possible addition - dx changes depending on difficulty?
   public void moveLeft() {	
      setX(getX() - 5);
      if(getX() + getWidth() / 2.0 < 0) {
         setX((int) (Driver.WIDTH - getWidth() / 2.0));
      }
   }
   public void moveRight() {
			setX(getX() + 5);
      if(getX() + getWidth() / 2.0 > Driver.WIDTH) {
         setX((int) (0 - getWidth() / 2.0));
      }
   }
}
