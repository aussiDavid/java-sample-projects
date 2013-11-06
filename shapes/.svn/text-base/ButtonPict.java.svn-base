import java.awt.*;           // For Graphics, Color etc.
import java.awt.geom.*;      // For Rectangle2D, etc.


/** 
    A class that draws a button shape on the {@link Graphics2D}
    surface given to its draw method.
*/

public class ButtonPict{
    
    private double CENTRE = 0.0; // 150.0;
    private double B_SIZE = 0.0; // 200.0;
    private double HOLE_SIZE = 0.0; // B_SIZE / 4;

    private Ellipse2D.Double outer, left, right  = null;
        
    public ButtonPict (int centre, int size) {
	    
	    CENTRE = centre;
	    B_SIZE = size;
	    HOLE_SIZE = B_SIZE / 4;
	    
	    outer = new Ellipse2D.Double(CENTRE-(B_SIZE/2.0),CENTRE-(B_SIZE/2.0),B_SIZE,B_SIZE);
		
	    left = new Ellipse2D.Double(CENTRE-(HOLE_SIZE*1.5), CENTRE-(HOLE_SIZE/2.0),HOLE_SIZE,HOLE_SIZE);
	    
	    right = new Ellipse2D.Double(CENTRE+(HOLE_SIZE/2.0), CENTRE-(HOLE_SIZE/2.0),HOLE_SIZE,HOLE_SIZE);
    }
    
     /**
       Draws a button on the graphics surface given to it.
       @param g2d The {@link Graphics2D} surface to draw on.
    */
    public void draw(Graphics2D g2d){
	    Color tan = new Color(230,200,100);
	    g2d.setColor(tan);
	    g2d.draw(outer);
	    g2d.fill(outer);
	    g2d.setColor(Color.WHITE);
	    g2d.draw(left);
	    g2d.fill(left);
	    g2d.draw(right);
	    g2d.fill(right);
    }
}
	    

    