import javax.swing.*;        // For JPanel, etc.
import java.awt.*;       // For Graphics, Color etc.

/** 
    Driver program to set up a DrawingFrame with a RectPanel object in 
    it
*/

public class ShapePanelDriver{
    
    public static void main(String [] args){
	ShapePanel myPanel = new ShapePanel();
	DrawingFrame myFrame = new DrawingFrame("Circle",myPanel);
    }
}
    