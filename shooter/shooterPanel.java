import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter
import java.awt.geom.*;      // For Rectangle2D, etc.
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.List;

public class shooterPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
private int Cx = 0;		//Car X
private int Cy = 200;	//Car Y
private int Vx = 5;		//Velocity of car along the x direiction
private int Vy = 5;		//Velocity of car in the y direction
private int X, Y;		//Mouse X, Y

private KeyEvent E;
private ArrayList<KeyEvent> keyEventList = new ArrayList<KeyEvent>();
private boolean keyDown = false;


	public shooterPanel() {
		setBackground(Color.WHITE);
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		//run seperate threads to listen to certain keys
		keyThread rightKey = new keyThread(KeyEvent.VK_RIGHT); 
		keyThread leftKey = new keyThread(KeyEvent.VK_LEFT); 
		//add listeners fromthe thread to this pannel
		this.addKeyListener(rightKey);
		this.addKeyListener(leftKey);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for(int i = 0; i < keyEventList.size(); i++)
			g2d.drawString("" + keyEventList.get(i).getKeyChar(),10,i*10 );
			
		/*move car
		if(keyDown){
			if(E.getKeyCode() == KeyEvent.VK_RIGHT)
				Cx += Vx;
				
			if(E.getKeyCode() == KeyEvent.VK_LEFT)
				Cx -= Vx;
		}
		*/
		g2d.draw(new Rectangle.Double(Cx,Cy,15,10));
		g2d.drawString("(" + X + ", " + Y + ")",X + 10, Y  + 10);

	}
	
	public synchronized void moveCar(int keyCode){
		switch(keyCode){
			case KeyEvent.VK_RIGHT : Cx += Vx;
										break;
			case KeyEvent.VK_LEFT : Cx -= Vx;
										break;
			case KeyEvent.VK_DOWN : Cx += Vx;
										break;
			case KeyEvent.VK_UP : Cx -= Vx;
										break;
		}
	}
	
	public synchronized void moveLeft(){
		Cx -= Vx;
	}
	
	//abstract KeyListeners
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
		keyDown = false;
		/*
		System.out.println("key released");
		if((keyEventList.size()-1) != 0)
			keyEventList.remove(keyEventList.size()-1);
		*/
	}
    public void keyPressed(KeyEvent e) {
		keyDown = true;
		/*
		System.out.println("KeyPressed");
		if(keyEventList.isEmpty()){
			keyEventList.add(e);
			keyEventList.add(e);
			System.out.println("ArrayList is empty, now it conatins : " + e.getKeyChar());
		} else {
			System.out.print("ArrayList is not empty and contains : ");
			for(KeyEvent ev : keyEventList)
				System.out.print(ev.getKeyChar() + " ");
			System.out.println();
			//System.out.println("arraysize : " + keyEventList.size());
			//System.out.println("arraysize : " + keyEventList.get(keyEventList.size()-1).getKeyCode());
			System.out.println(keyEventList.get(keyEventList.size()-1).getKeyChar() + " == " + e.getKeyChar() + " = "  +(keyEventList.get(keyEventList.size()-1).equals(e)));
			
			if(!keyEventList.get(keyEventList.size()-1).equals(e)){
				keyEventList.add(e);
				keyEventList.add(e);
			}
		}
	*/
		E = e;
	//for key modifiers
	///http://download.oracle.com/javase/tutorial/uiswing/examples/events/KeyEventDemoProject/src/events/KeyEventDemo.java
	}
	
	//abstract mouseLIenenters and mouseMotionListeners
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}
}

class keyThread extends Thread implements Runnable, KeyListener{

int keyCode;
boolean keyDown = false;
	
	public keyThread(int KC) {
		super(" " + KeyEvent.getKeyText(KC));
		keyCode = KC;
		start();
	}
	
	public void run(){
		while(true){
			if(keyDown)
				shooter.SP.moveCar(keyCode);
			//wait for 1/fps seconds
			try {
				Thread.sleep(1000/30);
			} catch (Exception e) {}
		}
	}
	
	//abstract KeyListeners
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
		keyDown = false;
	}
    public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == keyCode)
			keyDown = true;
	}
}
