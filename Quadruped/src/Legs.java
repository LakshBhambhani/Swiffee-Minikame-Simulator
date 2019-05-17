import java.awt.Image;
import java.awt.Graphics;

/*
 * Legs class. Pretty straight forward. Also uses coordinate system
 * @author Megan
 */
public class Legs {
	
	private Image leg;
	private CoordinateSystem coordinates;
	private int x, y;

	public Legs(int x, int y, Image leg) {
		this.leg = leg;
		coordinates = new CoordinateSystem(x, y, leg);
		this.x = x;
		this.y = y;
	}
	
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	public void shift(double x, double y) {
		coordinates.shift(x, y);
	}
	
	public void draw(Graphics g) {
		coordinates.drawImage(g, leg);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setImage(Image image) {
		leg = image;
	}

}
