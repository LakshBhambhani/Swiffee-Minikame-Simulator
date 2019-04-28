import java.awt.Image;
import java.awt.Graphics;

public class Legs {
	
	private Image leg; // Top left, top right, back left, back right
	private CoordinateSystem coordinates;
	
	public Legs(int x, int y, Image leg) {
		this.leg = leg;
		coordinates = new CoordinateSystem(x, y, leg);
	}
	
	public void draw(Graphics g) {
		coordinates.drawImage(g, leg);
	}


}
