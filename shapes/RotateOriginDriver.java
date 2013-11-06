import javax.swing.*;        // For JPanel, etc.
import java.awt.*;           // For Graphics, etc.
import java.awt.event.*;     // For WindowAdapter

class TransformFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 600;
   
    private JPanel mainPanel, buttonPanel, outputPanel;
    private RotateOriginPanel TP = new RotateOriginPanel();
    private JButton transformB = new JButton("Rotate about origin");
    private JTextArea TAoutput = new JTextArea(50,50);
        
    public TransformFrame() {
		super("Rotation about origin Demo"); 
		// stop the program when the window closes.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(DEFAULT_WIDTH ,DEFAULT_HEIGHT);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(TP, "Center");
		
		buttonPanel = new JPanel();
		buttonPanel.add(transformB);
		buttonPanel.add(TAoutput);
		transformB.addActionListener(new buttonListener() );

		outputPanel = new JPanel();
		outputPanel.add(TAoutput);
		
		mainPanel.add(buttonPanel, "South");
		mainPanel.add(outputPanel, "North");
		setContentPane(mainPanel);
		setVisible(true);
    } 
    
    class buttonListener implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
			mainPanel.repaint();
	    }
    }
}

public class RotateOriginDriver {
	public static void main(String[] args) {
		TransformFrame TF = new TransformFrame();
	}
}