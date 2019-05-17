import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/*
 * Basically the coordinate system. The animations are dependent on this class
 */
public class CoordinateSystem
{
  private Image picture;
  private AffineTransform coordTransform;
  private Simulator simulator;

   //  0 degrees points east
  public CoordinateSystem(int x, int y, Image pic) // constructor
  {
    picture = pic;
    coordTransform = new AffineTransform();

    int w = picture.getWidth(null) / 2;
    int h = picture.getHeight(null) / 2;
    coordTransform.translate(x - w, y - h);
  }

  public void shift(double dx, double dy) // shift
  {
    coordTransform.translate(dx, dy);
  }

  public void rotate(double radians) // rotate
  {
    int w = picture.getWidth(null);
    int h = picture.getHeight(null);
    coordTransform.rotate(radians, w/2, h/2);
  }

  public void drawImage(Graphics g, Image picture) // draws image
  {
    ((Graphics2D)g).drawImage(picture, coordTransform, null);
  }
}

