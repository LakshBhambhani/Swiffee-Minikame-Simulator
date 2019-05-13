import java.io.IOException;
import javax.swing.JEditorPane;
import java.util.concurrent.TimeUnit;
import com.studiohartman.jamepad.ControllerUnpluggedException;

public class XboxListener{

	XboxControl controller = new XboxControl();
	JEditorPane web = new JEditorPane();
	
	String BOTIP = "http://192.168.0.28";
	
	int i = 0;

	public void Listen() throws ControllerUnpluggedException, IOException, InterruptedException {
			if(controller.rightBumperPressed()) {
			System.out.println("Right Bumper Pressed");
			web.setPage(BOTIP + "/homePos");
			TimeUnit.MILLISECONDS.sleep(1200);
			}
			if(controller.getRightTrigger() > 0.5) {
				int delay = 800;
				System.out.println("Right Trigger is Down");
				while(controller.getRightTrigger() > 0.0) {
					web.setPage(BOTIP + "/ArmUpOn");
					TimeUnit.MILLISECONDS.sleep(delay);
					System.out.println("Respawning");
					delay += 150;
				}
			}
			if(controller.getRightTrigger() < 0.5 && controller.getRightTrigger() > 0.0) {
				int delay = 800;
				System.out.println("Right Trigger is Down");
				while(controller.getRightTrigger() < 0.5) {
					web.setPage(BOTIP + "/ArmOff");
					TimeUnit.MILLISECONDS.sleep(delay);
					System.out.println("Respawning");
					delay += 150;
				}
			}
			if(controller.getLeftTrigger() > 0.5) {
				System.out.println("Left Trigger is Down");
				while(controller.getLeftTrigger() > 0.5) {
					web.setPage(BOTIP + "/ArmDownOn");
					TimeUnit.MILLISECONDS.sleep(1200);
					System.out.println("Respawning");
				}
			}
			if(controller.getLeftTrigger() < 0.5 && controller.getLeftTrigger() > 0.0) {
				System.out.println("Left Trigger is Down");
				while(controller.getLeftTrigger() < 0.5) {
					web.setPage(BOTIP + "/ArmOff");
					TimeUnit.MILLISECONDS.sleep(1200);
					System.out.println("Respawning");
				}
			}
			if(controller.getLeftY() > 0.5) {
				System.out.println("Left Stick is Up");
				while(controller.getLeftX() > 0.5) {
					web.setPage(BOTIP + "/swallowOut");
					TimeUnit.MILLISECONDS.sleep(1200);
					System.out.println("Respawning");
				}
			}
			if(controller.getLeftX() < -0.5) {
				System.out.println("Left Stick is Down");
				while(controller.getLeftX() < -0.5) {
					web.setPage(BOTIP + "/swallowIn");
					TimeUnit.MILLISECONDS.sleep(800);
					System.out.println("Respawning");
				}
			}
//			if(controller.yPressed()) {
//					System.out.println("A Pressed");
//					web.setPage(BOTIP + "/bow");
//					TimeUnit.MILLISECONDS.sleep(1200);
//			}
//			if(controller.aPressed()) {
//					System.out.println("A Pressed");
//					web.setPage(BOTIP + "/bendBack");
//					TimeUnit.MILLISECONDS.sleep(1200);
//			}
			if(controller.xPressed()) {
					System.out.println("A Pressed");
					web.setPage(BOTIP + "/ClawMotorStop");
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
