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
//import com.apple.eawt.Application;

/**
 * @author for main window: Megan
 * @author for terminal & IDE placement: Laksh
 * 
 * Description: basically the main window that user sees and uses. Contains terminal, IDE, a menu bar and the display area where the bot
 * can be seen
 * @date 5/26/19
 */

public class SimulatorWindow extends JFrame{
	
	public static JTextArea programInput, terminal;
	private JButton runOnBot;
	private JButton run;
	
	static String botIP = "172.20.10.3";	// this static variable can be accessed easily from any outside class and be modif
													// ied as this is the IP that the simulator will connect to
	private boolean inputIsClicked = false;
	private boolean terminalIsClicked =  false;
	private boolean buttonIsClicked = false;
	
	/**
	 * Constructor for Simulator Window
	 * @throws IOException
	 */
	public SimulatorWindow() throws IOException {
		super("Quadruped Simulator");
		Java java = new Java();
				
		setJMenuBar(new SimulatorMenu(this));
				
		setUpGUI();
		programInput.setText("Swiffee IDE");
		terminal.setText("Terminal");
		
		this.setIconImage(new ImageIcon(SimulatorWindow.class.getResource("/resources/Icon.png")).getImage());
		
//		Application application = Application.getApplication();
//		Image image = Toolkit.getDefaultToolkit().getImage(SimulatorWindow.class.getResource("/resources/Icon.png"));
//		application.setDockIconImage(image);
		
		refresh();
		
	}
	
	/**
	 * Sets the GUI up. Puts window with the bot in one place, the IDE and the terminal and the two buttons
	 */
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
 	        	  System.out.println("Run from bot pressed");
 	        	  String str = programInput.getText();
 	        	  String[] inputs = str.split(";");
 	        	  for(int i = 0; i < inputs.length; i++) {						
 	        		 if(inputs[i].toString().trim().equals("moveForward()")) {
						if(URLReader.readFromURL("walkForward")) {
							FullBody.moveForward();
						}
 	        		 }
 	        		 if(inputs[i].toString().trim().equals("turnLeft()")) {
						if(URLReader.readFromURL("turnLeft")) {
							FullBody.turnLeft();
						}
 	        		 }
 	        		if(inputs[i].toString().trim().equals("turnRight()")) {
						if(URLReader.readFromURL("turnRight")) {
							FullBody.turnRight();
						}
 	        		 }
 	        		 if(inputs[i].toString().trim().equals("homePos()")) {
						if(URLReader.readFromURL("homePos")) {
							FullBody.homePos();
						}
 	        		 }
 	        		if(inputs[i].toString().trim().equals("bow()")) {
						if(URLReader.readFromURL("bow")) {
							FullBody.bow();
						}
 	        		 }
 	        		 if(inputs[i].toString().trim().equals("bendBack()")) {
						if(URLReader.readFromURL("bendBack")) {
							FullBody.bendBack();
						}
 	        		 }
 	        		if(inputs[i].toString().trim().equals("jumpUp()")) {
						if(URLReader.readFromURL("jumpUp")) {
							FullBody.jumpUp();
						}
 	        		 }
 	        		if(inputs[i].toString().trim().equals("jumpBack()")) {
						if(URLReader.readFromURL("jumpBack")) {
							FullBody.jumpBack();
						}
 	        		 }
 	        		 if(inputs[i].toString().trim().equals("pushUp()")) {
						if(URLReader.readFromURL("pushUp")) {
							FullBody.pushUp();
						}
 	        		 } 	        		 
 	        	  }
	    	   }
//	    	          if (e.getSource() == runOnBot){
//	    	        	  String str = programInput.getText();
//	    	                List<String> returnValues = null;
//							try {
//								returnValues = Java.processFile(str);
//							} catch (InterruptedException e2) {
//								// TODO Auto-generated catch block
//								e2.printStackTrace();
//							}
//							boolean error = false;
//							for(int i = 0; i < returnValues.size(); i++) {
//								if(returnValues.get(i).toString().trim().equals("error")) {
//									System.out.println("Any errors: " + error);
//									terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
//									error = true;
//								}
//								else {
//									if(error != true){
//										terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
//										if(returnValues.get(i).toString().equals("Moving Forward")) {
//											if(URLReader.readFromURL("walkForward")) {
//												FullBody.moveForward();
//											}
//										}
//									}
//								}
//	                	}
//	    	            	terminal.setText(terminal.getText() + "\nuser@terminal:");
//	    	      		}
//	    	          buttonIsClicked = true;
//	    	          }
	    	        	  
//	    	        	ScpTo scpObject = new ScpTo();
//	    	      		ConnectToBot ctbObject = new ConnectToBot();
//	    	      		
//  	    	      		try {
//  	    	      			try {
//								saveToFile("Commands.txt", programInput);
//								System.out.println("Success, Saved File!");
//							} catch (Exception e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//  	    	      			scpObject.sendTo();
//							ctbObject.remoteExecute();
//							terminal.setText(terminal.getText() + "\n" + "Success");
//						} catch (JSchException | IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//							terminal.setText(terminal.getText() + "\n" + "Failed to find bot! Running in Simulator");
//							String str = programInput.getText();
//	    	                List<String> returnValues = null;
//							try {
//								returnValues = Java.processFile(str);
//							} catch (InterruptedException e2) {
//								// TODO Auto-generated catch block
//								e2.printStackTrace();
//							}
//							boolean error = false;
//							for(int i = 0; i < returnValues.size(); i++) {
//								if(returnValues.get(i).toString().trim().equals("error")) {
//									System.out.println("Any errors: " + error);
//									terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
//									error = true;
//								}
//								else {
//									if(error != true){
//										terminal.setText(terminal.getText() + "\n" + returnValues.get(i).toString());
//									}
//								}
//    	                	}
//	    	            	terminal.setText(terminal.getText() + "\nuser@terminal:");
//	    	                }
//	    	          buttonIsClicked = true;
//	    	    }
//						} 
	    	  
	    	                
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
	        	  	System.out.println("Run pressed");
	        	  	System.out.println("Text: " + programInput.getText());
	        	  	if(!programInput.getText().equals("")) {
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
    	            	buttonIsClicked = true;
	        	  	}
	        	  	else {
	        	  		
	        	  	}
	    	     			
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
	
	/**
	 * Refresh method for IDE
	 */
	public void refresh() {
	    String text = programInput.getText();
	}
	
	/**
	 * Action performed method for window
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
	    refresh();
	}
	
	/**
	 * Used for setting programInput text
	 * @param text
	 */
	public void setText(String text) {
		programInput.setText(text);
	}

	/**
	 * Main method for our project. Creates the frame, creates the file for output and initializes localServer
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
			
		
		    SimulatorWindow window = new SimulatorWindow();
		    window.setBounds(0, 0, 1100, 700);
		    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    window.setResizable(false);
		    
		    File file = new File("output.txt"); 
		    FileOutputStream fos = new FileOutputStream(file);
		    PrintStream ps = new PrintStream(fos);
		    System.setOut(ps);
		    System.out.println("Output printing starts now");
		    
		    
//		    Simulator panel = new Simulator();
//		    panel.setBounds(100, 70, 600, 1000);
//		    panel.setBackground(Color.WHITE);
//		    Container y = window.getContentPane();
//		    y.add(panel);
		    
		    window.setVisible(true);										// makes the window visible
		    
			new LocalServerThread();

		    
		    
		   
	}
	
	/**
	 * Save to file method for SimulatorWindow
	 * @param fileName
	 * @param textField
	 * @throws Exception
	 */
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