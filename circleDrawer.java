import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.JComponent;
import java.util.*;

/*
A component that draws two rectangles.
*/
public class circleDrawer extends JComponent
{
	public void paintComponent(Graphics g)
	{
	// RecoverGraphics2D
		Graphics2D g2 = (Graphics2D) g;

		//create points
		int r = 285;
		int[] f = new int[3*r];
		int[] X = new int[3*r];
		for(int x = 0; x < 3*r; x++){
			f[x] = -(int)Math.round(Math.sqrt(Math.pow(r,2) - Math.pow(x - r, 2))) + r;
			X[x] = x;
		}
		// Construct a rectangle and draw it
		Polygon circle = new Polygon(X,f,2*r);
		g2.draw(circle);
	}
}