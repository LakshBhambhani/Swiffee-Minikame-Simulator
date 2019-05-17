/*
 * Description: Uses various runnable objects to create different threads and run them at the same time. Doesn't work though.
 * @author Laksh
 */
public class ControlMultithread extends Thread{
	
	public ControlMultithread() {
		Thread Xbox = new Thread(new Xbox());// creates a thread
		Thread panel = new Thread(new ControlPanelJframe());
		panel.start(); // starts a thread
		panel.interrupt();
		Xbox.start();
	}
}
