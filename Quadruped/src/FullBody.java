import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FullBody {
	
	private Image bodyImage;
	private Image legTL, legTR, legBL, legBR;
	private Body body;
	private Legs legs;
	
	public FullBody() {
		
		bodyImage = (new ImageIcon("body.jpg")).getImage();
		legTL = (new ImageIcon("leg1.jpg")).getImage();
		legTR = (new ImageIcon("leg2.jpg")).getImage();
		legBL = (new ImageIcon("leg3.jpg")).getImage();
		legBR = (new ImageIcon("leg4.jpg")).getImage();
		
		body = new Body(100, 100, bodyImage);
		legs = new Legs(legTL, legTR, legBL, legBR);
	}
	
	public void draw(Graphics g) {
		body.draw(g);
	}
}
