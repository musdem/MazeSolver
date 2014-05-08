public class Point
{
	private int x;
	private int y;
	public Point()
	{
		x = 0;
		y = 0;
	}
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void move(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	@Override
	public String toString()
	{
		return ("(" + x + "," + y +")");
	}
	@Override
	public boolean equals(Object o)
	{
		if(o == this)
		{
			return true;
		}
		if(!(o instanceof Point))
		{
			return false;
		}
		Point p = (Point) o;
		return (x == p.x && y == p.y);
	}
}
