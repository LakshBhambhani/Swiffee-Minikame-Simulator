import com.studiohartman.jamepad.*;

/**
 * A class for making Jamepad more easier
 * @author lakshbhambhani
 * @date 5/26/19
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
	
	/**
	 * Constructor for XboxControl from jamePad
	 */
	public XboxControl() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
		currController = controllers.getControllerIndex(0);
	}
	
	/**
	 * Used to get leftX Value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getLeftX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTX);
	}
	
	/**
	 * Used to get leftY value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getLeftY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTY);
	}
	
	/**
	 * Used to get right x value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getRightX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTX);
	}
	
	/**
	 * used to get right y value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getRightY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTY);
	}
	
	/**
	 * used to get left trigger value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getLeftTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERLEFT);
	}
	
	/**
	 * used to get right trigger value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public double getRightTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERRIGHT);
	}
	
	/**
	 * used to know if a is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean aPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.A);
	}
	
	/**
	 * used to know if b is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean bPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.B);
	}
	
	/**
	 * used to know if x is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean xPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.X);
	}
	
	/**
	 * used to know if why is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean yPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.Y);
	}
	
	/**
	 * used to know if left bumper is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean leftBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.LEFTBUMPER);
	}
	/**
	 * Used to know if right bumper is pressed
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public boolean rightBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.RIGHTBUMPER);
	}
	
	/**
	 * used to get dpadx value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
	public int getDpadX() throws ControllerUnpluggedException {
		if(currController.isButtonPressed(ControllerButton.DPAD_UP)) {
			return 1;
		}
		if(currController.isButtonPressed(ControllerButton.DPAD_DOWN)) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * used to get dpadY value
	 * @return
	 * @throws ControllerUnpluggedException
	 */
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
