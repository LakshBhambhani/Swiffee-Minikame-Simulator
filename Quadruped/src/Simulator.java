import java.awt.Graphics;													// all the java classes imported into this program
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Simulator extends JPanel {
	
	public Simulator() {
	}

	public void paintComponent(Graphics g) {	// Called automatically when the panel needs repainting
		super.paintComponent(g);
	    setBackground(Color.WHITE);

		FullBody fullBody = new FullBody();
		fullBody.draw(g);
		
	}

	
}