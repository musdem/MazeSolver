import javax.swing.*;

public class Maze
{
	/* The maze[][] array is set up so the first number in the array index represents the y axis and the second is the x axis
	 * for example maze[1][3] would be point (3,1)
	 */
	private int numberOfMoves;
	private char[][] maze = new char[0][0];
	private boolean solvable = true;
	private Rat runner;
	private Point startPos;
	private Point endPos;
	private ErrorPanel EP = new ErrorPanel();
	private JFrame ErrorFrame = new JFrame();
	public Maze(String mazeFile)
	{
		ErrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ErrorFrame.add(EP);
		ErrorFrame.setSize(380,120);
		ErrorFrame.setTitle("Maze Solver : ERROR");
		fileToArray(mazeFile);
		findStartingPos();
		findEndingPos();
		if(solvable)
		{
			runner = new Rat(startPos,findStartingDirection());
		}
		else//for displaying error messages
		{
			ErrorFrame.setVisible(true);
			EP.msg1();
		}
		numberOfMoves = 0;
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
    @Override
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
	public char[][] rawOut()
	{
		return maze;
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
		if (startPos == null)//for displaying error messages
		{
			EP.msg2();
			solvable = false;
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
		if (endPos == null)//for displaying error messages
		{
			EP.msg3();
			solvable = false;
		}
	}
	private void move()
	{
		maze[runner.currentPos().getY()][runner.currentPos().getX()] = 'P';
		runner.travel();
		maze[runner.currentPos().getY()][runner.currentPos().getX()] = '@';
	}
	public void solveMethod(int method)//selects the solving algorithm
	{
		if(method == 1 && solvable)
		{
			wallRightFollow();
		}
		else if(method == 2 && solvable)
		{
			wallLeftFollow();
		}
		else//for displaying error messages
		{
			ErrorFrame.setVisible(true);
			EP.msg4();
		}
	}
	public Point returnSize()
	{
		return new Point((maze[0].length),(maze.length));
	}
	private void wallRightFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.currentPos().equals(endPos))
		{
			if(!isIllegal(runner.rightPos()))
			{
				System.out.println("turning right");
				runner.turnRight();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 2;
			}
			else if(!isIllegal(runner.nextPos()))
			{
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 1;
			}
			else if(!isIllegal(runner.leftPos()))
			{
				System.out.println("turning left");
				runner.turnLeft();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 2;
			}
			else
			{
				System.out.println("turning around");
				runner.turnAround();
				System.out.println(this);
				numberOfMoves += 1;
			}
		}
		System.out.println("maze solved, the number of moves it took to solve it is: " + numberOfMoves);
	}
	private void wallLeftFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.currentPos().equals(endPos))
		{
			if(!isIllegal(runner.leftPos()))
			{
				System.out.println("turning left");
				runner.turnLeft();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 2;
			}
			else if(!isIllegal(runner.nextPos()))
			{
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 1;
			}
			else if(!isIllegal(runner.rightPos()))
			{
				System.out.println("turning right");
				runner.turnRight();
				System.out.println(this);
				System.out.println("moving to " + runner.nextPos());
				move();
				System.out.println(this);
				numberOfMoves += 2;
			}
			else
			{
				System.out.println("turning around");
				runner.turnAround();
				System.out.println(this);
				numberOfMoves += 1;
			}
		}
		System.out.println("maze solved, the number of moves it took to solve it is: " + numberOfMoves);
	}
	private char findStartingDirection()
	{
		if(!isIllegal(new Point(startPos.getX(),startPos.getY()-1)))
		{
			return 'u';
		}
		else if(!isIllegal(new Point(startPos.getX()+1,startPos.getY())))
		{
			return 'r';
		}
		else if(!isIllegal(new Point(startPos.getX(),startPos.getY()+1)))
		{
			return 'd';
		}
		else return 'l';
	}
	private boolean isIllegal(Point p)
	{
		if(p.getY() >= maze.length || p.getY() < 0 || p.getX() >= maze[0].length || p.getX() < 0 || maze[p.getY()][p.getX()] == '#')
		{
			return true;
		}
		else return false;
	}
}
