import javax.swing.JFrame;

public class ControlPanelJframe extends JFrame{
	 static JFrame frame;
	 
	 public static void drawFrame() {

		 	ControlPanel panel = new ControlPanel();
		    frame = new JFrame("Square Move Practice");
		    frame.setVisible(true);
		    frame.setResizable(false);
		    frame.setSize(803, 634);
		    int width = frame.getWidth();
		    int height = frame.getHeight();
		    System.out.println(width);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().add(panel);
		    
		}
	 
	 public static void close() {
			frame.setVisible(false);
			frame.dispose();
		}
}
