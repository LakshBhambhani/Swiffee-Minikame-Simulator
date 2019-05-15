import java.awt.Image;
import java.awt.Graphics;

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	
	public Body(int x, int y, Image body) {
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
	}
	
	public void shift(double x, double y) {
		coordinates.shift(x, y);
	}
	
	public void rotate(double radians) {
		coordinates.rotate(radians);
	}
	
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
	}
}
