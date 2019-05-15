import java.awt.Image;
import java.awt.Graphics;

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	private int x, y;
	
	public Body(int x, int y, Image body) {
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
		this.x = x;
		this.y = y;
	}
	
	public void shift(double x, double y) {
		coordinates.shift(x, y);
		this.x += x;
		this.y += y;
	}
	
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
