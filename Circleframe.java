import javax.swing.JFrame;

public class Circleframe
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setTitle("circle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		circleDrawer component = new circleDrawer();
		frame.add(component);
		
		frame.setVisible(true);
	}
}