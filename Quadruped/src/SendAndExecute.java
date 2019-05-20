import java.io.IOException;

/*
 * Sends and executes the file on the bot using other classes such as SCPto and ConnectToBot
 */

import com.jcraft.jsch.JSchException;

/**
 * Just a class for testing send and execute together. Not used anywhere in the code
 * @author lakshbhambhani
 *
 */
public class SendAndExecute {
	
	public static void main(String[] args) throws JSchException, IOException {
		ScpTo scpObject = new ScpTo();
		ConnectToBot ctbObject = new ConnectToBot();
		
		scpObject.sendTo();
		ctbObject.remoteExecute();
	}
}
