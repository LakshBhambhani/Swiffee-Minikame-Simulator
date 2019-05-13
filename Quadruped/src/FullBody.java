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
	
	private Image bodyImage;
	private static Image legTL, legTR, legBL, legBR; // In relation to the robot body
	private static Image legTL2, legTR2, legBL2, legBR2; // Second set of images (legs bent)
	private Body body;
	private static Legs leg1, leg2, leg3, leg4;
	private int width, height;
	private static Simulator simulator;
	
	public FullBody(Simulator simulator) {
		
//		int bodyWidth = 0, bodyHeight = 0;
		
		this.simulator = simulator;
		width = simulator.getWidth();
		height = simulator.getHeight();
		
		bodyImage = (new ImageIcon("body.png")).getImage();
		legTL = (new ImageIcon("leg1.png")).getImage();
		legTR = (new ImageIcon("leg2.png")).getImage();
		legBL = (new ImageIcon("leg3.png")).getImage();
		legBR = (new ImageIcon("leg4.png")).getImage();
		
		legTL2 = (new ImageIcon("leg5.png")).getImage();
		legTR2 = (new ImageIcon("leg6.png")).getImage();
		legBL2 = (new ImageIcon("leg7.png")).getImage();
		legBR2 = (new ImageIcon("leg8.png")).getImage();
		
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
		leg2 = new Legs(430, 410, legTR);
		leg3 = new Legs(430, 410, legBL);
		leg4 = new Legs(430, 410, legBR);
		
	}
	
	public void draw(Graphics2D g) {
		body.draw(g);
		leg1.draw(g);
		leg2.draw(g);
		leg3.draw(g);
		leg4.draw(g);
	}
	
	public static void moveForward() throws InterruptedException {
		
		for (double i = 0; i < 8; i += 1) {
		leg1.rotate(Math.PI/180);
		simulator.paintImmediately(0,0,800,800);
		}
		
		
	}
	
	public static void moveBackward() {
		
	}
	
	public static void turnLeft() {
		
	}
	
	public static void turnRight() {
		
	}
	

	public static void homePos() {
		
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
