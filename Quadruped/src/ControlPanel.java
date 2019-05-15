import java.awt.*;
import javax.swing.*;

import com.studiohartman.jamepad.ControllerUnpluggedException;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
/*
 * Name: Laksh Bhambhani
 * Class: Java P4
 * Date: May 3rd, 2019
 * 
 * Description: 
 */
public class ControlPanel extends JPanel
{
	
  
  private Image controller = new ImageIcon("XboxMap.jpg").getImage();
  
  public static int width;
  public static int height;


  
  public ControlPanel () {
	  super(); 
	  super.setVisible(true);
	  super.setSize(803, 634);
  }

  public void paintComponent(Graphics g) // paints and repaints the xbox map image over and over again
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

    width = getWidth();
    height = getHeight();
 
    double ratioX = width/800.0;
    double ratioY = height/600.0;
    
    Graphics2D g2 = (Graphics2D)g;
    g2.scale(ratioX,ratioY);
   
    g.drawImage(controller, 0, 0, 803, 604, this);
         
  }
  
  public void repaint(Graphics g) {
	  g.drawImage(controller, 0, 0, 803, 604, this);
  }
  
 
}