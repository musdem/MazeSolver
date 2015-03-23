import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel
{
	private MazeGraphicPanel MGP = new MazeGraphicPanel();
	private MazeCreationPanel MCP = new MazeCreationPanel();
	private ErrorPanel EP = new ErrorPanel();
	private JFrame MazeWindow = new JFrame();
	private JFrame MazeCreatorWindow = new JFrame();
	private JFrame ErrorFrame = new JFrame();
	public MenuPanel()
	{
		JButton newMap = new JButton("Create a Map");
		JButton loadMap = new JButton("Load a Map");
		ErrorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ErrorFrame.add(EP);
		ErrorFrame.setSize(390,120);
		ErrorFrame.setTitle("Maze Solver : ERROR");
		newMap.addActionListener(new ActionListener()//this will open 2 windows that will allow a user to create a maze that the program will solve
		{
			public void actionPerformed(ActionEvent e)
			{
				MGP.createMaze(new Maze("maze.txt"));
				MazeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MazeWindow.add(MGP);
				MazeCreatorWindow.add(MCP);
				MazeWindow.setSize(600,600);
				MazeCreatorWindow.setSize(380,78);
				MazeWindow.setTitle("Maze Solver : Maze");
				MazeCreatorWindow.setTitle("Maze Solver : Maze Creation Tools");
				MazeWindow.setVisible(true);
				MazeCreatorWindow.setVisible(true);
			}
		});
		loadMap.addActionListener(new ActionListener()//this will allow a user to open a maze they or someone else has created
		{
			public void actionPerformed(ActionEvent e)//this code is a place holder for what will be here in the future
			{
				try
				{
					MGP.solve();
					MazeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					MazeWindow.add(MGP);
					MazeWindow.setSize(600,600);
					MazeWindow.setTitle("Maze Solver : Maze");
					MazeWindow.setVisible(true);
				}
				catch(NullPointerException error)
				{
					ErrorFrame.setVisible(true);
					EP.msg6();
				}
			}
		});
		add(newMap);
		add(loadMap);
	}
}
