public class Rat
{
	private Point pos;
	private char direction;
	private Maze maze;
	public Rat(Point start, Maze m)
	{
		pos = start;
		maze = m;
		direction = m.findStartingDirection();
	}
	public void turnRight(char newDir)
	{
		if(direction == 'u')
		{
			direction = 'r';
		}
		else if(direction == 'r')
		{
			direction = 'd';
		}
		else if(direction == 'd')
		{
			direction = 'l';
		}
		else if(direction == 'l')
		{
			direction = 'u';
		}
	}
	public void turnLeft(char newDir)
	{
		if(direction == 'u')
		{
			direction = 'l';
		}
		else if(direction == 'r')
		{
			direction = 'u';
		}
		else if(direction == 'd')
		{
			direction = 'r';
		}
		else if(direction == 'l')
		{
			direction = 'd';
		}
	}
	public void travel()
	{
		if(direction == 'u')
		{
			pos.move(0,-1);
		}
		else if(direction == 'r')
		{
			pos.move(1,0);
		}
		else if(direction == 'd')
		{
			pos.move(0,1);
		}
		else if(direction == 'l')
		{
			pos.move(-1,0);
		}
	}
	public Point currentPos()
	{
		return pos;
	}
	public char giveDir()
	{
		return direction;
	}
}
