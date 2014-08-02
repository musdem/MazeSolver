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
	public void paint(Graphics mazeG)
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
				else
				{
					mazeG.setColor(Color.WHITE);
				}
				mazeG.fillRect(j * sqaureWidth,i * squareHeight,sqaureWidth,squareHeight);
			}
		}
	}
}
