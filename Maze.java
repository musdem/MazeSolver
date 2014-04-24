public class Maze
{
	/* The maze[][] array is set up so the first number in the array index represents the y axis and the second is the x axis
	 * for example maze[1][3] would be point (3,1)
	 */
	private char[][] maze = new char[0][0];
	private Point pos;
	private Point endPos;
	public Maze(String mazeFile)
	{
		fileToArray(mazeFile);
		findStartingPos();
		findEndingPos();
	}
	public void fileToArray(String file)//this reads the maze file and then changes it to type char[][]
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
					pos = new Point(j,i);
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
	public Point currentPos()//test method
	{
		return pos;
	}
	public Point endingPos()//test method
	{
		return endPos;
	}
	public void movePoint(int x, int y)//test method
	{
		maze[pos.getY()][pos.getX()] = '.';
		pos.move(x,y);
		maze[pos.getY()][pos.getX()] = '@';
	}
}
