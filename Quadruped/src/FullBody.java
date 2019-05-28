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

/**
 * Includes the complete body including legs and main body and you can see this on Simulator Window
 * @author Megan
 * @date 5/26/19
 */
public class FullBody {
	
	// All these fields are static because only one FullBody is instantiated and used 
	private Image bodyImage;
	private Image legTL, legTR, legBL, legBR; // In relation to the robot body
	private static Image legTL2, legTR2, legBL2, legBR2; // Bent images
	private static Body body;
	private static Legs leg1, leg2, leg3, leg4;
	private static int counter = 0; // So that some methods aren't called twice
//	private int width, height;
	private static Simulator simulator;
	
	public FullBody(Simulator simulator) {
		
//		int bodyWidth = 0, bodyHeight = 0;
		
		this.simulator = simulator;
//		width = simulator.getWidth();
//		height = simulator.getHeight();
		
		bodyImage = (new ImageIcon(FullBody.class.getResource("/resources/body.png"))).getImage();
		legTL = (new ImageIcon(FullBody.class.getResource("/resources/leg1.png"))).getImage();
		legTR = (new ImageIcon(FullBody.class.getResource("/resources/leg2.png"))).getImage();
		legBL = (new ImageIcon(FullBody.class.getResource("/resources/leg3.png"))).getImage();
		legBR = (new ImageIcon(FullBody.class.getResource("/resources/leg4.png"))).getImage();
		
		legTL2 = (new ImageIcon(FullBody.class.getResource("/resources/leg5.png"))).getImage();
		legTR2 = (new ImageIcon(FullBody.class.getResource("/resources/leg6.png"))).getImage();
		legBL2 = (new ImageIcon(FullBody.class.getResource("/resources/leg7.png"))).getImage();
		legBR2 = (new ImageIcon(FullBody.class.getResource("/resources/leg8.png"))).getImage();
		
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
	
	// Draws all the objects (four legs and one body)
	public void draw(Graphics2D g) {
		body.draw(g);
		leg1.draw(g);
		leg2.draw(g);
		leg3.draw(g);
		leg4.draw(g);
	}
	
	// Shifts the whole body
	public static void fullBodyShift(double x, double y) {
		body.shift(x, y);
		leg1.shift(x, y);
		leg2.shift(x, y);
		leg3.shift(x, y);
		leg4.shift(x, y);

	}
	
	// Rotates the whole body
	public static void fullBodyRotate(double radians) {

		body.rotate(radians);
		leg1.rotate(radians);
		leg2.rotate(radians);
		leg3.rotate(radians);
		leg4.rotate(radians);

	}
	
	/**
	 * Changes the body image and "deletes" all legs by making objects null
	 * @param image - the name of the image
	 */
	public static void fullBodyImage(String image) {
		body.setImage(new ImageIcon(FullBody.class.getResource("/resources/" +image)).getImage());
		leg1.setImage(null);
		leg2.setImage(null);
		leg3.setImage(null);
		leg4.setImage(null);
	}
	
	/**
	 * Moves the robot forward
	 */
	public static void moveForward() {
		
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
	
	/**
	 * Moves the robot backward
	 */
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
	
	/**
	 * Turns the robot to its left side
	 */
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
	
	/**
	 * turns the robot to it's right side
	 */
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

	/**
	 * Robot returns to home position
	 */
	public static void homePos() {
		simulator.reinitialize();
		simulator.repaint();
	}
	
/**
 * Animation for making the robot bow
 */
	public static void bow() {
		leg3.setImage(legBL2);
		leg4.setImage(legBR2);
		
		leg3.shift(20, -5);
		leg4.shift(20, -5);
		
		simulator.repaint();
		
		for (int i = 0; i < 15; i++) {
			leg3.rotate(Math.PI / 180);
			leg3.shift(-3.2, 1.8);
			leg4.rotate(-Math.PI / 180);
			leg4.shift(3, 0.5);
			
			leg2.rotate(-Math.PI / 180);
			leg2.shift(0.4, -2);
			leg1.rotate(Math.PI / 180);
			leg1.shift(-0.6, -0.8);
			
			simulator.paintImmediately(0, 0, 800, 800);
		}
		
		body.setImage(new ImageIcon(FullBody.class.getResource("/resources/bowBody.png")).getImage());
		leg1.shift(0, -5);
		leg2.shift(5, 0);
		leg3.shift(-3, 0);
		leg4.shift(-3, -5);
		
		simulator.repaint();
	}
	
	/**
	 * makes the robot bend back
	 * Todo: smoothen it
	 */
	public static void bendBack() {
		
		leg1.setImage(legTL2);
		leg2.setImage(legTR2);
		
		leg1.shift(15, -5);
		leg2.shift(30, 15);

		simulator.repaint();
		
		for (int i = 0; i < 15; i++) {
			leg3.rotate(Math.PI / 180);
			leg3.shift(-3.45, 1.8);
			leg4.rotate(-Math.PI / 180);
			leg4.shift(3.2, 1);
			
			leg1.rotate(Math.PI / 180);
			leg1.shift(-0.65, -0.8);
			leg2.rotate(-Math.PI / 180);
			leg2.shift(1, -2.8);
			
			simulator.paintImmediately(0, 0, 800, 800);
		}
		
		body.setImage(new ImageIcon(FullBody.class.getResource("/resources/bendBackBody.png")).getImage());	
		leg1.shift(0, 3);
		leg3.shift(5, 3);
		
		simulator.repaint();

	}
	
	/**
	 * Animations for showing the robot complete pushup
	 */
	public static void pushUp() {
		
	}
	
	/**
	 * Animations for showing the robot jump up
	 */
	public static void jumpUp() {

		if (counter == 0) {
			leg1.setImage(legTL2);
			leg2.setImage(legTR2);

			leg1.shift(20, -5);
			leg2.shift(60, 30);

			simulator.repaint();

			for (int i = 0; i < 30; i++) {

				leg1.rotate(Math.PI / 180);
				leg1.shift(-0.65, -0.8);
				leg2.rotate(-Math.PI / 180);
				leg2.shift(1.3, -2.8);

				simulator.paintImmediately(0, 0, 800, 800);
			}

			for (int i = 0; i < 60; i++) {

				leg3.rotate(-Math.PI / 180);
				leg3.shift(3.5, -2);
				leg4.rotate(Math.PI / 180);
				leg4.shift(-3.3, -1);

				simulator.paintImmediately(0, 0, 800, 800);
			}

			counter++;
			
		for (int i = 0; i < 70; i++) {
			fullBodyImage("jump1.png");
			simulator.paintImmediately(0, 0, 800, 800);
		}
		
		for (int i = 0; i < 30; i++) {
			fullBodyImage("jump1.5.png");
			simulator.paintImmediately(0, 0, 800, 800);
		}

		fullBodyImage("jump2.png");
		simulator.repaint();
		
		} else {
			counter = 0;
		}
		
	}

	/**
	 * Animations for making the robot flip
	 */
	public static void jumpBack() {

		if (counter == 0) {
			jumpUp();

			for (int i = 0; i < 30; i++) {
				fullBodyImage("jump2.5.png");
				simulator.paintImmediately(0, 0, 800, 800);
			}
			
			fullBodyImage("jump3.png");
			simulator.repaint();

			counter++;
			
		} else {
			counter = 0;
		}
	}




}
