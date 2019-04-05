import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class SimulatorWindow extends JFrame{
	
	private JTextArea programInput, terminal;
	private JButton run;
	
	public SimulatorWindow() {
		super("SimulatorWindow");
		
		setUpGUI();
		programInput.setText("test");
	}
	
	private void setUpGUI() {
		
	    programInput = new JTextArea(13, 15);
	    programInput.setLineWrap(true);
	    programInput.setWrapStyleWord(true);
	    
	    JScrollPane programInputPane = new JScrollPane(programInput,
	              ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    terminal = new JTextArea(13, 15);
	    terminal.setLineWrap(true);
	    terminal.setWrapStyleWord(true);
	    terminal.setEditable(false);
	    
	    JScrollPane terminalPane = new JScrollPane(terminal,
	              ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    run = new JButton("Run");
	    run.addActionListener(null);
	    
	    Box box1 = Box.createVerticalBox();
	    box1.add(Box.createVerticalStrut(10));
	    box1.add(programInputPane);
	    box1.add(Box.createVerticalStrut(20));
	    box1.add(run);
	    box1.add(Box.createVerticalStrut(20));
	    box1.add(terminalPane);
	    Container c = getContentPane();
	    c.setLayout (new FlowLayout(FlowLayout.TRAILING, 20, 20));
	    c.add(box1);
	}

	public static void main(String[] args) {
		    SimulatorWindow window = new SimulatorWindow();
		    window.setBounds(100, 70, 1250, 1000);
		    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    window.setVisible(true);										// makes the window visible
	}
}