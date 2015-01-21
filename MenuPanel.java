import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel
{
	private MazeGraphicPanel MGP = new MazeGraphicPanel(new Maze("maze.txt"));
	private MazeCreationPanel MCP = new MazeCreationPanel();
	private JFrame MazeWindow = new JFrame();
	private JFrame MazeCreatorWindow = new JFrame();
	public MenuPanel()
	{
		JButton newMap = new JButton("Create a Map");
		JButton loadMap = new JButton("Load a Map");
		newMap.addActionListener(new ActionListener()//this will open 2 windows that will allow a user to create a maze that the program will solve
		{
			public void actionPerformed(ActionEvent e)
			{
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
				MGP.solve(true);
				MazeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MazeWindow.add(MGP);
				MazeWindow.setSize(600,600);
				MazeWindow.setTitle("Maze Solver : Maze");
				MazeWindow.setVisible(true);
			}
		});
		add(newMap);
		add(loadMap);
	}
}
