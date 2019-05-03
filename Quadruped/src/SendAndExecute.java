import java.io.IOException;

import com.jcraft.jsch.JSchException;

public class SendAndExecute {
	
	public static void main(String[] args) throws JSchException, IOException {
		ScpTo scpObject = new ScpTo();
		ConnectToBot ctbObject = new ConnectToBot();
		
		scpObject.sendTo();
		ctbObject.remoteExecute();
	}
}
