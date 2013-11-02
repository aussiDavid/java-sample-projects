import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;


public class test extends JFrame implements MouseListener, MouseMotionListener{
	private tangentDrawer TD = new tangentDrawer();
	private JLabel status;
	private int X = 0;
	private int Y = 0;
	private int d = 100;
	
	public static void main(String[] args){
		new test();
	}
	
	private test() {
		this.setTitle("Tangant Drawer");
		//Create Lables
		status = new JLabel("*move mouse into the frame*");
		//Create Panels
		JPanel mainP = new JPanel();
		//Layout main panel
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.add(TD);
		mainP.add(status);
		
		//add acioListeners
		TD.addMouseMotionListener(this);
		TD.addMouseListener(this);
		
		this.setContentPane(mainP);
		//Set size and minimum size
		this.setSize(510,510);
		this.setMinimumSize(new Dimension(510,510));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
	//abstract mouseListeners and mouseMotionListener meathods
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		status.setText("(" + e.getX() + ", " + e.getY() + ")");
	}
}
    
class tangentDrawer extends JPanel implements MouseListener, MouseMotionListener{
private int d = 200;

private Line2D.Double line;
private Line2D.Double cross1;
private Line2D.Double cross2;

private Line2D.Double slopeLine;
private Line2D.Double previousSlopeLine;
private int X,Y;

private double slope = 0;

private final int k = 600;
private final double LARGECONSTANT = 1000;

	public tangentDrawer(){
		setBackground(Color.WHITE);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		//g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(10)); // make the pen 3 pixels wide.
		
		for(int i = 5; i < 200; i++){
			if(i%2 == 0){
				g2d.setColor(Color.RED);
				//g2d.draw(new Line2D.Double(5,i,100,i));
				g2d.draw(new Line2D.Double(5,i,5,i++));
			} else {
				g2d.setColor(Color.BLACK);
				g2d.draw(new Line2D.Double(5,i,5,i++));
			}
		}
		//g2d.draw(new Line2D.Double(5,5,5,200));
		g2d.draw(new Line2D.Double(6,200,6,450));
    }

	//abstract mouseLIenenters and mouseMotionListeners
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		//get mouse coordinates
		X = e.getX();
		Y = e.getY();
		//repaint the panel
		repaint();
	}
	
	
	
}