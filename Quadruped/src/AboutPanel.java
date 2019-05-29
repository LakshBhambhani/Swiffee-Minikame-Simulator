import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.*;

import com.studiohartman.jamepad.ControllerUnpluggedException;

/**
 * Description: The about panel to tell user what version of the simulator they are using and who built the simulator
 * @author Megan, Laksh
 * @date 5/26/19
 */
public class AboutPanel extends JPanel {

	JFrame frame;
	private BufferedImage image;

	public String release = "v1.0.3";

	/**
	 * Constructor for About panel which tells the user about the version and the developers
	 * @throws ControllerUnpluggedException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public AboutPanel() throws ControllerUnpluggedException, IOException, InterruptedException {

		ImageIcon icon = new ImageIcon("/body.png");

		// the message
		JOptionPane.showMessageDialog(null, "Version: " + release + "\nDevelopers: Megan Choy, Laksh Bhambhani :)",
				"About", JOptionPane.OK_OPTION, icon);
	}

	/**
	 * Close method when close button is pressed
	 */
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
