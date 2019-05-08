import com.studiohartman.jamepad.ControllerUnpluggedException;

public class XboxListener {
	
	XboxControl controller = new XboxControl();

	public void Listen() throws ControllerUnpluggedException {
		if(controller.getRightTrigger() > 0.0) {
			System.out.println("Right Trigger is Down");
		}
		if(controller.getLeftTrigger() > 0.0) {
			System.out.println("Left Trigger is Down");
		}
		if(controller.getLeftX() > 0.0) {
			System.out.println("Left Stick is Right");
		}
		if(controller.getLeftX() < 0.0) {
			System.out.println("Left Stick is Left");
		}
	}
	
	public static void main(String[] args) throws ControllerUnpluggedException {
		XboxListener xbox = new XboxListener();
		
		while(true){
			xbox.Listen();
		}
	}
}
