import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;

public class shooter extends JFrame {
private static int sleepTime = 1000/30;

public static shooterPanel SP;

	public static void main(String[] args){
		new shooter();
		while(true){
		SP.repaint();
			//wait for 1/fps seconds
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {}
		}
	}
	
	public shooter() {
		this.setTitle("Shooter");
		SP = new shooterPanel();
		
		SP.addKeyListener(SP);
		SP.setFocusable(true);
		
		this.setContentPane(SP);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
	
	//abstract KeyListeners
	//public void keyTyped(KeyEvent e) {}
    //public void keyReleased(KeyEvent e) {}
    //public void keyPressed(KeyEvent e) {
}