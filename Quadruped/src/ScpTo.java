import java.io.IOException;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSchException;


/*
 * Sends the file to the bot
 */
public class ScpTo {

	// main class let exec demo
	public static void sendTo() throws JSchException, IOException {
		// TODO Auto-generated method stub
		//now we start up run
		SFTPBean sftpBean = new SFTPBean();
		ConnectToBot ctbObject = new ConnectToBot();

		boolean blResult = sftpBean.connect("raspberrypi.local", 22, "pi", "quadruped"); // uses sftp bean to communicate with the bot

		if (blResult) {
			System.out.println("Connection successful");
			
			blResult = sftpBean.uploadFile( "\\Commands.txt","\\Swiffee-Minikame-Simulator/QuadrupedPi/Quadruped");
			if(blResult) {
				System.out.println("upload successful");
			}
			else {
				System.err.println("upload failed");
			}
			sftpBean.close();
		} else {
			System.err.println("Connection failed.");
		}
	}

}