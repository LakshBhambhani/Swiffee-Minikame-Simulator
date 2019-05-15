/*
 * Description: Uses various runnable objects to create diffferent threads and run them at the samee time. DOsent work tho.
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
