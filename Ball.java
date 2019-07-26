public class Ball
{
	private int myX, myY, mydx = 0, mydy = 0;	
	public Ball(int x, int y)
	{
		myX = x;
		myY = y;
	}
	
	// instance methods
	public void draw(Graphics g)
	{
		
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
