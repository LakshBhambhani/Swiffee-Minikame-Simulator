import java.awt.Image;
import java.awt.Graphics;

public class Body {
	
	private Image body;
	private CoordinateSystem coordinates;
	
	public Body(int x, int y, Image body) {
		this.body = body;
		coordinates = new CoordinateSystem(x, y, body);
	}
	
	public void draw(Graphics g) {
	  coordinates.drawImage(g, body);
	}
}
