import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FullBody {
	
	private Image bodyImage;
	private Image legTL, legTR, legBL, legBR;
	private Body body;
	private Legs leg1, leg2, leg3, leg4;
	
	public FullBody() {
		
		bodyImage = (new ImageIcon("body2.jpg")).getImage();
		legTL = (new ImageIcon("leg1.jpg")).getImage();
		legTR = (new ImageIcon("leg2.jpg")).getImage();
		legBL = (new ImageIcon("leg3.jpg")).getImage();
		legBR = (new ImageIcon("leg4.jpg")).getImage();
		
		body = new Body(500, 300, bodyImage);
//		leg1 = new Legs(200, 200, legTL);
	}
	
	public void draw(Graphics g) {
		body.draw(g);
//		leg1.draw(g);
	}
}
