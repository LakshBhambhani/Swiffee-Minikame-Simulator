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

public class SimulatorMenu extends JMenuBar {

	private SimulatorWindow simulatorWindow;
	private JMenuItem exitItem, loadItem, kitItem, helpItem;
	
	public SimulatorMenu(SimulatorWindow simulatorWindow) {
	   
		this.simulatorWindow = simulatorWindow;
		
		JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic('F');

	    FileAction fileAction = new FileAction();
	    loadItem = new JMenuItem("Open...");
	    loadItem.addActionListener(fileAction);
	    kitItem = new JMenuItem("Get The Kit...");
	    kitItem.addActionListener(fileAction);
	    helpItem = new JMenuItem("Help...");
	    helpItem.addActionListener(fileAction);
	    exitItem = new JMenuItem("Exit");
	    exitItem.addActionListener(fileAction);
	    fileMenu.add(loadItem);
	    fileMenu.add(kitItem);
	    fileMenu.add(helpItem);
	    fileMenu.addSeparator();
	    fileMenu.add(exitItem);
	    add(fileMenu);
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

	      }
	      else if (m == helpItem)
	      {
	    	  
	      }
	      else if (m == exitItem)
	      {
	        System.exit(0);
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