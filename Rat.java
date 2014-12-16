public class Rat
{
	//the "Rat" object is for traversing the maze automatically
	private Point pos;
	private char direction;
	public Rat(Point start, char startingDirection)
	{
		pos = start;
		direction = startingDirection;
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
	public void turnAround()
	{
		if(direction == 'u')
		{
			direction = 'd';
		}
		else if(direction == 'r')
		{
			direction = 'l';
		}
		else if(direction == 'd')
		{
			direction = 'u';
		}
		else if(direction == 'l')
		{
			direction = 'r';
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
		if(direction == 'u') return new Point(pos.getX(),pos.getY()-1);
		else if(direction == 'r') return new Point(pos.getX()+1,pos.getY());
		else if(direction == 'd') return new Point(pos.getX(),pos.getY()+1);
		else return new Point(pos.getX()-1,pos.getY());
	}
	public Point rightPos()
	{
		if(direction == 'u') return new Point(pos.getX()+1,pos.getY());
		else if(direction == 'r') return new Point(pos.getX(),pos.getY()+1);
		else if(direction == 'd') return new Point(pos.getX()-1,pos.getY());
		else return new Point(pos.getX(),pos.getY()-1);
	}
	public Point leftPos()
	{
		if(direction == 'u') return new Point(pos.getX()-1,pos.getY());
		else if(direction == 'r') return new Point(pos.getX(),pos.getY()-1);
		else if(direction == 'd') return new Point(pos.getX()+1,pos.getY());
		else return new Point(pos.getX(),pos.getY()+1);
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
