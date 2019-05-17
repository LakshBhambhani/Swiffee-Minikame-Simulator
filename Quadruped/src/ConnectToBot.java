import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

/**
 * Description: Helps connect to the bot and execute various
 * terminal statement which you probably arent aware about if you are
 * new to programming. Please dont give me a 1/5 because of the
 * complexity of this
 * @author Laksh
 */
public class ConnectToBot {

	private static String user = "pi";
	private static String password = "quadruped";
	private static String host = "raspberrypi.local";
	int port = 22;

//    public static void main(String args[]) throws IOException, SftpException {
//        
//        try {
//        	remoteExecute();
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }
//    }

	// List, lets you see the files
	public static void remoteLs() throws JSchException, IOException {
		JSch js = new JSch();
		Session s = js.getSession(user, host, 22);
		s.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		s.setConfig(config);
		s.connect();

		Channel c = s.openChannel("exec");
		ChannelExec ce = (ChannelExec) c;

		ce.setCommand("ls Swiffee-Minikame-Simulator/QuadrupedPi/Quadruped/");
		ce.setErrStream(System.err);

		ce.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		ce.disconnect();
		s.disconnect();

		System.out.println("Exit code: " + ce.getExitStatus());

	}

	// mkdir stands for make directory
	public static void remoteMkdir() throws JSchException, IOException {
		JSch js = new JSch();
		Session s = js.getSession(user, host, 22);
		s.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		s.setConfig(config);
		s.connect();

		Channel c = s.openChannel("exec");
		ChannelExec ce = (ChannelExec) c;

		ce.setCommand("mkdir remotetestdir");
		ce.setErrStream(System.err);

		ce.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		ce.disconnect();
		s.disconnect();

		System.out.println("Exit code: " + ce.getExitStatus());

	}

	// copy copies the file. I dont use it tho
	public static void remoteCopy() throws JSchException, IOException, SftpException {
		JSch js = new JSch();
		Session s = js.getSession(user, host, 22);
		s.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		s.setConfig(config);
		s.connect();

		Channel c = s.openChannel("sftp");
		ChannelSftp ce = (ChannelSftp) c;

		ce.connect();

		ce.put("/home/myuser/test.txt", "Test.txt");

		ce.disconnect();
		s.disconnect();
	}

	// executes the file
	public static void remoteExecute() throws JSchException, IOException {
		JSch js = new JSch();
		Session s = js.getSession(user, host, 22);
		s.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		s.setConfig(config);
		s.connect();

		Channel c = s.openChannel("exec");
		ChannelExec ce = (ChannelExec) c;

		ce.setCommand("python3 Swiffee-Minikame-Simulator/QuadrupedPi/Quadruped/ProcessFile.py");
		ce.setErrStream(System.err);

		ce.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		ce.disconnect();
		s.disconnect();

		System.out.println("Exit code: " + ce.getExitStatus());

	}
}