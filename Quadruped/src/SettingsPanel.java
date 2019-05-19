import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SettingsPanel {

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
