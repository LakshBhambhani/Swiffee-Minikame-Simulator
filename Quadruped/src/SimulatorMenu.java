import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import com.studiohartman.jamepad.ControllerUnpluggedException;

public class SimulatorMenu extends JMenuBar {

	private SimulatorWindow simulatorWindow;
	private JMenuItem exitItem, loadItem, kitItem, helpItem, controlItem, bugItem, aboutItem, apiItem;
	
	public SimulatorMenu(SimulatorWindow simulatorWindow) {
	   
		this.simulatorWindow = simulatorWindow;
		
		JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic('F');

	    FileAction fileAction = new FileAction();
	    loadItem = new JMenuItem("Open...");
	    loadItem.addActionListener(fileAction);
	    aboutItem = new JMenuItem("About...");
	    aboutItem.addActionListener(fileAction);
	    exitItem = new JMenuItem("Exit");
	    exitItem.addActionListener(fileAction);
	    fileMenu.add(loadItem);
	    fileMenu.add(aboutItem);
	    fileMenu.addSeparator();
	    fileMenu.add(exitItem);
	    add(fileMenu);
	    
	    JMenu runMenu = new JMenu("Run");
	    fileMenu.setMnemonic('F');

	    controlItem = new JMenuItem("Xbox Control");
	    controlItem.addActionListener(fileAction);
	    runMenu.add(controlItem);
	    add(runMenu);
	    
	    JMenu helpMenu = new JMenu("Help");
	    fileMenu.setMnemonic('F');

	    apiItem = new JMenuItem("Swiffee API");
	    apiItem.addActionListener(fileAction);
	    kitItem = new JMenuItem("Get The Kit");
	    kitItem.addActionListener(fileAction);
	    bugItem = new JMenuItem("Report a bug");
	    bugItem.addActionListener(fileAction);
	    helpMenu.add(apiItem);
	    helpMenu.add(kitItem);
	    helpMenu.add(bugItem);
	    add(helpMenu);
	}
	
	private class FileAction implements ActionListener {
	    private String pathname = System.getProperty("user.dir") + "/";

	    public void actionPerformed(ActionEvent e)
	    {
	      JMenuItem m = (JMenuItem)e.getSource();
	      if (m == loadItem)
	      {
	        loadText();
	      }
	      else if (m == kitItem)
	      {
	    	if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
  		    try {
					Desktop.getDesktop().browse(new URI("https://www.amazon.com/dp/B07RMXDS6P/ref=dp_olp_1"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  		}

	      }
	      else if (m == bugItem)
	      {
	    	  if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	    		    try {
						Desktop.getDesktop().browse(new URI("https://github.com/LakshBhambhani/Swiffee-Minikame-Simulator/issues/new"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	      }
	      else if (m == controlItem)
	      {
	    	  ControlPanelJframe.drawFrame();
	      }
	      else if (m == exitItem)
	      {
	        System.exit(0);
	      }
	      else if(m == apiItem) {
	    	  if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	    		    try {
						Desktop.getDesktop().browse(new URI("https://lakshbhambhani.github.io/Swiffee-Minikame-Simulator"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	      }
	      else if (m == aboutItem)
	      {
	    	  try {
					AboutPanel aboutPanel = new AboutPanel();
				} catch (ControllerUnpluggedException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      }
	    }

	    private void loadText() {
	    	String line = "";
	    	String text = "";
	    	
	        JFileChooser fileChooser = new JFileChooser(pathname);
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        int result = fileChooser.showOpenDialog(simulatorWindow);
	        if (result == JFileChooser.CANCEL_OPTION)
	          return;
	    
	        File file = fileChooser.getSelectedFile();
	        if (file == null)
	          return;

	        pathname = file.getAbsolutePath();
	        Scanner fileIn = null;
	        try
	        {
	          fileIn = new Scanner(file);
	        }
	        catch (IOException ex)
	        {
	          System.out.println("*** Can't open file ***");
	          return;
	        }
	        
	        try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
	            while((line = reader.readLine()) != null) {
	                text += line + "\n";
	            }
	                
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException ex)
	        {
		          System.out.println("*** Can't open file ***");
		          return;
		    }
	        
	        simulatorWindow.setText(text);
	        
	    }
	}
}
