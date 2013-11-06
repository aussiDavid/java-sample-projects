import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, Color etc.
import java.awt.geom.*;      // For Rectangle2D, etc.
/**
   A JPanel that draws a filled red rectangle.
*/

public class ShapePanel extends JPanel{
    // declare a shape
    private Line2D.Double line = new Line2D.Double(150,150,20,30);
    private Rectangle2D.Double rect = new Rectangle2D.Double(10, 10, 250, 200);
    private Ellipse2D.Double circ = new Ellipse2D.Double(30,40,100,100);
    
    /** 
	Constructor initialising background colour
    */
    public ShapePanel(){
	setBackground(Color.WHITE);
    }

    /**
       Paints the graphical content of the JPanel.
       Called automatically by window monitoring software in Java
       or manually by the programmer via a call to the <code>repaint()</code>
       method of this panel.
       @param g The {@link Graphics} surface to draw on.
    */

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.draw(rect);
		
		g2d.setColor(Color.RED);
		//g2d.setStroke(new BasicStroke(10)); // make the pen 10 pixels wide.
		g2d.draw(circle);
    }
}