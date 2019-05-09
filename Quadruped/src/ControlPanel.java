import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.studiohartman.jamepad.ControllerUnpluggedException;

public class ControlPanel extends JPanel {
	
	JFrame frame;

	public ControlPanel() throws ControllerUnpluggedException, IOException, InterruptedException {
		createFrame();
		
		XboxListener xbox = new XboxListener();
		
		while(xbox.exit()){
			xbox.Listen();
		}
		
		close();
	}
	
	public void createFrame() {
		frame = new JFrame("Control Panel");
		frame.setBounds(10, 10, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
