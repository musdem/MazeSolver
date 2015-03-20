import javax.swing.*;

class ErrorPanel extends JPanel
{
	public ErrorPanel()
	{
		JLabel errorMessage = new JLabel("ERROR!");
		add(errorMessage);
	}
	public void msg1()//general maze errors
	{
		JLabel errorMessage1 = new JLabel("The maze has errors and runner can't be initialized.");
		add(errorMessage1);
	}
	public void msg2()//no start tile on the maze
	{
		JLabel errorMessage2 = new JLabel("There is no start tile on the maze.");
		add(errorMessage2);
	}
	public void msg3()//no end tile on the maze
	{
		JLabel errorMessage3 = new JLabel("There is no end tile on the maze.");
		add(errorMessage3);
	}
	public void msg4()//solve method is incorrect
	{
		JLabel errorMessage4 = new JLabel("Solve method is incorrect or the maze has errors and can't be solved.");
		add(errorMessage4);
	}
	public void msg5()//maze.txt isn't found
	{
		JLabel errorMessage5 = new JLabel("File IO exception: Maze.txt not found.");
		add(errorMessage5);
	}
	public void msg6()//maze not initilized
	{
		JLabel errorMessage6 = new JLabel("Null Pointer Exception: maze no initialized.");
		add(errorMessage6);
	}
}
