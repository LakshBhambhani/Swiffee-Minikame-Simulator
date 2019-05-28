import java.io.IOException;

import javax.swing.JFrame;

import com.studiohartman.jamepad.ControllerUnpluggedException;

/**
 * Contains the main Frame that uses the Control Panel. This is a runnable object which means that a thread can be made from it
 * @author Laksh
 * @date 5/26/19
 */
public class ControlPanelJframe extends JFrame implements Runnable {
	static JFrame frame;

	/**
	 * Used to draw a frame for the control panel
	 */
	public static void drawFrame() {

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
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				XboxListener xbox = new XboxListener();
				try {
					while(xbox.exit()){
						panel.repaint();
						xbox.Listen();
					}
					frame.dispose();
				}
				catch(ControllerUnpluggedException | IOException | InterruptedException e1) {
					System.out.println("Controller not connected");
				}
			}
		});
		t1.start();
		t1.yield();

	}

	/**
	 * Close method for window JFrame
	 */
	public static void close() {
		frame.setVisible(false);
		frame.dispose();
	}

	@Override
	/**
	 * Run method that uses drawFrame(); to draw a frame
	 */
	public void run() {
		drawFrame();
		System.out.println("JFrame thread is runnning");
	}
}
