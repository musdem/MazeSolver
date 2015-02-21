import java.awt.event.*;
import javax.swing.*;

public class MessagePanel extends JPanel
{
	public MessagePanel(int numberOfMoves)
	{
		JLabel numberOfMovesMessage = new JLabel("Maze solved, the number of moves it took to solve it is: " + numberOfMoves);
		add(numberOfMovesMessage);
	}
}
