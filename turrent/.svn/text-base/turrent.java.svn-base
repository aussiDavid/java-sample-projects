import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;


public class turrent extends JFrame implements MouseListener, MouseMotionListener{
	private turrentDrawer TD = new tangentDrawer();
	private JLabel status;
	private int X = 0;
	private int Y = 0;
	
	public static void main(String[] args){
		new turrent();
	}
	
	private turrent() {
		this.setTitle("Turrent");
		//Create Lables
		status = new JLabel("*move mouse into the frame, click to rotate gun*");
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
		status.setText("(" + e.getX() + ", " + e.getY() + ") slope: " + TD.getLineSlope());
	}
}
    
class turentDrawer extends JPanel implements MouseListener, MouseMotionListener{
private int d = 200;
private double[] y1 = new double[600];
private double[] y2 = new double[600];
private Line2D.Double line;
private int X,Y;
private double slope = 0;

private final double LARGECONSTANT = 1000;

	public turrentDrawer(){
		setBackground(Color.WHITE);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		//if(d >= 250)
		//	d = 10;
		//d += 2;
		
		if(line != null){
			g2d.draw(line);
		}
		
		Ellipse2D.Double circle = new Ellipse2D.Double(0,0,d,d);
		
		//g2d.setColor(Color.RED);
		//g2d.setStroke(new BasicStroke(3)); // make the pen 3 pixels wide.
		y1[0] = d;
		y2[0] = d;
		//calculate & Draw cricle from lots of straight lines
		for(int i = 1; i <= 2*d; i++){
			y1[i] = d-Math.sqrt(Math.pow(d,2) - Math.pow(i - d,2));
			y2[i] = d+Math.sqrt(Math.pow(d,2) - Math.pow(i - d,2));
				
				Line2D.Double Y1 = new Line2D.Double(i-1,y1[i-1],i,y1[i]);
			
			g2d.draw(Y1);
			g2d.draw(new Line2D.Double(i-1,y2[i-1],i,y2[i]));
		}
		g2d.draw(circle);
    }
	
	public double getLineSlope(){
		return slope;
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
		//generate line from cener of the circle to the mouse
		line = new Line2D.Double(d,d,X,Y);
		//calculate slope
		rise = d - Y;
		run = d - X;
		//check if line is vertical. If so, Make the slope very large
		if(run == 0)
			slope = LARGECONSTANT;
		else
			slope = rise/run;
		//repaint the panel
		repaint();
	}
	
}