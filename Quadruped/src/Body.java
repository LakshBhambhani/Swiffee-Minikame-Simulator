import java.awt.Image;
import java.awt.Graphics;

/*
 * Class for the body. Uses coordinate system to move around on SImulatorWindow
 */

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	
	public Body(int x, int y, Image body) { // constructor
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
	}
	
	public void shift(double x, double y) { // used to move it x and y
		coordinates.shift(x, y);
	}
	
	public void rotate(double radians) { // used to rotate in one place
		coordinates.rotate(radians);
	}
	
	public void draw(Graphics g) { // used to print it to the window
	  coordinates.drawImage(g, body);
	}
}
