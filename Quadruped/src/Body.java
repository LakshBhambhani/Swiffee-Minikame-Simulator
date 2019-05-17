import java.awt.Image;
import java.awt.Graphics;

/*
 * Class for the body. Uses coordinate system to move around on Simulator
 * @author Megan
 */

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	private int x, y;
	
	// constructor
	public Body(int x, int y, Image body) { 
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
		this.x = x;
		this.y = y;
	}
	
	// used to move it x and y
	public void shift(double x, double y) {
		coordinates.shift(x, y);
		this.x += x;
		this.y += y;
	}
	
	// used to rotate in one place
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	// used to print it to the window
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setImage(Image image) {
		body = image;
	}
}
