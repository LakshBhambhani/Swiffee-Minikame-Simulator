import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;

public class RemoteExecute {
public static void main(String[] args) throws JSchException, IOException {
    JSch jSch = new JSch();
    String user = "pi";
    String host = "raspberrypi.local";
    int port = 22;
    String password = "quadruped";
    String cmd = "python3 Swiffee-Minikame-Simulator/QuadrupedPi/Quadruped/ProcessFile.py";

    Session session = jSch.getSession(user, host, port);
    session.setPassword(password);
    session.setConfig("StrictHostKeyChecking", "no");
    session.connect();
    ChannelExec channel = (ChannelExec) session.openChannel("exec");
    channel.setCommand(cmd);

//    BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream(), "utf8"));
//    OutputStream out = channel.getOutputStream();

    channel.connect();

//    String line = null;
//    while (true) {
//        line = in.readLine();
//        if(line != null){
//            System.out.println(line);
//        }else{
//            if(channel.isClosed()){
//                System.out.println("退出状态" + channel.getExitStatus());
//                break;
//            }else{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
 //   }

    channel.disconnect();
    session.disconnect();
}
}