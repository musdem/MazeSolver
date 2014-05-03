public class Point
{
	private int x;
	private int y;
	public Point(int sX, int sY)
	{
		x = sX;
		y = sY;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void move(int iX, int iY)
	{
		x += iX;
		y += iY;
	}
	public String toString()
	{
		return ("(" + x + "," + y +")");
	}
}
