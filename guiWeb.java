import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
 
public class guiWeb  extends JApplet{ 
	public static void user() {	
	JFrame frame = new JFrame("Frame");
    final JTextField lo = new JTextField(10);
	final JTextField la = new JTextField(10);
	JLabel jLabel1 = new JLabel("Longitude : ");
	JLabel jLabel2 = new JLabel("Latatude : ");	
    JButton button = new JButton("Submit");
	
	
	ButtonGroup btnGroup = new ButtonGroup();
	JRadioButton radioBtn1 = new JRadioButton("Plus");
	JRadioButton radioBtn2 = new JRadioButton("Negative");
	
	btnGroup.add(radioBtn1);
	btnGroup.add(radioBtn2);
	
	JPanel radioPanel = new JPanel();
	radioPanel.setLayout(new GridLayout(3, 1));
	radioPanel.add(radioBtn1);
	radioPanel.add(radioBtn2);

	radioBtn1.addActionListener(new ActionListener() {
	   
	public void actionPerformed(ActionEvent e)
		{
			//Execute when button is pressed
			System.out.println("plus");
		}
	});
	
	radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Polarity"));
		   
    frame.add(radioPanel);
	
	button.addActionListener(new ActionListener() {
	   
	public void actionPerformed(ActionEvent e)
		{
			//Execute when button is pressed
			try {
			System.out.println(Integer.parseInt("a"));
			}
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null,"Carnt parse letters as integrs jack ass");
				return;
			}			
			
			System.out.println("button pressed");
		}
	});
	
    frame.add(jLabel1);
	frame.add(lo);
	frame.add(jLabel2);
    frame.add(la);
	frame.add(button); 
	
	frame.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        lo.requestFocusInWindow();
    }
});
	
	frame.setLayout(new FlowLayout());
    
	frame.setSize(200,300);
    
	frame.setVisible(true);
	
    //terminate programe when window closes
	frame.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		System.exit(0);
		}
    });
	}  
}