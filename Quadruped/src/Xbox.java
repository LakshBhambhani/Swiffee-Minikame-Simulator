import java.io.IOException;

import com.studiohartman.jamepad.ControllerUnpluggedException;

/**
 * 
 * another runnable class for multithreading. Uses and starts xbox listener
 * @author lakshbhambhani
 * @date 5/26/19
 *
 */
public class Xbox implements Runnable{

	/**
	 * Constructor to listen to xbox until user click exit
	 */
	public Xbox() {
		 XboxListener xbox = new XboxListener();
		
			try {
				while(xbox.exit()){
					xbox.Listen();
				}
			}
			catch(ControllerUnpluggedException | IOException | InterruptedException e1) {
				System.out.println("Controller not connected");
			}
			
			//ControlPanelJframe.close();
	}

	@Override
	/**
	 * Run method as it's a runnable class
	 */
	public void run() {
		new Xbox();
		System.out.println("Xbox thread is running");
	}
}
