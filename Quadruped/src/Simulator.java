import java.awt.Graphics;													// all the java classes imported into this program
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Simulator extends JPanel {
	
	FullBody fullBody;
	
	public Simulator() {
		fullBody = new FullBody(this);
	}

	public void paintComponent(Graphics g) {	// Called automatically when the panel needs repainting
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
	    double xRatio = width/800.0;
	    double yRatio = height/600.0;
	      
	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(xRatio,yRatio);
	    
	    setBackground(Color.WHITE);
	    
		fullBody.draw(g2);
		
	}
}