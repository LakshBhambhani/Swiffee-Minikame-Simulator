import java.awt.Image;
import java.awt.Graphics;

/**
 * Class for the body. Uses coordinate system to move around on Simulator
 * @author Megan
 * @date 5/26/19
 */

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	private int x, y;
	
	/**
	 * Constructor for body
	 * @param x
	 * @param y
	 * @param body
	 */
	public Body(int x, int y, Image body) { 
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Used to move it to x and y
	 * @param x
	 * @param y
	 */
	public void shift(double x, double y) {
		coordinates.shift(x, y);
		this.x += x;
		this.y += y;
	}
	
	/**
	 * used to rotate it in one place
	 * @param radians
	 */
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	/**
	 * Used to print it to the window
	 * @param g
	 */
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
	}
	
	/**
	 * returnx x coordinate of the body
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * returns y coordinate of the body
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * sets image of the body
	 * @param image
	 */
	public void setImage(Image image) {
		body = image;
	}
}
