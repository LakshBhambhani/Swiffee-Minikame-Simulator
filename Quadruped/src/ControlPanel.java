import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	public ControlPanel() {
		createFrame();
	}
	
	public void createFrame() {
		JFrame frame = new JFrame("Control Panel");
		frame.setBounds(10, 10, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
