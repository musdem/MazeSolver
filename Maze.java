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
	/* 3 is the multiplier I decided on for limiting the number of moves where width*height*3 = maxMoves
	 * this is because from what I found the max moves per 4 squares is 12 so 12 moves / 4 squares = 3 moves / 1 square
	 */
	private int maxMoves = 3;
	private char[][] maze;
	private boolean solvable = true;
	private boolean solved = false;
	private String mazeFileName = "";
	private Rat runner;
	private Point startPos;
	private Point endPos;
	private ErrorPanel EP = new ErrorPanel();
	private JFrame ErrorFrame = new JFrame();
	public Maze()//needs to change for maze editing later
	{
		ErrorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ErrorFrame.add(EP);
		ErrorFrame.setSize(390,120);
		ErrorFrame.setTitle("Maze Solver : ERROR");
	}
	public Maze(String mazeFileName)
	{
		this.mazeFileName = mazeFileName;
		ErrorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ErrorFrame.add(EP);
		ErrorFrame.setSize(390,120);
		ErrorFrame.setTitle("Maze Solver : ERROR");
		try
		{
			fileToArray();
			findStartingPos();
			findEndingPos();
			runner = new Rat(startPos,findStartingDirection());
		}
		catch(NullPointerException e)
		{
			ErrorFrame.setVisible(true);
			EP.msg1();
		}
		maxMoves *= maze.length * maze[0].length;//this is assuming mazes will be rectangular in shape
		numberOfMoves = 0;
	}
	public void initMaze()
	{
		try
		{
			fileToArray();
			findStartingPos();
			findEndingPos();
			runner = new Rat(startPos,findStartingDirection());
		}
		catch(NullPointerException e)
		{
			ErrorFrame.setVisible(true);
			EP.msg1();
		}
		maxMoves *= maze.length * maze[0].length;//this is assuming mazes will be rectangular in shape
		numberOfMoves = 0;
	}
	private void fileToArray()//this reads the maze file and then changes it to type char[][]
	{
		boolean first = true;
		String fileOutput = "";
		File mazeFile = new File(mazeFileName);
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
					maze = new char[rows.length][columns.length];
					first = false;
				}
				maze[i][j] = columns[j];
			}
		}
	}
	private void arrayToFile()//TODO make it write to file
	{
		String fileInput = "";
		for(int i = 0;i<maze.length;i++)
		{
			for(int j = 0;j<maze[i].length;j++)
			{
				fileInput += maze[i][j];
			}
			fileInput += "\n";
		}
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
	private void findStartingPos()
	{
		for(int i = 0;i < maze.length;i++)
		{
			for(int j = 0;j < maze[0].length;j++)
			{
				if(maze[i][j] == 'S')
				{
					startPos = new Point(j,i);
					break;
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
					break;
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
	public char[][] rawOut()
	{
		return maze;
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
	public void setMazeFile(String mazeFileName)
	{
		this.mazeFileName = mazeFileName;
	}
	public void saveMaze(char[][] maze)
	{
		this.maze = maze;
		arrayToFile();
	}
	public void clearMaze(Point size)
	{
		maze = new char[size.getY()][size.getX()];
		for(int i = 0;i<size.getY();i++)
		{
			for(int j = 0;j<size.getX();j++)
			{
				maze[i][j] = '#';
			}
		}
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
		solved = solvable;
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
		solved = solvable;
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
