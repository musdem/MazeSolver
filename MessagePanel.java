import javax.swing.*;

public class MessagePanel extends JPanel
{
	public MessagePanel()
	{
		JLabel finishedMessage = new JLabel("Finished running.");
		add(finishedMessage);
	}
	public void msg1(int numberOfMoves)
	{
		JLabel successMessage = new JLabel("Maze solved, the number of moves it took to solve it is: " + numberOfMoves);
		add(successMessage);
	}
	public void msg2(int numberOfMoves)
	{
		JLabel failMessage = new JLabel("Maze is unsolvable, the number of moves taken is: " + numberOfMoves);
		add(failMessage);
	}
}
