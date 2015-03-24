import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze
{
	/* The maze[][] array is set up so the first number in the array index represents the y axis and the second is the x axis
	 * for example maze[1][3] would be point (3,1)
	 */
	private int numberOfMoves;
	/* 3 is the multiplire I decided on for limiting the number of moves where width*height*3 = maxMoves
	 * this is because from what I found the max moves per 4 squares is 12 so 12 moves / 4 squares = 3 moves / 1 square
	 */
	private int maxMoves = 3;
	private char[][] maze = new char[0][0];
	private boolean solvable = true;
	private boolean solved = false;
	private Rat runner;
	private Point startPos;
	private Point endPos;
	private ErrorPanel EP = new ErrorPanel();
	private JFrame ErrorFrame = new JFrame();
	public Maze(String mazeFile)
	{
		ErrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ErrorFrame.add(EP);
		ErrorFrame.setSize(390,120);
		ErrorFrame.setTitle("Maze Solver : ERROR");
		fileToArray(mazeFile);
		findStartingPos();
		findEndingPos();
		maxMoves *= maze.length * maze[0].length;//this is assuming mazes will be rectangular in shape
		try
		{
			runner = new Rat(startPos,findStartingDirection());
		}
		catch(NullPointerException e)
		{
			ErrorFrame.setVisible(true);
			EP.msg1();
		}
		numberOfMoves = 0;
	}
	private void fileToArray(String file)//this reads the maze file and then changes it to type char[][]
	{
		boolean first = true;
		String fileOutput = "";
		File mazeFile = new File(file);
		try
		{
			Scanner sc = new Scanner(mazeFile);
			while(sc.hasNextLine())
			{
				fileOutput += sc.nextLine();
				fileOutput += "\n";
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			EP.msg5();
		}
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
		maze[runner.currentPos().getY()][runner.currentPos().getX()] = runner.getDir();//the arrows are place holders for testing it represents where the 'Rat' has gone in the maze
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
	public Point getSize()
	{
		return new Point((maze[0].length),(maze.length));
	}
	public int getNumberOfMoves()
	{
		return numberOfMoves;
	}
	public boolean isSolved()
	{
		return solved;
	}
	private void wallRightFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.currentPos().equals(endPos) && solvable)
		{
			if(!isIllegal(runner.rightPos()))
			{
				runner.turnRight();
				move();
				numberOfMoves += 2;
			}
			else if(!isIllegal(runner.nextPos()))
			{
				move();
				numberOfMoves += 1;
			}
			else if(!isIllegal(runner.leftPos()))
			{
				runner.turnLeft();
				move();
				numberOfMoves += 2;
			}
			else
			{
				runner.turnAround();
				numberOfMoves += 1;
			}
			if(numberOfMoves == maxMoves) solvable = false;
		}
		if(solvable) solved = true;
	}
	private void wallLeftFollow()//work in progress it will change once I add the GUI
	{
		while(!runner.currentPos().equals(endPos) && solvable)
		{
			if(!isIllegal(runner.leftPos()))
			{
				runner.turnLeft();
				move();
				numberOfMoves += 2;
			}
			else if(!isIllegal(runner.nextPos()))
			{
				move();
				numberOfMoves += 1;
			}
			else if(!isIllegal(runner.rightPos()))
			{
				runner.turnRight();
				move();
				numberOfMoves += 2;
			}
			else
			{
				runner.turnAround();
				numberOfMoves += 1;
			}
			if(numberOfMoves == maxMoves) solvable = false;
		}
		if(solvable) solved = true;
	}
	/* findStartingDirection will systematically check for a free space around the starting point
	 * in order to have a possible starting direction
	 */
	private char findStartingDirection()
	{
		if(!isIllegal(new Point(startPos.getX(),startPos.getY()-1))) return 'u';
		else if(!isIllegal(new Point(startPos.getX()+1,startPos.getY()))) return 'r';
		else if(!isIllegal(new Point(startPos.getX(),startPos.getY()+1))) return 'd';
		else return 'l';
	}
	private boolean isIllegal(Point p)
	{
		return (p.getY() >= maze.length || p.getY() < 0 || p.getX() >= maze[0].length || p.getX() < 0 || maze[p.getY()][p.getX()] == '#');
	}
}
