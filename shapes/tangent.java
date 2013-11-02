import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;
import java.text.*;

public class tangent extends JFrame implements MouseListener, MouseMotionListener{
	private tangentDrawer TD = new tangentDrawer();
	private JLabel status;
	private int X = 0;
	private int Y = 0;
	private int d = 100;

	private DecimalFormat dFormat = new DecimalFormat("00.00");
	
	public static void main(String[] args){
		new tangent();
	}
	
	private tangent() {
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
		status.setText("(" + e.getX() + ", " + e.getY() + ") Angle: " + dFormat.format(TD.getTheata()));
	}
}
    
class tangentDrawer extends JPanel implements MouseListener, MouseMotionListener{
private int d = 200;
private double theata = 200;

private Line2D.Double Y1;
private Line2D.Double Y2;
private Line2D.Double line;
private Line2D.Double cross1;
private Line2D.Double cross2;

private Line2D.Double slopeLine;
private Line2D.Double previousSlopeLine;
private Line2D.Double angleLine;
private Line2D.Double previousAngleLine;
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
		
		slopeLine = new Line2D.Double(d,d,k*X-(k-1)*d,k*Y-(k-1)*d);
		
		
		boolean drawAngle = true;
		int ctr = 0;
		//g2d.setColor(Color.RED);
		//g2d.setStroke(new BasicStroke(3)); // make the pen 3 pixels wide.
		

		//calculate & Draw cricle from lots of straight lines
		for(int i = 1; i <= 2*d; i++){
			//draw line segment of circle
			Y1 = new Line2D.Double(i-1,fUpper(i-1),i,fUpper(i));
			Y2 = new Line2D.Double(i-1,fLower(i-1),i,fLower(i));
			
			g2d.draw(Y1);
			g2d.draw(Y2);
			
			
			angleLine = new Line2D.Double(i-1,fAngle(-d+50+i-1),i,fAngle(-d+50+i));
			
			if(angleLine.intersectsLine(slopeLine) || X == d)
				drawAngle = false;
				
			if(i > d-50 && i <= d+50 && drawAngle){
				angleLine = new Line2D.Double(i-1,fAngle(-d+50+i-1),i,fAngle(-d+50+i));
			}
			//draw cross on the circle
			if(Y1.intersectsLine(slopeLine)){
				System.out.print("[X]");
				g2d.draw(new Line2D.Double(i-5,fUpper(i)+5,i+5,fUpper(i)-5));	
				g2d.draw(new Line2D.Double(i-5,fUpper(i)-5,i+5,fUpper(i)+5));
				//draw triangle				
				g2d.draw(new Line2D.Double(i,fUpper(i),i,d));
				g2d.draw(new Line2D.Double(i,d,d,d));
				//calculate theata
				theata = Math.atan((d-fUpper(i))/(d-i));
				//draw labels
				g2d.drawString("X = " + Math.abs(d-i),(d+i)/2-15,d+10);
				g2d.drawString("Y = " + Math.abs(d-fUpper(i)),i,(d+Math.round(fUpper(i)))/2);
				if(X == d)
					g2d.drawString("Theata = " + (int)getTheata(),d+10,d);
				else
					g2d.drawString("Theata = " + (int)getTheata(),d+10,d);
				/*
				if(X > d)
					g2d.drawString("Theata = " + (int)getTheata(),d+(int)(50*Math.cos(theata)),d-(int)(50*Math.sin(theata)));
				else
					g2d.drawString("Theata = " + (int)getTheata(),d-(int)(50*Math.cos(theata/2)),d-(int)(50*Math.sin(theata)));
				*/
				
				//draw arc
				if(X == d)
					g2d.drawArc(d-50,d-50,100,100,0,90); //90 degrees
					
				if(X > d)
					g2d.drawArc(d-50,d-50,100,100,0,-(int)getTheata()); //1st quadrant
				else
					g2d.drawArc(d-50,d-50,100,100,0,180-(int)getTheata()); //2nd quadrant
				
			} else { if(Y2.intersectsLine(slopeLine)){
				System.out.print("[Y]");
				g2d.draw(new Line2D.Double(i-5,fLower(i)+5,i+5,fLower(i)-5));	
				g2d.draw(new Line2D.Double(i-5,fLower(i)-5,i+5,fLower(i)+5));	
				//draw triangle				
				g2d.draw(new Line2D.Double(i,fLower(i),i,d));
				g2d.draw(new Line2D.Double(i,d,d,d));
				//calculate theata
				theata = Math.atan(Math.abs(d-fLower(i))/Math.abs(d-i));
				//draw labels
				g2d.drawString("X = " + Math.abs(d-i),(d+i)/2-15,d+10);
				g2d.drawString("Y = " + Math.abs(d-fLower(i)),i,(d+Math.round(fLower(i)))/2);
				g2d.drawString("Theata = " + (int)getTheata(),d+10,d);
				/*
				if(X > d)
					g2d.drawString("Theata = " + (int)getTheata(),d+(int)(50*Math.cos(theata)),d-(int)(50*Math.sin(theata)));
				else
					g2d.drawString("Theata = " + (int)getTheata(),d-(int)(50*Math.cos(theata/2)),d-(int)(50*Math.sin(theata)));
				*/
				//draw arc
				if(X == d)
					g2d.drawArc(d-50,d-50,100,100,0,270); //2700 degrees
				
				if(X > d)
					g2d.drawArc(d-50,d-50,100,100,0,360-(int)getTheata());
				else
					g2d.drawArc(d-50,d-50,100,100,0,180+(int)getTheata());						
				}
			}
		}
		
		if(X == d && Y == d)
			g2d.draw(previousSlopeLine);
		else
			g2d.draw(slopeLine);
		
		if(X == d)
			g2d.draw(previousAngleLine);
		else
			g2d.draw(angleLine);
			
		previousSlopeLine = slopeLine;
		previousAngleLine = angleLine;
		
		//Ellipse2D.Double circle = new Ellipse2D.Double(0,0,d,d);
		//g2d.draw(circle);
		
		System.out.println();
	}
	
	public double fAngle(int x) {
		return Math.round(d-Math.sqrt(Math.pow(50,2) - Math.pow(x - 50,2)));
		//return Math.pow(x,2);
	}

	public double fUpper(int x) {
		return Math.round(d-Math.sqrt(Math.pow(d,2) - Math.pow(x - d,2)));
		//return Math.pow(x,2);
	}
	
	public double fLower(int x) {
		return Math.round(d+Math.sqrt(Math.pow(d,2) - Math.pow(x - d,2)));
		//return Math.pow(x,2);
	}
	
	
	public double getLineSlope(){
		return slope;
	}	
	
	public double getTheata(){
		return Math.toDegrees(theata);
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