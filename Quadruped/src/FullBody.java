import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FullBody {
	
	private static Image bodyImage;
	private static Image legTL, legTR, legBL, legBR; // In relation to the robot body
	private static Body body;
	private static Legs leg1, leg2, leg3, leg4;
	private int width, height;
	private static Simulator simulator;
	
	public FullBody(Simulator simulator) {
		
//		int bodyWidth = 0, bodyHeight = 0;
		
		this.simulator = simulator;
//		width = simulator.getWidth();
//		height = simulator.getHeight();
		
		bodyImage = (new ImageIcon("body.png")).getImage();
		legTL = (new ImageIcon("leg1.png")).getImage();
		legTR = (new ImageIcon("leg2.png")).getImage();
		legBL = (new ImageIcon("leg3.png")).getImage();
		legBR = (new ImageIcon("leg4.png")).getImage();
		
//		BufferedImage bimg;
//		try {
//			bimg = ImageIO.read(new File("body.png"));
//			bodyWidth          = bimg.getWidth();
//			bodyHeight         = bimg.getHeight();
//			System.out.println(width/2);
//			System.out.println(bodyWidth);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		body = new Body(430, 410, bodyImage);
		leg1 = new Legs(430, 410, legTL);
//		leg1 = new Legs(530, 410, legTL);
		leg2 = new Legs(430, 410, legTR);
		leg3 = new Legs(430, 410, legBL);
//		leg3 = new Legs(275, 185, legBL);
		leg4 = new Legs(430, 410, legBR);
		
	}
	
	public void draw(Graphics2D g) {
		body.draw(g);
		leg1.draw(g);
		leg2.draw(g);
		leg3.draw(g);
		leg4.draw(g);
	}
	
	public static void fullBodyShift(double x, double y) {
		body.shift(x, y);
		leg1.shift(x, y);
		leg2.shift(x, y);
		leg3.shift(x, y);
		leg4.shift(x, y);

	}
	
	public static void fullBodyRotate(double radians) {
		body.rotate(radians);
		leg1.rotate(radians);
		leg2.rotate(radians);
		leg3.rotate(radians);
		leg4.rotate(radians);

	}
	
	public static void moveForward() throws InterruptedException {
		
		// Moves front right and back left leg forward
		for (int i = 0; i < 30; i += 1) {
			leg1.rotate(Math.PI / 180);
			leg1.shift(-0.6, -0.8);
			leg3.rotate(-Math.PI / 180);
			leg3.shift(3.2, -1.7);
			
			simulator.paintImmediately(0,0,800,800);
		}
		
		// Then moves back while moving whole quadruped
		for (int i = 0; i < 30; i += 1) {
			
			fullBodyShift(0, 0.25);
			
			leg1.rotate(-Math.PI / 180);
			leg1.shift(0.6, 0.8);
			leg3.rotate(Math.PI / 180);
			leg3.shift(-3.2, 1.7);
			
			simulator.paintImmediately(0,0,800,800);
		}
		
		// Moves front left and back right leg forward
		for (int i = 0; i < 30; i += 1) {
			leg2.rotate(-Math.PI / 180);
			leg2.shift(0.4, -2);
			leg4.rotate(Math.PI / 180);
			leg4.shift(-3, -1);
						
			simulator.paintImmediately(0,0,800,800);
		}
		
		// Then back while moving full body
		for (int i = 0; i < 30; i += 1) {
			fullBodyShift(0, 0.25);
			
			leg2.rotate(Math.PI / 180);
			leg2.shift(-0.4, 2);
			leg4.rotate(-Math.PI / 180);
			leg4.shift(3, 1);
	
			simulator.paintImmediately(0, 0, 800, 800);
		}

	}
	
	public static void moveBackward() {

		// Moves the back left and front right leg backwards
		for (int i = 0; i < 30; i += 1) {

			leg1.rotate(-Math.PI / 180);
			leg1.shift(0.65, 0.8);
			leg3.rotate(Math.PI / 180);
			leg3.shift(-3.45, 1.65);

			simulator.paintImmediately(0,0,800,800);
			
		}
		
		// Then back to where it was, while moving whole body
		for (int i = 0; i < 30; i += 1) {
			
			fullBodyShift(0, -0.25);
			
			leg1.rotate(Math.PI / 180);
			leg1.shift(-0.6, -0.8);
			leg3.rotate(-Math.PI / 180);
			leg3.shift(3.4, -1.6);
			
			simulator.paintImmediately(0, 0, 800, 800);
			
		}
		
		// Moves back right and front left leg backwards
		for (int i = 0; i < 30; i += 1) {
			leg2.rotate(Math.PI / 180);
			leg2.shift(-0.45, 2.05);
			leg4.rotate(Math.PI / 180);
			leg4.shift(-3.3, -1);
			simulator.paintImmediately(0,0,800,800);
		}
		
		// Then back to where it was, while moving whole body
		for (int i = 0; i < 30; i += 1) {
			fullBodyShift(0, -0.25);
			
			leg2.shift(0.4, -2);
			leg2.rotate(-Math.PI / 180);
			leg4.shift(3.2, 1);
			leg4.rotate(-Math.PI / 180);

			
			simulator.paintImmediately(0,0,800,800);
		}
	}
	
	public static void turnLeft() {
		for (int i = 0; i < 30; i += 1) {
			
			fullBodyShift(1, -0.5);
			fullBodyRotate(-Math.PI / 360);
			
			leg1.rotate(Math.PI / 180);
			leg1.shift(-1.2, -1.2);
			leg3.rotate(-Math.PI / 180);
			leg3.shift(3.2, -2.5);
			
			leg2.rotate(-Math.PI / 360);
			leg2.shift(0.2, -0.8);
			leg4.rotate(-Math.PI / 360);
			leg4.shift(1.8, 0.2);
			
			simulator.paintImmediately(0, 0, 800, 800);
			
		}
		
		for (int i = 0; i < 30; i += 1) {
			leg1.rotate(-Math.PI / 180);
			leg1.shift(0.9, 1.1);
			leg3.rotate(Math.PI / 180);
			leg3.shift(-3.3, 2.4);
			
			simulator.paintImmediately(0, 0, 800, 800);
		}
		
		for (int i = 0; i < 30; i += 1) {
			
			leg2.rotate(Math.PI / 360);
			leg2.shift(-0.2, 0.9);
			leg4.rotate(Math.PI / 360);
			leg4.shift(-1.7, -0.3);
			
			simulator.paintImmediately(0, 0, 800, 800);
		}
	}
	
	public static void turnRight() {
		
		for (int i = 0; i < 30; i += 1) {
			
			fullBodyShift(-1, 0.5);
			fullBodyRotate(Math.PI / 360);
			
			leg2.rotate(Math.PI / 180);
			leg2.shift(-0.9, 2.3);
			leg4.rotate(-Math.PI / 180);
			leg4.shift(2.8, 0.9);
			
			leg1.rotate(Math.PI / 360);
			leg1.shift(0, -0.2);
			leg3.rotate(Math.PI / 360);
			leg3.shift(-1.8, 0.7);
			
			simulator.paintImmediately(0, 0, 800, 800);
			
		}
		
		for (int i = 0; i < 30; i += 1) {

			leg2.rotate(-Math.PI / 180);
			leg2.shift(0.8, -2.2);
			leg4.rotate(Math.PI / 180);
			leg4.shift(-3, -0.8);
			
			simulator.paintImmediately(0, 0, 800, 800);

		}
		
		for (int i = 0; i < 30; i += 1) {
			
			leg1.rotate(-Math.PI / 360);
			leg1.shift(0.1, 0.3);
			leg3.rotate(-Math.PI / 360);
			leg3.shift(1.8, -0.8);

			simulator.paintImmediately(0, 0, 800, 800);

		}
	}

	public static void homePos() {
		simulator.reinitialize();
		simulator.repaint();
	}
	
	public static void bow() {
		
	}
	
	public static void bendBack() {
		
	}
	
	public static void pushUp() {
		
	}
	
	public static void jumpUp() {
		
	}

	public static void jumpBack() {
	
	}




}
