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
	public void turnRight()
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
	public void turnLeft()
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
	public Point nextPos()
	{
		Point out = new Point();
		if(direction == 'u')
		{
			out = new Point(pos.getX(),pos.getY()-1);
		}
		else if(direction == 'r')
		{
			out = new Point(pos.getX()+1,pos.getY());
		}
		else if(direction == 'd')
		{
			out = new Point(pos.getX(),pos.getY()+1);
		}
		else if(direction == 'l')
		{
			out = new Point(pos.getX()-1,pos.getY());
		}
		return out;
	}
	public Point rightPos()
	{
		Point out = new Point();
		if(direction == 'u')
		{
			out = new Point(pos.getX()+1,pos.getY());
		}
		else if(direction == 'r')
		{
			out = new Point(pos.getX(),pos.getY()+1);
		}
		else if(direction == 'd')
		{
			out = new Point(pos.getX()-1,pos.getY());
		}
		else if(direction == 'l')
		{
			out = new Point(pos.getX(),pos.getY()-1);
		}
		return out;
	}
	public Point leftPos()
	{
		Point out = new Point();
		if(direction == 'u')
		{
			out = new Point(pos.getX()-1,pos.getY());
		}
		else if(direction == 'r')
		{
			out = new Point(pos.getX(),pos.getY()-1);
		}
		else if(direction == 'd')
		{
			out = new Point(pos.getX()+1,pos.getY());
		}
		else if(direction == 'l')
		{
			out = new Point(pos.getX(),pos.getY()+1);
		}
		return out;
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
