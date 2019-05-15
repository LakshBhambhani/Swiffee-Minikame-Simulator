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

/*
 * Description: The about panel to tell user what version of the simulator are they using and who built the simulator which is of
 * course Megan and Me(Ha ha, find out who i am)
 */
public class AboutPanel extends JPanel {
	
	JFrame frame;
    private BufferedImage image;
	
	public String release = "v1.0.1";

	public AboutPanel() throws ControllerUnpluggedException, IOException, InterruptedException { // all exceptions that it faces
		
        ImageIcon icon = new ImageIcon("/body.png");

		JOptionPane.showMessageDialog(null, "Version: " + release + "\nDevelopers: Megan Choy, Laksh Bhambhani :)","About", JOptionPane.OK_OPTION, icon);
		// the message
	}
	 
	public void close() { // close method. done when window is closed
		frame.setVisible(false);
		frame.dispose();
	}

}
