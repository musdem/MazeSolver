import java.awt.event.*;
import javax.swing.*;

public class MazeControlPanel extends JPanel
{
	public MazeControlPanel()
	{
		JButton save = new JButton("Save");
		JButton solve = new JButton("Solve");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//TODO make savePanel
			}
		});
		solve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//TODO make solvePanel
			}
		});
		add(save);
		add(solve);
	}
}
