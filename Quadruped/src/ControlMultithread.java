
public class ControlMultithread extends Thread{
	
	public ControlMultithread() {
		Thread Xbox = new Thread(new Xbox());
		Thread panel = new Thread(new ControlPanelJframe());
		panel.start();
		panel.interrupt();
		Xbox.start();
	}
}
