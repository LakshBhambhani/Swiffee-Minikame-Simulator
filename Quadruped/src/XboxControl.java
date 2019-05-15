import com.studiohartman.jamepad.*;

/*
 * A class for making Jamepad more easier
 */
public class XboxControl {
	
	public static ControllerManager controllers;
	public static ControllerIndex currController;

//	public static void main(String[] args) throws ControllerUnpluggedException {
//		//Print a message when the "A" button is pressed. Exit if the "B" button is pressed 
//		//or the controller disconnects.
//		
//
//		while(true) {
//		  controllers.update(); //If using ControllerIndex, you should call update() to check if a new controller
//		                        //was plugged in or unplugged at this index.
//		}
//	}
	
	public XboxControl() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
		currController = controllers.getControllerIndex(0);
	}
	
	public double getLeftX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTX);
	}
	
	public double getLeftY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTY);
	}
	
	public double getRightX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTX);
	}
	
	public double getRightY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTY);
	}
	
	public double getLeftTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERLEFT);
	}
	
	public double getRightTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERRIGHT);
	}
	
	public boolean aPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.A);
	}
	
	public boolean bPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.B);
	}
	
	public boolean xPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.X);
	}
	
	public boolean yPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.Y);
	}
	
	public boolean leftBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.LEFTBUMPER);
	}
	
	public boolean rightBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.RIGHTBUMPER);
	}
	
	public int getDpadX() throws ControllerUnpluggedException {
		if(currController.isButtonPressed(ControllerButton.DPAD_UP)) {
			return 1;
		}
		if(currController.isButtonPressed(ControllerButton.DPAD_DOWN)) {
			return -1;
		}
		return 0;
	}
	
	public int getDpadY() throws ControllerUnpluggedException {
		if(currController.isButtonPressed(ControllerButton.DPAD_RIGHT)) {
			return 1;
		}
		if(currController.isButtonPressed(ControllerButton.DPAD_LEFT)) {
			return -1;
		}
		return 0;
	}
	
}
