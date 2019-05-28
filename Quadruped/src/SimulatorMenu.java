import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

/**
 * responsible for the menubar on top of the simulator window
 * 
 * @author Megan and Laksh
 * @date 5/26/19s
 */

public class SimulatorMenu extends JMenuBar {

	private SimulatorWindow simulatorWindow;
	private JMenuItem exitItem, loadItem, saveItem, kitItem, helpItem, controlItem, bugItem, aboutItem, apiItem,
			settingsItem; // all jmenu items

	/**
	 * Simulator menu constructor
	 * 
	 * @param simulatorWindow
	 */
	public SimulatorMenu(SimulatorWindow simulatorWindow) {

		this.simulatorWindow = simulatorWindow;

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		FileAction fileAction = new FileAction();
		loadItem = new JMenuItem("Open...");
		loadItem.addActionListener(fileAction);
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(fileAction);
		aboutItem = new JMenuItem("About...");
		aboutItem.addActionListener(fileAction);
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(fileAction);

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
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
		settingsItem = new JMenuItem("Settings");
		settingsItem.addActionListener(fileAction);
		helpMenu.add(apiItem);
		helpMenu.add(kitItem);
		helpMenu.add(bugItem);
		helpMenu.add(settingsItem);
		add(helpMenu);
	}

	/**
	 * File action is an action listener that is executed when an option from the
	 * menubar is chosen
	 * 
	 * @author lakshbhambhani
	 *
	 */
	private class FileAction implements ActionListener {
		private String pathname = System.getProperty("user.dir") + "/";

		public void actionPerformed(ActionEvent e) {
			JMenuItem m = (JMenuItem) e.getSource();
			if (m == loadItem) {
				loadText();
			} else if (m == saveItem) {
				saveAs();
			} else if (m == kitItem) {
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

			} else if (m == bugItem) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI(
								"https://docs.google.com/forms/d/e/1FAIpQLSc1xsW7qJ0jekZKFMpLhvSA1gZLu_MZRPavHd68C66A3r8Ndg/viewform?usp=sf_link"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else if (m == controlItem) {
				ControlPanelJframe.drawFrame();
			} else if (m == settingsItem) {
				new SettingsPanel();
			} else if (m == exitItem) {
				System.exit(0);
			} else if (m == apiItem) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI("https://lakshbhambhani.github.io/SwiffeeAPI"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else if (m == aboutItem) {
				try {
					AboutPanel aboutPanel = new AboutPanel();
				} catch (ControllerUnpluggedException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		/**
		 * Used to load text into the IDE of Simulator Window
		 */
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
			try {
				fileIn = new Scanner(file);
			} catch (IOException ex) {
				System.out.println("*** Can't open file ***");
				return;
			}

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));

				while ((line = reader.readLine()) != null) {
					text += line + "\n";
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException ex) {
				System.out.println("*** Can't open file ***");
				return;
			}

			simulatorWindow.setText(text);

		}

		public void saveAs() {

			final JFileChooser saveAs = new JFileChooser(pathname);
			saveAs.setApproveButtonText("Save");
			int actionDialog = saveAs.showSaveDialog(simulatorWindow);
			if (actionDialog != JFileChooser.APPROVE_OPTION) {
				return;
			}

			File fileName = new File("newFile.txt");
			try {
				fileName.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedWriter outFile = null;
			try {
				outFile = new BufferedWriter(new FileWriter(fileName));

				SimulatorWindow.programInput.write(outFile);

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (outFile != null) {
					try {
						outFile.close();
					} catch (IOException e) {

					}
				}
			}
		}
	}
}
