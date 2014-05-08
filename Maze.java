public class Maze
{
	/* The maze[][] array is set up so the first number in the array index represents the y axis and the second is the x axis
	 * for example maze[1][3] would be point (3,1)
	 */
	private char[][] maze = new char[0][0];
	private Rat runner;
	private Point startPos;
	private Point endPos;
	public Maze(String mazeFile)
	{
		fileToArray(mazeFile);
		findStartingPos();
		findEndingPos();
		runner = new Rat(startPos, this);
	}
	private void fileToArray(String file)//this reads the maze file and then changes it to type char[][]
	{
		boolean first = true;
		String fileOutput = TextFileOps.Read(file);
		String[] rows = fileOutput.split("\\n");
		for(int i=0;i<rows.length;i++)
		{
			char [] columns = rows[i].toCharArray();
			for(int j=0;j<columns.length;j++)
			{
				if(first==true)
				{
					maze = arraySizeIncreaser(maze,rows.length,columns.length);
					first = false;
				}
				maze[i][j] = columns[j];
			}
		}
	}
	private static char[][] arraySizeIncreaser(char[][] array, int newArrayX, int newArrayY)//increases an arrays index size
	{
		char [][] ret = new char[newArrayX][newArrayY];   
        for (int x=0;x<array.length;x++)
        {
			for (int y=0;y<array[0].length;y++)
			{
				ret[x][y] = array[x][y];
			}
		}
		return ret;
    }
	public String toString()
	{
		String out = "";
		for(int i = 0;i < maze.length;i++)
		{
			for(int j = 0;j < maze[0].length;j++)
			{
				out += maze[i][j];
			}
			out += "\n";
		}
		return out;
	}
	private void findStartingPos()
	{
		for(int i = 0;i < maze.length;i++)
		{
			for(int j = 0;j < maze[0].length;j++)
			{
				if(maze[i][j] == 'S')
				{
					startPos = new Point(j,i);
					i = maze.length;
					j = maze[0].length;
				}
			}
		}
	}
	private void findEndingPos()
	{
		for(int i = 0;i < maze.length;i++)
		{
			for(int j = 0;j < maze[0].length;j++)
			{
				if(maze[i][j] == 'E')
				{
					endPos = new Point(j,i);
					i = maze.length;
					j = maze[0].length;
				}
			}
		}
	}
	private void move()
	{
		maze[runner.currentPos().getY()][runner.currentPos().getX()] = '.';
		runner.travel();
		maze[runner.currentPos().getY()][runner.currentPos().getX()] = '@';
	}
	public void solveMethod(int method)//selects the solving algorithm
	{
		if(method == 1)
		{
			wallRightFollow();
		}
		if(method == 2)
		{
			wallLeftFollow();
		}
	}
	private void wallRightFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.nextPos().equals(endPos))
		{
			if(!isIllegal(runner.rightPos()))
			{
				System.out.println("turning right");
				runner.turnRight();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else if(!isIllegal(runner.nextPos()))
			{
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else if(!isIllegal(runner.leftPos()))
			{
				System.out.println("turning left");
				runner.turnLeft();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else
			{
				System.out.println("turning around");
				runner.turnRight();
				runner.turnRight();
				System.out.println(this);
			}
		}
		System.out.println("moving to " + runner.nextPos());
		move();
		System.out.println(this);
		System.out.println("maze solved");
	}
	private void wallLeftFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.nextPos().equals(endPos))
		{
			if(!isIllegal(runner.leftPos()))
			{
				System.out.println("turning left");
				runner.turnLeft();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else if(!isIllegal(runner.nextPos()))
			{
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else if(!isIllegal(runner.rightPos()))
			{
				System.out.println("turning right");
				runner.turnRight();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
			}
			else
			{
				System.out.println("turning around");
				runner.turnRight();
				runner.turnRight();
				System.out.println(this);
			}
		}
		System.out.println("moving to " + runner.nextPos());
		move();
		System.out.println(this);
		System.out.println("maze solved");
	}
	public char findStartingDirection()
	{
		char out = 's';
		if(!isIllegal(new Point(startPos.getX(),startPos.getY()-1)))
		{
			out = 'u';
		}
		else if(!isIllegal(new Point(startPos.getX()+1,startPos.getY())))
		{
			out = 'r';
		}
		else if(!isIllegal(new Point(startPos.getX(),startPos.getY()+1)))
		{
			out = 'd';
		}
		else if(!isIllegal(new Point(startPos.getX()-1,startPos.getY())))
		{
			out = 'l';
		}
		return out;
	}
	private boolean isIllegal(Point p)
	{
		boolean out = false;
		if(p.getY() >= maze.length || p.getY() < 0 || p.getX() >= maze[0].length || p.getX() < 0 || maze[p.getY()][p.getX()] == '#')
		{
			out = true;
		}
		return out;
	}
}
