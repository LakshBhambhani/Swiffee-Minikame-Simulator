import java.util.Vector;

import com.jcraft.jsch.ChannelSftp.LsEntry;


public class ScpTo {

	// main class let exec demo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//now we start up run
		SFTPBean sftpBean = new SFTPBean();

		boolean blResult = sftpBean.connect("192.168.0.28", 22, "pi", "quadruped");

		if (blResult) {
			System.out.println("Connection successful");
			
			blResult = sftpBean.uploadFile( "\\Test.txt","\\remotetestdir");
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