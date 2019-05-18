import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.*;
import java.util.List;
import java.awt.Image.*;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.jcraft.jsch.JSchException;

import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import com.apple.eawt.Application;

/*
 * @author for main window: Megan
 * @author for terminal & IDE placement: Laksh
 * 
 * Description: basically the main window that user sees and uses. Contains terminal, IDE, a menu bar and the display area where the bot
 * can be seen
 * 
 */

public class SimulatorWindow extends JFrame{
	
	private JTextArea programInput, terminal;
	private JButton runOnBot;
	private JButton run;
	
	private boolean inputIsClicked = false;
	private boolean terminalIsClicked =  false;
	private boolean buttonIsClicked = false;
	
	public SimulatorWindow() throws IOException {
		super("Quadruped Simulator");
		Java java = new Java();
				
		setJMenuBar(new SimulatorMenu(this));
				
		setUpGUI();
		programInput.setText("Swiffee IDE");
		terminal.setText("Terminal");
		
		this.setIconImage(new ImageIcon("Icon.png").getImage());
		
		Application application = Application.getApplication();
		Image image = Toolkit.getDefaultToolkit().getImage("Icon.png");
		application.setDockIconImage(image);
		
		refresh();
		
	}
	
	private void setUpGUI() {
		
	    programInput = new JTextArea(15, 20);
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
	    
	    terminal = new JTextArea(15, 20);
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
	    
	    ActionListener sendListenerForBot = new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    	          if (e.getSource() == runOnBot){
	    	        	  
	    	        	ScpTo scpObject = new ScpTo();
	    	      		ConnectToBot ctbObject = new ConnectToBot();
	    	      		
  	    	      		try {
  	    	      			try {
								saveToFile("Commands.txt", programInput);
								System.out.println("Success, Saved File!");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
  	    	      			scpObject.sendTo();
							ctbObject.remoteExecute();
							terminal.setText(terminal.getText() + "\n" + "Success");
						} catch (JSchException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							terminal.setText(terminal.getText() + "\n" + "Failed to find bot! Running in Simulator");
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
						} 
	    	  
	    	                
	    	};
	    	
	    	 runOnBot = new JButton("Run On Bot"){
	 	        {
	 	            setSize(180, 75);
	 	            setMaximumSize(getSize());
	 	        }
	 	    };
	    	
	    runOnBot.addActionListener(sendListenerForBot);
	    
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
	    	
	    //Box containing the panel (pictures)
	    Simulator panel = new Simulator();
	    Box box1 = Box.createVerticalBox();
	    panel.setPreferredSize(new Dimension (800, 600));
	    box1.add(panel);

	    
	    //Box containing the text boxes and run button
	    Box box2 = Box.createVerticalBox();
	    programInputPane.setPreferredSize(new Dimension (200, 10));
	    box2.add(programInputPane);
	    box2.add(Box.createVerticalStrut(20));
	    box2.add(run);
	    box2.add(runOnBot);
	    box2.add(Box.createVerticalStrut(20));
	    terminalPane.setPreferredSize(new Dimension (200, 10));
	    box2.add(terminalPane);
	    
	    //Box combining the two
	    Box box = Box.createHorizontalBox();
	    box.add(box1);
	    box.add(Box.createHorizontalStrut(20));
	    box.add(box2);
	    
	    Container c = getContentPane();
	    c.setLayout (new FlowLayout(FlowLayout.CENTER, 20, 20));
	    c.add(box);
	    
	}
	
	public void refresh() {
	    String text = programInput.getText();
	}
	
	public void actionPerformed(ActionEvent e) {
	    refresh();
	}
	
	public void setText(String text) {
		programInput.setText(text);
	}


	public static void main(String[] args) throws IOException {
		
		
		    SimulatorWindow window = new SimulatorWindow();
		    window.setBounds(0, 0, 1100, 700);
		    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    window.setResizable(false);
		    
		    
//		    Simulator panel = new Simulator();
//		    panel.setBounds(100, 70, 600, 1000);
//		    panel.setBackground(Color.WHITE);
//		    Container y = window.getContentPane();
//		    y.add(panel);
		    
		    window.setVisible(true);										// makes the window visible
		    
		    
		   
	}
	
	void saveToFile(String fileName, JTextArea textField) throws Exception {
		 File file = new File(fileName); 
         
	        if(file.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	   		 file = new File(fileName); 
		   FileOutputStream out = new FileOutputStream(fileName, true);
		   out.write(textField.getText().getBytes());
		} 
	}
}