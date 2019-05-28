import java.awt.Graphics;													// all the java classes imported into this program
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * 
 * Panel for Simulator Window class which extends JFrame
 * @author Megan
 * @date 5/26/19
 */

public class Simulator extends JPanel {
	
	FullBody fullBody;
	
	public Simulator() {
		fullBody = new FullBody(this);
	}

	/**
	 * Called automatically when panel needs to repaint itself
	 */
	public void paintComponent(Graphics g) {
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
	
	/**
	 * redrawing the body
	 */
	public void reinitialize() {
		fullBody = null;
		fullBody = new FullBody(this);
	}
}