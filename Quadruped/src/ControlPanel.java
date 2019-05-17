import java.awt.*;
import javax.swing.*;

import com.studiohartman.jamepad.ControllerUnpluggedException;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/* 
 * Description: The panel to show the buttons of the xbox controller
 * @author Megan (Laksh doesn't know how graphics work) and Laksh
 */
public class ControlPanel extends JPanel {

	private Image controller = new ImageIcon("XboxMap.jpg").getImage();

	public static int width;
	public static int height;

	public ControlPanel() {
		super();
		super.setVisible(true);
		super.setSize(803, 634);
	}

	//paints and repaints the xbox map image over and over again
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		width = getWidth();
		height = getHeight();

		double ratioX = width / 800.0;
		double ratioY = height / 600.0;

		Graphics2D g2 = (Graphics2D) g;
		g2.scale(ratioX, ratioY);

		g.drawImage(controller, 0, 0, 803, 604, this);

	}

	public void repaint(Graphics g) {
		g.drawImage(controller, 0, 0, 803, 604, this);
	}

}