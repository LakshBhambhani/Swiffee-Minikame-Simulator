import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.*;

/*
 * @author for main window: Megan
 * @author for terminal & IDE placement: Laksh
 * 
 */

public class SimulatorWindow extends JFrame{
	
	private JTextArea programInput, terminal;
	private JButton run;
	
	private boolean inputIsClicked = false;
	private boolean terminalIsClicked =  false;
	private boolean buttonIsClicked = false;
	
	public SimulatorWindow() {
		super("Quadruped Simulator");
		Java java = new Java();
		
		setUpGUI();
		programInput.setText("Swiffee IDE");
		terminal.setText("Terminal");
		
		refresh();
	}
	
	private void setUpGUI() {
		
	    programInput = new JTextArea(20, 20);
	    programInput.setLineWrap(true);
	    programInput.setWrapStyleWord(true);
	    
	    programInput.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	          if(!inputIsClicked) {
	        	  programInput.setText("");
		          inputIsClicked = true;
	          } 
	        }
	    });	 
	    JScrollPane programInputPane = new JScrollPane(programInput,
	              ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    terminal = new JTextArea(20, 20);
	    terminal.setLineWrap(true);
	    terminal.setWrapStyleWord(true);
	    terminal.setEditable(true);
	    if(!buttonIsClicked) {
	    	terminal.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		          if(!terminalIsClicked && !buttonIsClicked) {
		        	  terminal.setText("user@terminal: ");
			          terminalIsClicked = true;
		          } 
		        }
		    });	
	    }
	    terminal.addKeyListener(new KeyListener(){
	        public void keyPressed(KeyEvent e){
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	int num = terminal.getText().lastIndexOf("user@terminal");
	            	boolean whiteSpace = Character.isWhitespace(terminal.getText().indexOf(":", num) + 2);
	            	String text;
	            	if(whiteSpace) {
		            	text = terminal.getText().substring(terminal.getText().indexOf(":", num) + 2, terminal.getText().length()).trim();

	            	}
	            	else {
		            	text = terminal.getText().substring(terminal.getText().indexOf(":", num) + 1, terminal.getText().length()).trim();

	            	}
	            	System.out.println("Terminal Input:" + text);
	            	
	            	if(text.equals("clear")) {
	            		terminal.setText("user@terminal: ");
	            		
	            	}
	            	else {
	            		try {
	            			String str = Java.process(text);
	            			boolean error = false;
	            			System.out.println(error);
	            			if(str.equals("error")) {
	            				terminal.setForeground(Color.RED);
	            				terminal.setText(terminal.getText() + "error");
	            				error = false;
	            			}
	            			else {
	            				if(error != true) {
									terminal.setText(terminal.getText() + "\n" + str);
	            				}
	            			}
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            		terminal.setText(terminal.getText() + "\nuser@terminal:");
	            	}
	            	
//	            	terminal.setCaretPosition(terminal.getText().trim().length() + 1);	// doesn't work. Terminal error: bad position
	            	
	            	
	            }
	        }

	        public void keyTyped(KeyEvent e) {
	        }

	        public void keyReleased(KeyEvent e) {
	        }
	    });
	    
	    JScrollPane terminalPane = new JScrollPane(terminal,
	              ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    run = new JButton("Run"){
	        {
	            setSize(180, 75);
	            setMaximumSize(getSize());
	        }
	    };
	    
	    ActionListener sendListener = new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    	          if (e.getSource() == run){
	    	                String str = programInput.getText();
	    	                List<String> returnValues = null;
							try {
								returnValues = Java.processFile(str);
							} catch (InterruptedException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							boolean error = false;
							for(int i = 0; i < returnValues.size(); i++) {
								if(returnValues.get(i).toString().trim().equals("error")) {
									System.out.println("Any errors: " + error);
									terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
									error = true;
								}
								else {
									if(error != true){
										terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
									}
								}
    	                	}
	    	            	terminal.setText(terminal.getText() + "\nuser@terminal:");
	    	                }
	    	          buttonIsClicked = true;
	    	    }
	    	};
	    	
	    run.addActionListener(sendListener);
	    	
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
	
	public void refresh() {
	    String text = programInput.getText();
	}
	
	public void actionPerformed(ActionEvent e)
	  {
	    refresh();
	  }


	public static void main(String[] args) {
		    SimulatorWindow window = new SimulatorWindow();
		    window.setBounds(100, 70, 1250, 1000);
		    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    window.setVisible(true);										// makes the window visible
		    
		   
	}
}