import java.awt.*;
import javax.swing.*;
public class MazeGraphicPanel extends JPanel
{
	private Point mazeSize;
	private Maze m;
	private char[][] maze;
	public MazeGraphicPanel(Maze m)
	{
		this.m = m;
		this.mazeSize = m.returnSize();
		this.maze = m.rawOut();
	}
	public void solve(boolean slv)//this is a testing method for showing a very basic solved maze
	{
		if(slv == true)
		{
			m.solveMethod(1);
		}
	}
	public void paint(Graphics mazeG)//primitave java graphics I will probably change this around to use the 2D libraries
	{
		int height = getHeight();
		int width = getWidth();
		int squareHeight = height / mazeSize.getY();
		int sqaureWidth = width / mazeSize.getX();
		super.paint(mazeG);
		for(int i = 0;i < maze.length;i++)
		{
			for(int j = 0;j < maze[0].length;j++)
			{
				if(maze[i][j] == '#')
				{
					mazeG.setColor(Color.BLUE);
				}
				else if(maze[i][j] == '.')
				{
					mazeG.setColor(Color.WHITE);
				}
				else if(maze[i][j] == 'S')
				{
					mazeG.setColor(Color.GREEN);
				}
				else if(maze[i][j] == 'E')
				{
					mazeG.setColor(Color.RED);
				}
				else if(maze[i][j] == '@')
				{
					mazeG.setColor(Color.BLACK);
				}
				else if(maze[i][j] == 'P')
				{
					mazeG.setColor(Color.YELLOW);
				}
				else
				{
					mazeG.setColor(Color.WHITE);
				}
				mazeG.fillRect(j * sqaureWidth,i * squareHeight,sqaureWidth,squareHeight);
			}
		}
	}
}
