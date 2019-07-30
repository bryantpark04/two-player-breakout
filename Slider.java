import java.awt.*;
import java.awt.image.*;

public class Slider extends Rectangle
{
	//private int myX, myY, myWidth = 60, myHeight = 10;
	public Slider(int x, int y) {
		super(x, y, 60, 10);
	}
	
	// movement methods
	// possible addition - dx changes depending on difficulty?
	public void moveLeft() {
		//myX -= 5;
		//if(myX + myWidth / 2.0 < 0) {
			//myX = (int) (Driver.WIDTH - myWidth / 2.0);
		//}
		
		setX(getX() - 5);
		if(getX() + getWidth() / 2.0 < 0) {
			setX((int) (Driver.WIDTH - getWidth() / 2.0));
		}
	}
	public void moveRight() {
		//myX += 5;
		//if(myX + myWidth / 2.0 > Driver.WIDTH) {
			//myX = (int) (0 - myWidth / 2.0);
		//}
		
		setX(getX() + 5);
		if(getX() + getWidth() / 2.0 > Driver.WIDTH) {
			setX((int) (0 - getWidth() / 2.0));
		}
	}
}
