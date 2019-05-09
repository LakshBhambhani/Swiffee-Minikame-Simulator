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

public class AboutPanel extends JPanel {
	
	JFrame frame;
    private BufferedImage image;
	
	public String release = "v1.0.1";

	public AboutPanel() throws ControllerUnpluggedException, IOException, InterruptedException {
		
        ImageIcon icon = new ImageIcon("/body.png");

		JOptionPane.showMessageDialog(null, "Version: " + release + "\nDevelopers: Megan Choy, Laksh Bhambhani :)","About", JOptionPane.OK_OPTION, icon);
		
	}
	
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
