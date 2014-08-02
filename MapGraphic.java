import java.awt.*;
import javax.swing.*;
public class MapGraphic extends JPanel
{
	public MapGraphic()                       // set up graphics window
    {
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly
		g.setColor(Color.BLUE);				// sets the new draw color
		g.fillRect(50,50,50,50);		// draws a rectangle that is full of the current draw color
    }

    public static void main(String[] args)
    {
        MapGraphic panel = new MapGraphic();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
                                                                      // when it is closed
        application.add(panel);           


        application.setSize(500, 500);         // window is 500 pixels wide, 400 high
        application.setVisible(true);          
    }
}
