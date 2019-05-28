import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Basically the coordinate system. The animations are dependent on this class.
 * @author creator of the Walker Lab
 * @date 5/26/19
 */
public class CoordinateSystem {
	
	private Image picture;
	private AffineTransform coordTransform;
	private Simulator simulator;

	/**
	 * 0 degrees points east
	 * Costructor
	 * @param x
	 * @param y
	 * @param pic
	 */
	public CoordinateSystem(int x, int y, Image pic) {
		picture = pic;
		coordTransform = new AffineTransform();

		int w = picture.getWidth(null) / 2;
		int h = picture.getHeight(null) / 2;
		coordTransform.translate(x - w, y - h);
	}

	/**
	 * Shift
	 * @param dx
	 * @param dy
	 */
	public void shift(double dx, double dy) {
		coordTransform.translate(dx, dy);
	}

	/**
	 * Rotate
	 * @param radians
	 */
	public void rotate(double radians) {
		int w = picture.getWidth(null);
		int h = picture.getHeight(null);
		coordTransform.rotate(radians, w / 2, h / 2);
	}

	/**
	 * Draws image
	 * @param g
	 * @param picture
	 */
	public void drawImage(Graphics g, Image picture) {
		((Graphics2D) g).drawImage(picture, coordTransform, null);
	}
}

