public class Ball
{
	private int myX, myY, mydx = 0, mydy = 0, myDiameter = 15;		// private fields
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
			dx *= -1;
		}
		if(myY < 0 || myY > Driver.HEIGHT - myDiameter)
		{
			dy *= -1;
		}
		
		myX += dx;
		myY += dy;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(myX, myY, myDiameter, myDiameter);
	}
	
	// getters
	public int getX()
	{
		return myX;
	}
	public int getY()
	{
		return myY;
	}
	public int getdx()
	{
		return mydx;
	}
	public int getdy()
	{
		return mydy;
	}
	
	// setters
	public void setX(int x)
	{
		myX = x;
	}
	public void setY(int y)
	{
		myY = y;
	}
	public void setdx(int dx)
	{
		mydx = dx;
	}
	public void setdy(int dy)
	{
		mydy = dy;
	}
}
