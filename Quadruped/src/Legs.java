import java.awt.Image;
import java.awt.Graphics;

/**
 * Legs class. Pretty straight forward. Also uses coordinate system
 * @author Megan
 * @date 5/26/19
 */
public class Legs {
	
	private Image leg;
	private CoordinateSystem coordinates;
	private int x, y;

	/**
	 * Constructor for Legs
	 * @param x
	 * @param y
	 * @param leg
	 */
	public Legs(int x, int y, Image leg) {
		this.leg = leg;
		coordinates = new CoordinateSystem(x, y, leg);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Used to rotate legs
	 * @param radians
	 */
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	/**
	 * used to shift the legs
	 * @param x
	 * @param y
	 */
	public void shift(double x, double y) {
		coordinates.shift(x, y);
	}
	
	/**
	 * Used to draw the legs
	 * @param g
	 */
	public void draw(Graphics g) {
		coordinates.drawImage(g, leg);
	}
	
	/**
	 * used to return x coordinates for the leg
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * used to return y coordinates for the leg
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets image for the leg
	 * @param image
	 */
	public void setImage(Image image) {
		leg = image;
	}

}
