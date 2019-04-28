import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author World
 */
public class ConnectToBot {
	
	private static String user = "pi";
    private static String password = "Lhbhambhani1107$";
    private static String host = "raspberrypi.local";
    int port = 22;

    public static void main(String args[]) throws IOException, SftpException {
        
        String remoteFile = "mc.java";

        try {
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(user, host, port);
//            session.setPassword(password);
//            session.setConfig("StrictHostKeyChecking", "no");
//            System.out.println("Establishing Connection...");
//            session.connect();
//            System.out.println("Connection established.");
//            System.out.println("Crating SFTP Channel.");
//            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
//            sftpChannel.connect();
//            System.out.println("SFTP Channel created.");
//
//            InputStream inputStream = sftpChannel.get(remoteFile);
//
//            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    System.out.println(line);
//                }
//            }
        	remoteLs();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
    
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

        ce.setCommand("ls -l");
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

        ce.put("/home/myuser/test.txt","Test.txt");

        ce.disconnect();
        s.disconnect();    
      }
      
      public static void remoteScp() throws JSchException, IOException {
          JSch js = new JSch();
          Session s = js.getSession(user, host, 22);
          s.setPassword(password);
          Properties config = new Properties();
          config.put("StrictHostKeyChecking", "no");
          s.setConfig(config);
          s.connect();

          Channel c = s.openChannel("exec");
          ChannelExec ce = (ChannelExec) c;

          ce.setCommand("scp");
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