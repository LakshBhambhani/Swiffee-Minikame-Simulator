import java.io.IOException;

import com.studiohartman.jamepad.ControllerUnpluggedException;

public class Xbox implements Runnable{

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
	public void run() {
		new Xbox();
		System.out.println("Xbox thread is running");
	}
}
