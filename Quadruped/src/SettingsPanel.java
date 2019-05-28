import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Settings panel helps user set the ip of the bot so that user can upload code from simulator and also control the bot using xbox
 * @author lakshbhambhani
 * @date 5/26/19
 *
 */
public class SettingsPanel {

	/**
	 * Settings panel constructor. Uses JOptionPane
	 */
    public SettingsPanel(){
        final JFrame parent = new JFrame();
        
        String input = JOptionPane.showInputDialog(null,"Bot IP: " + SimulatorWindow.botIP, "name", JOptionPane.INFORMATION_MESSAGE); 
        if(input == null || (input != null && ("".equals(input))))   
        {
            SimulatorWindow.botIP = SimulatorWindow.botIP;
        }
        else {
            SimulatorWindow.botIP = input;
        }
        System.out.println("IP Changed to: " + SimulatorWindow.botIP);
        parent.dispose();
        parent.setEnabled(false);       
    }
       
    }
