import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;
import java.text.*;
import java.util.Random;
import java.util.Arrays;
import java.util.Hashtable;

public class tangent2 extends JFrame implements MouseListener, MouseMotionListener, ChangeListener {
	private static tangentDrawer TD = new tangentDrawer();
	private JLabel status, fpsL, speedL, targetSizeL, radiusL, axisL;
	private JSlider FPSS,speedS, targetSizeS, radiusS,axisS;
	
	private static int fps = 30;
	private static int sleepTime = 1000/fps;
	
	private DecimalFormat dFormat = new DecimalFormat("00.00");
	
	public static void main(String[] args){
		new tangent2();
		while(true){
		TD.repaint();
			//wait for 1/fps seconds
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {}
		}
	}
	
	
	private tangent2() {
		this.setTitle("Tangant Drawer");
		//Create Lables
		status = new JLabel("*move mouse into the frame*");
		speedL = new JLabel("Speed : x" + TD.getSpeed());
		fpsL = new JLabel("FPS : " + fps);
		targetSizeL = new JLabel("Target Radius : " + TD.getTargetSize());
		radiusL = new JLabel("Circle Radius : " + TD.getRadius());
		axisL = new JLabel("Axis Width: " + TD.getAxisWidth());
		//Create sliders
		FPSS = new JSlider(JSlider.HORIZONTAL,1, 1001, fps);
		speedS = new JSlider(JSlider.HORIZONTAL,0, 100, TD.getSpeed());
		targetSizeS = new JSlider(JSlider.HORIZONTAL,0, 100 , TD.getTargetSize());
		radiusS = new JSlider(JSlider.HORIZONTAL,11,200 , TD.getRadius());
		axisS = new JSlider(JSlider.HORIZONTAL,0,10,TD.getAxisWidth());
		//Create Panels
		JPanel mainP = new JPanel();
		JPanel labelP = new JPanel();
		JPanel fpsP = new JPanel();
		JPanel speedP = new JPanel();
		JPanel targetSizeP = new JPanel();
		JPanel radiusP = new JPanel();
		JPanel axisP = new JPanel();
		//Layout label panel
		labelP.setLayout(new BoxLayout(labelP, BoxLayout.X_AXIS));
		labelP.add(Box.createHorizontalGlue());
		labelP.add(status);
		labelP.add(Box.createHorizontalGlue());
		//Layout fps panel
		fpsP.setLayout(new BoxLayout(fpsP, BoxLayout.X_AXIS));
		fpsP.add(fpsL);
		fpsP.add(FPSS);
		//Layout speed panel
		speedP.setLayout(new BoxLayout(speedP, BoxLayout.X_AXIS));
		speedP.add(speedL);
		speedP.add(speedS);
		//Layout targetSize panel
		targetSizeP.setLayout(new BoxLayout(targetSizeP, BoxLayout.X_AXIS));
		targetSizeP.add(targetSizeL);
		targetSizeP.add(targetSizeS);
		//Layout radius panel
		radiusP.setLayout(new BoxLayout(radiusP, BoxLayout.X_AXIS));
		radiusP.add(radiusL);
		radiusP.add(radiusS);
		//Layout axis panel
		axisP.setLayout(new BoxLayout(axisP, BoxLayout.X_AXIS));
		axisP.add(axisL);
		axisP.add(axisS);
		
		//Layout main panel
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.add(TD);
		mainP.add(labelP);
		mainP.add(Box.createVerticalStrut(5));
		mainP.add(fpsP);
		mainP.add(speedP);
		mainP.add(targetSizeP);
		mainP.add(radiusP);
		mainP.add(axisP);
	
		
		//change component status
		//Labels and ticks for speed
		speedS.setMajorTickSpacing(20);
		speedS.setMinorTickSpacing(5);
		speedS.setPaintTicks(true);
		speedS.setPaintLabels(true);
		//Labels and ticks for FPS
		FPSS.setMajorTickSpacing(200);
		FPSS.setMinorTickSpacing(20);
		FPSS.setPaintTicks(true);
		FPSS.setPaintLabels(true);
		//Labels and ticks for TargetSize
		targetSizeS.setMajorTickSpacing(10);
		targetSizeS.setMinorTickSpacing(5);
		targetSizeS.setPaintTicks(true);
		targetSizeS.setPaintLabels(true);
		//Labels and ticks for radius
		radiusS.setMajorTickSpacing(20);
		radiusS.setMinorTickSpacing(10);
		radiusS.setPaintTicks(true);
		radiusS.setPaintLabels(true);
		//Labels and ticks for radius
		axisS.setMajorTickSpacing(2);
		axisS.setMinorTickSpacing(1);
		axisS.setPaintTicks(true);
		axisS.setPaintLabels(true);
		
		
		//add acioListeners
		TD.addMouseMotionListener(this);
		TD.addMouseListener(this);
		FPSS.addChangeListener(this);
		speedS.addChangeListener(this);
		targetSizeS.addChangeListener(this);
		radiusS.addChangeListener(this);
		axisS.addChangeListener(this);
		
		this.setContentPane(mainP);
		
		//Set size and minimum size
		this.setSize(450,700);
		this.setMinimumSize(new Dimension(410,700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
	//abstract mouseListeners and mouseMotionListener meathods
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {
		status.setText("(" + e.getX() + ", " + e.getY() + ") Angle: " + dFormat.format(TD.getTheata()));
	}
	public void mouseMoved(MouseEvent e) {
		status.setText("(" + e.getX() + ", " + e.getY() + ") Angle: " + dFormat.format(TD.getTheata()));
	}
	
	public void stateChanged(ChangeEvent e){ 
		JSlider source = (JSlider)e.getSource();
		if (source == FPSS) {
			fps = (int)source.getValue();
			if (fps == 1001){
				sleepTime = 0;
				fpsL.setText("FPS : \u221E");
			} else {
				sleepTime = 1000/fps;
				fpsL.setText("FPS : " + fps);
			}
		}
		
		if(source == speedS){
			TD.setSpeed((int)source.getValue());
			speedL.setText("Speed : x" + (int)source.getValue());
		}
		
		if(source == targetSizeS){
			TD.setTargetSize((int)source.getValue());
			targetSizeL.setText("Radius of Target : " + (int)source.getValue());
			radiusS.setMinimum((int)source.getValue()+1);
		}

		if(source == radiusS){
			TD.setRadius((int)source.getValue());
			radiusL.setText("Radius of Circle : " + (int)source.getValue());
		}
		
		if(source == axisS){
			TD.setAxisWidth((int)source.getValue());
			axisL.setText("Axis Width : " + (int)source.getValue());
		}
	}
}
    
class tangentDrawer extends JPanel implements MouseListener, MouseMotionListener{
private int radius = 200;
private double theata;
private double alpha;


private double PX = 200;	//target X
private double PY = 11;		//target Y
private int X,Y;			//mouse X,Y
private double x,y;			//Circle x,y
private int Dx,Dy;			//dragLine x,y
private int Cx = radius;	//cartesion x
private int Cy = radius;	//cartesion y
private int axisWidth = 3;	//axis line width in pixles
private int targetRadius = 10;	//target radius

private Random generator = new Random();

private int Xd,Yd;

private double speed = 1;
private double Vx = 1;	//Horizontal velocity
private double Vy = 1;	//Vertical velocity


private final double LARGECONSTANT = 1000;

private double K = PX;
private double L = PY;
private double delta = Math.PI/2;
private double beta = 0;

private boolean mousePressed = false;
private boolean axisDrag = false;
private Line2D.Double dragLine;

	public tangentDrawer(){
		setBackground(Color.WHITE);
	this.addMouseMotionListener(this);
	this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
	
		//calculate theata
		x = X-radius;
		y = radius-Y;
		if(x == 0) {
			if(y >= 0)
				theata = Math.atan(-LARGECONSTANT);
			else
				theata = Math.atan(LARGECONSTANT);
		} else
			theata = Math.atan(y/x);
		
		//draw lines
		if(X>radius) {
			g2d.draw(new Line2D.Double(radius,radius,radius+radius*Math.cos(theata),radius-radius*Math.sin(theata)));	//(radius,radius) -> mouse with length radius.
		} else {
			if(y >= 0)
				theata = theata+Math.PI;
			else
				theata = theata-Math.PI;
			g2d.draw(new Line2D.Double(radius,radius,radius+radius*Math.cos(theata),radius-radius*Math.sin(theata)));	//(radius,radius) -> mouse with length radius.
		}
		
		//draw circle on the circle
		g2d.draw(new Ellipse2D.Double(radius+radius*Math.cos(theata)-10,radius-radius*Math.sin(theata)-10,2*10,2*10));
		
		//arbitray point
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(3));
		g2d.draw(new Ellipse2D.Double(PX-targetRadius,PY-targetRadius,2*targetRadius,2*targetRadius));
		
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.RED);
		g2d.draw(new Ellipse2D.Double(PX-(int)targetRadius/2,PY-(int)targetRadius/2,targetRadius,targetRadius));
		
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLACK);

		//draw circle
		Ellipse2D.Double circle = new Ellipse2D.Double(0,0,2*radius,2*radius);
		g2d.draw(circle);
		
		/*//draw line whist mouse dragging
		if(mousePressed)
			g2d.draw(new Line2D.Double(Dx,Dy,X,Y));
		*/
		g2d.setStroke(new BasicStroke(axisWidth));
		//draw axis
		if(axisDrag)
			g2d.drawString("(" + x + ", "+ y + ")",X + 10,Y + 15);

		if(axisWidth != 0){
			g2d.draw(new Line2D.Double(Cx,-LARGECONSTANT,Cx,LARGECONSTANT));
			g2d.draw(new Line2D.Double(-LARGECONSTANT,Cy,LARGECONSTANT,Cy));
		}
		g2d.setStroke(new BasicStroke(1));
		
		//from circle to arbitary point
		if(Math.sqrt(Math.pow(PX-radius,2) + Math.pow(PY-radius,2)) >= radius-targetRadius){
			//calculate arbitary points angle, alpha
			alpha = Math.toRadians(generator.nextDouble()*90 - 45);
			
			//use delta to make PX PY length of 190 when wall is breached
		
			//System.out.println("Wall hit:");
			
			if((PX-radius)/(radius-targetRadius) > 1){
				//System.out.println("WALL BREACH!");
				//System.out.println("old P(x,y)/(radius-" + targetRadius + ") : (" + (PX-radius)/(radius-targetRadius) + ", " + (PY-radius)/(radius-targetRadius) +")");
				PX = (radius-targetRadius) + radius;
			}
			
			if((PX-radius)/(radius-targetRadius) < -1){
				//System.out.println("WALL BREACH!");
				//System.out.println("old P(x,y)/(radius-"+targetRadius+") : (" + (PX-radius)/(radius-targetRadius) + ", " + (PY-radius)/(radius-targetRadius) +")");
				PX = targetRadius;
			}

			if((PY-radius) >= 0)
				delta = Math.acos((PX-radius)/(radius-targetRadius));
			else
				delta = -Math.acos((PX-radius)/(radius-targetRadius));
			
			//System.out.println("P(x,y) : (" + (PX-radius) + ", " + (PY-radius) +")");
			//System.out.println("P(x,y)/(radius-"+targetRadius+") : (" + (PX-radius)/(radius-targetRadius) + ", " + (PY-radius)/(radius-targetRadius) +")");
			//System.out.println("P(delta,r) : (" + Math.toDegrees(delta) + ", " + (int)Math.sqrt(Math.pow(PX-radius,2) + Math.pow(PY-radius,2)) +")");
			delta = -delta + Math.PI + alpha;
		}
		if(PX >= radius){
			if(PY <= radius)
				beta = Math.atan(-(PY-radius)/(PX-radius));
			else
				beta = Math.atan(-(PY-radius)/(PX-radius)) + 2*Math.PI;
		}else
			beta = Math.atan(-(PY-radius)/(PX-radius)) + Math.PI;
			
		g2d.drawArc(radius-20,radius-20,40,40,0,(int)Math.toDegrees(beta));
		g2d.drawString(""+(int)Math.toDegrees(beta), radius+ 50,radius + 50);
		g2d.draw(new Line2D.Double(radius,radius,PX,PY));		//(radius,radius) -> (PX,PY)
		
		Vx = Math.cos(-delta);
		Vy = Math.sin(-delta);
		
		PX += speed*Vx;
		PY += speed*Vy;
	}
		
