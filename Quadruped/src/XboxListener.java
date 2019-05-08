import java.io.IOException;

import javax.swing.JEditorPane;

import com.studiohartman.jamepad.ControllerUnpluggedException;

public class XboxListener{

	XboxControl controller = new XboxControl();
	JEditorPane web = new JEditorPane();
	
	String BOTIP = "http://192.168.0.28";

	public void Listen() throws ControllerUnpluggedException, IOException {
		if(controller.getRightTrigger() > 0.0) {
			System.out.println("Right Trigger is Down");
			web.setPage(BOTIP + "/moveForward");
		}
		else if(controller.getLeftTrigger() > 0.0) {
			System.out.println("Left Trigger is Down");
			web.setPage(BOTIP + "/moveBackward");
		}
		else if(controller.getLeftX() > 0.0) {
			System.out.println("Left Stick is Right");
			web.setPage(BOTIP + "/turnRight");
		}
		else if(controller.getLeftX() < 0.0) {
			System.out.println("Left Stick is Left");
			web.setPage(BOTIP + "/turnLeft");
		}
		
	}
	
	public boolean exit() throws ControllerUnpluggedException {
		if(controller.bPressed()) {
			return false;
		}
		else {
			return true;
		}
	}
}
