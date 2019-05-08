import com.studiohartman.jamepad.ControllerUnpluggedException;

public class XboxListener{

	XboxControl controller = new XboxControl();

	public void Listen() throws ControllerUnpluggedException {
		if(controller.getRightTrigger() > 0.0) {
			System.out.println("Right Trigger is Down");
		}
		else if(controller.getLeftTrigger() > 0.0) {
			System.out.println("Left Trigger is Down");
		}
		else if(controller.getLeftX() > 0.0) {
			System.out.println("Left Stick is Right");
		}
		else if(controller.getLeftX() < 0.0) {
			System.out.println("Left Stick is Left");
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
