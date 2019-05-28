import java.net.Socket;


/**
 * A thread for running the GUI and LocalServer simultaneously
 * @author lakshbhambhani
 * @date 5/26/19
 *
 */
public class LocalServerThread extends Thread{
	
	/**
	 * Creates a thread for localServer in order to run the GUI and the server simultaneously
	 */
	public LocalServerThread() {
		Socket socket = new Socket();
		Thread localServer = new Thread(new LocalServer(socket));// creates a thread
		localServer.start();
		localServer.yield();
	}

}
