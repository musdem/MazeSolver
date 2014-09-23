import javax.swing.*;
public class MazeSolver
{
	public static void main(String args[])
	{
		MenuPanel panel = new MenuPanel();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(280,72);
        application.setTitle("Maze Solver : Menu");
        application.setVisible(true);
	}
}
