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
		wallCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make wall creation
			}
		});
		hallCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make hall creation
			}
		});
		startCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//will make start location creation
			}
		});
		endCreate.addActionListener(new ActionListener()
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
