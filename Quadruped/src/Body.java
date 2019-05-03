import java.awt.Image;
import java.awt.Graphics;

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	
	public Body(int x, int y, Image body) {
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
	}
	public static void moveForward() {
		
	}
	
	public static void moveBackward() {
		
	}
	
	public static void turnLeft() {
		
	}
	
	public static void turnRight() {
		
	}
	
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
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
