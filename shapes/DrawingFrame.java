import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter

/** 
   A very simple frame for holding a {@link JPanel}
   for drawing images on
*/

public class DrawingFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 350;
    public static final int DEFAULT_HEIGHT = 350;
   
    /**
       Constructor initialising DrawingFrame to default width and height.
       @param title The DrawingFrame title
       @param contents The {@link JPanel} contained in the DrawingFrame.
    */
    public DrawingFrame(String title,  JPanel contents){
	super(title); 
	
	// stop the program when the window closes.

	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });
	setSize(DEFAULT_WIDTH ,DEFAULT_HEIGHT); 
	setContentPane(contents);
	  
	setVisible(true);
    } 
}