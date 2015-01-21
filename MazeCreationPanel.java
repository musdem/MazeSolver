import java.awt.event.*;
import javax.swing.*;

public class MazeCreationPanel extends JPanel
{
	public MazeCreationPanel()
	{
		JButton wallCreate = new JButton("Wall Tile");
		JButton hallCreate = new JButton("Hall Tile");
		JButton startCreate = new JButton("Start Tile");
		JButton endCreate = new JButton("End Tile");
		wallCreate.addActionListener(new ActionListener()//this will allow the user to draw the maze wall tiles
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make wall creation
			}
		});
		hallCreate.addActionListener(new ActionListener()//this will remove any tiles and just create blank spaces in the maze
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make hall creation
			}
		});
		startCreate.addActionListener(new ActionListener()//this will place the start tile and remove any other start tiles on the map
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make start location creation
			}
		});
		endCreate.addActionListener(new ActionListener()//this will place the end tile and remove any other end tiles on the map
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make end location creation
			}
		});
		add(wallCreate);
		add(hallCreate);
		add(startCreate);
		add(endCreate);
	}
}
