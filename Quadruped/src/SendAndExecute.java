import java.io.IOException;

/*
 * Sends and executes the file on the bot using other classes such as SCPto and ConnectToBot
 */

import com.jcraft.jsch.JSchException;

public class SendAndExecute {
	
	public static void main(String[] args) throws JSchException, IOException {
		ScpTo scpObject = new ScpTo();
		ConnectToBot ctbObject = new ConnectToBot();
		
		scpObject.sendTo();
		ctbObject.remoteExecute();
	}
}
