import java.io.IOException;
import javax.swing.JEditorPane;
import java.util.concurrent.TimeUnit;
import com.studiohartman.jamepad.ControllerUnpluggedException;

/*
 * Transmits data to server over JEditorPane after inputs from xbox
 */
public class XboxListener{

	XboxControl controller = new XboxControl();
	JEditorPane web = new JEditorPane();
	private CoordinateSystem coordinates;
	
	String BOTIP = "http://172.20.10.3";
	
	int i = 0;

	public void Listen() throws ControllerUnpluggedException, IOException, InterruptedException {
			if(controller.rightBumperPressed()) {
			System.out.println("Right Bumper Pressed");
			web.setPage(BOTIP + "/homePos");
			TimeUnit.MILLISECONDS.sleep(1200);
			}
			if(controller.getRightTrigger() > 0.0) {//right trigger
				int delay = 800;
				System.out.println("Right Trigger is Down");
				while(controller.getRightTrigger() > 0.0) {
					web.setPage(BOTIP + "/walkForward");
					TimeUnit.MILLISECONDS.sleep(delay);
					System.out.println("Respawning");
					delay += 150;
				}
			}
			if(controller.getLeftTrigger() > 0.0) {//left ttrigger
				System.out.println("Left Trigger is Down");
				while(controller.getLeftTrigger() > 0.0) {
					web.setPage(BOTIP + "/walkBackward");
					TimeUnit.MILLISECONDS.sleep(1200);
					System.out.println("Respawning");
				}
			}
			if(controller.getLeftX() > 0.5) {//left x
				System.out.println("Left Stick is Left");
				while(controller.getLeftX() > 0.5) {
					web.setPage(BOTIP + "/turnLeft");
					TimeUnit.MILLISECONDS.sleep(1200);
					System.out.println("Respawning");
				}
			}
			if(controller.getLeftX() < -0.5) {//left x
				System.out.println("Left Stick is Right");
				while(controller.getLeftX() < -0.5) {
					web.setPage(BOTIP + "/turnRight");
					TimeUnit.MILLISECONDS.sleep(800);
					System.out.println("Respawning");
				}
			}
			if(controller.yPressed()) {// y pressed
					System.out.println("Y Pressed");
					web.setPage(BOTIP + "/bow");
					TimeUnit.MILLISECONDS.sleep(1200);
			}
			if(controller.aPressed()) {// a pressed
					System.out.println("A Pressed");
					web.setPage(BOTIP + "/bendBack");
					TimeUnit.MILLISECONDS.sleep(1200);
			}
			if(controller.xPressed()) {// x pressed
					System.out.println("X Pressed");
					web.setPage(BOTIP + "/walkForward");
					TimeUnit.MILLISECONDS.sleep(1200);
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
	
	public boolean stopButtonPressed() throws ControllerUnpluggedException {
		if(controller.aPressed()) {
			return false;
		}
		else {
			return true;
		}
	}
}