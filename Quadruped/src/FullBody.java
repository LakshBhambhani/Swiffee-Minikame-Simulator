import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FullBody {
	private Image bodyImage;
	private Image legTL, legTR, legBL, legBR;
	
	public FullBody() {
		
		bodyImage = (new ImageIcon("body.jpg")).getImage();
		legTL = (new ImageIcon("leg1.jpg")).getImage();
		legTR = (new ImageIcon("leg2.jpg")).getImage();
		legBL = (new ImageIcon("leg3.jpg")).getImage();
		legBR = (new ImageIcon("leg4.jpg")).getImage();
		
		Body body = new Body(bodyImage);
		Legs legs = new Legs(legTL, legTR, legBL, legBR);
	}
	
	public void draw(Graphics g) {
		
	}
}
