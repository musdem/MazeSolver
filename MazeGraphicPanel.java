import java.awt.*;
import javax.swing.*;

public class MazeGraphicPanel extends JPanel
{
	private Point mazeSize;
	private Maze m;
	private char[][] maze;
	private MessagePanel MP;
	private JFrame MessageFrame = new JFrame();
	public MazeGraphicPanel()
	{
		MessageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MessageFrame.setSize(460,60);
		MessageFrame.setTitle("Maze Solver : SOLVED");
	}
	public void createMaze(Maze m)
	{
		this.m = m;
		this.mazeSize = m.getSize();
		this.maze = m.rawOut();
	}
	public void solve(boolean slv)//this is a testing method for showing a very basic solved maze
	{
		m.solveMethod(1);
		if(slv && m.isSolvable())
		{
			MP = new MessagePanel(m.getNumberOfMoves());
			MessageFrame.add(MP);
			MessageFrame.setVisible(true);
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
				if(maze[i][j] == 'l' || maze[i][j] == 'r' || maze[i][j] == 'd' || maze[i][j] == 'u')
				{
					mazeG.setColor(Color.WHITE);
					mazeG.fillRect(j * sqaureWidth,i * squareHeight,sqaureWidth,squareHeight);
					mazeG.setColor(Color.BLACK);
					if(maze[i][j] == 'l')
					{
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth * 4 / 5,i * squareHeight + squareHeight / 2);//arrow body
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 4);//top
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 3 / 4);//bottom
					}
					else if(maze[i][j] == 'r')
					{
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth * 4 / 5,i * squareHeight + squareHeight / 2);//arrow body
						mazeG.drawLine(j * sqaureWidth + sqaureWidth * 4 / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 4);//top
						mazeG.drawLine(j * sqaureWidth + sqaureWidth * 4 / 5,i * squareHeight + squareHeight / 2,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 3 / 4);//bottom
					}
					else if(maze[i][j] == 'd')
					{
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 5,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 4 / 5);//arrow body
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 4 / 5,j * sqaureWidth + sqaureWidth / 4,i * squareHeight + squareHeight / 2);//left
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 4 / 5,j * sqaureWidth + sqaureWidth * 3 / 4,i * squareHeight + squareHeight / 2);//right
					}
					else
					{
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 5,j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight * 4 / 5);//arrow body
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 5,j * sqaureWidth + sqaureWidth / 4,i * squareHeight + squareHeight / 2);//left
						mazeG.drawLine(j * sqaureWidth + sqaureWidth / 2,i * squareHeight + squareHeight / 5,j * sqaureWidth + sqaureWidth * 3 / 4,i * squareHeight + squareHeight / 2);//right
					}
				}
				else
				{
					if(maze[i][j] == '#')
					{
						mazeG.setColor(Color.BLUE);
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
}
