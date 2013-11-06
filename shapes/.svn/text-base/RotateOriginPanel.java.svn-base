import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, Color etc.
import java.awt.geom.*;      // For Rectangle2D, etc.
/**
   A JPanel that draws two buttons
   Each time redraw is called, coordinates are rotated about origin
*/

public class RotateOriginPanel extends JPanel{
	private double rot = 0;
	private double diameter = 200;
	private Ellipse2D.Double circle = new Ellipse2D.Double(20,20,diameter,diameter);
    
	/*
    public  static final int MAX_OFFSET = 100;
	private ButtonPict myButtonPict1 = new ButtonPict(100, 50);
    private ButtonPict myButtonPict2 = new ButtonPict(300, 50);
    */
    
    /** 
	Constructor initialising background colour
    */
    public RotateOriginPanel(){
		setSize(200, 200);
		setBackground(Color.WHITE);
    }

    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(rot);
		g2d.draw(circle);
		rot += 0.05;
    }
}