	public double getTheata(){
		return Math.toDegrees(theata);
	}
	
	public int getSpeed(){
		return (int)speed;
	}
	
	public void setSpeed(int s){
		speed = s;
	}	
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int r){
		radius = r;
	}
	
	public int getTargetSize(){
		return targetRadius;
	}
	
	public void setTargetSize(int tr){
		targetRadius = tr;
	}	
	
	public int getAxisWidth(){
		return axisWidth;
	}
	
	public void setAxisWidth(int aw){
		axisWidth = aw;
	}
	
	//abstract mouseLIenenters and mouseMotionListeners
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {
		mousePressed = false;
		axisDrag = false;
	}
	public void mousePressed(MouseEvent e) {
		//get mouse coordinates
		mousePressed = true;
		if((X >= Cx - axisWidth/2 && X <= Cx + axisWidth/2) || (Y >= Cy - axisWidth/2 && Y <= Cy + axisWidth/2)){
			axisDrag = true;
			Xd = X - Cx;
			Yd = Y - Cy;
		}
		Dx = X;
		Dy = Y;
	}
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		axisDrag = false;
	}
	public void mouseDragged(MouseEvent e) {
		//get mouse coordinates
		X = e.getX();
		Y = e.getY();
		if(axisDrag){
			Cx = X - Xd;
			Cy = Y - Yd;
		}
	}
	public void mouseMoved(MouseEvent e) {
		//get mouse coordinates
		X = e.getX();
		Y = e.getY();
	}
}