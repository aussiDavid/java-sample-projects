import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 *
 * @author Paul
 */
public class Circle extends JPanel {

// Data members for Circle center and radius
private double centerX, centerY;
private double radius;

// No-argument constructor
Circle() {
    centerX = 200;
    centerY = 200;
    radius = 10;
}

// Full-argument constructor
Circle( double x, double y, double r) {
    centerX = x;
    centerY = y;
    radius = r;
}

// Draw a Circle
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    //Convert to Java2D Object
    Graphics2D g2 = (Graphics2D) g;

    // Create the circle
    Ellipse2D circle = new Ellipse2D.Double();
    circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);

    // Draw it
    g2.draw(circle);
}// end paintComponent

// Get/set data members
public void setCenterX(double x){this.centerX = x;}
public void setCenterY(double y){this.centerY = y;}
public void setRadius(double r){radius = r;}

public double getCenterX(){return centerX;}
public double getCenterY(){return centerY;}
public double getRadius(){return radius;}
}// end class Circle


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Paul
 */
public class DancingCircles extends JFrame{

// Display Dimensions
public static final int DEFAULT_WIDTH = 400;
public static final int DEFAULT_HEIGHT = 400;

// Default constructor
private DancingCircles() {
    setTitle("Dancing Circles");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // Add Circles to JFrame
    Circle myCircle = new Circle(200.0, 200.0, 20.0);
    add(myCircle);          // Add circle to frame
    Circle myCircle2 = new Circle(100.0, 100.0, 30.0);
    add(myCircle2);        // Add circle to frame
}// end DancingCircles

public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable()
    {
        public void run()
        {
            DancingCircles dc = new DancingCircles();
            dc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dc.setVisible(true);
        }
    });

 }// end main
}