import java.awt.Graphics;													// all the java classes imported into this program
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Simulator extends JPanel{
	
	public void paintComponent(Graphics g)									// Called automatically when the panel needs repainting
  	{
    super.paintComponent(g);
  	}

	public static void main(String[] args)
		{
			JFrame window = new JFrame("Walker Test");						// creates a window called feet
			window.setBounds(100, 100, 500, 480);							// sets the bound to the values specified
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// exits program when window is closed
			Simulator panel = new Simulator();
			panel.setBackground(Color.WHITE);								// sets background colour to white
			Container c = window.getContentPane();
			c.add(panel);
			window.setVisible(true);										// makes the window visible
		}
}
