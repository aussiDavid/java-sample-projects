import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter

public class tangent extends JPanel{
	public void main(String[] args){
		new tangant();
	}
	
	private tangent() {
		this.setTitle("Tangant Drawer");
		
		
		
		this.setContentPane(new tangetDrawer());
		
		//Set size and minimum size
		this.setSize(500,600);
		this.setMinimumSize(new Dimension(500,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
}

public class tangentDrawer{
	public tangentDrawer(){
		setSize(200, 200);
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//g2d.draw(circle);
    }
}