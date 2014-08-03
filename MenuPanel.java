import java.awt.event.*;
import javax.swing.*;
public class MenuPanel extends JPanel
{
	MazeGraphicPanel MGP = new MazeGraphicPanel(new Maze("maze.txt"));
	MazeCreationPanel MCP = new MazeCreationPanel();
	JFrame MazeWindow = new JFrame();
	JFrame MazeCreatorWindow = new JFrame();
	public MenuPanel()
	{
		JButton newMap = new JButton("Create a Map");
		JButton loadMap = new JButton("Load a Map");
		newMap.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MazeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MazeWindow.add(MGP);
				MazeCreatorWindow.add(MCP);
				MazeWindow.setSize(600,600);
				MazeCreatorWindow.setSize(240,100);
				MazeWindow.setTitle("Maze Solver : Maze");
				MazeCreatorWindow.setTitle("Maze Solver : Maze Creation Tools");
				MazeWindow.setVisible(true);
				MazeCreatorWindow.setVisible(true);
			}
		});
		loadMap.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make a loadMapPanel
			}
		});
		add(newMap);
		add(loadMap);
	}
}
