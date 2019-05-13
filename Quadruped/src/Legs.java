import java.awt.Image;
import java.awt.Graphics;

public class Legs {
	
	private Image leg; // Top left, top right, back left, back right
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
	
	public void draw(Graphics g) {
		coordinates.drawImage(g, leg);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}


}
