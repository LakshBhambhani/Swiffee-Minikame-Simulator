import javax.swing.JFrame;

import com.studiohartman.jamepad.ControllerUnpluggedException;

/*
 * COntains the main Frame that uses the COntrol Panel. This is a runnable object which means that a thread can be made from it
 */
public class ControlPanelJframe extends JFrame implements Runnable{
	 static JFrame frame;
	 
	 public static void drawFrame(){
		 
		 	ControlPanel panel = new ControlPanel();
		    frame = new JFrame("Control Panel for Arm");
		    frame.setVisible(true);
		    frame.setResizable(false);
		    frame.setSize(803, 634);
		    int width = frame.getWidth();
		    int height = frame.getHeight();
		    System.out.println(width);
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.getContentPane().add(panel);
		    
		}
	 
	 public static void close() {
			frame.setVisible(false);
			frame.dispose();
		}

	@Override
	public void run() {
		drawFrame();
		System.out.println("JFrame thread is runnning");
	}
}
