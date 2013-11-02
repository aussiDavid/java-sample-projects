import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

 
public class gui { 
static final SimpleDateFormat SDF = new SimpleDateFormat( "EEEE yyyy/MM/dd hh:mm:ss aa zz : zzzzzz" );
	public static void main(String[] args) {

	
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
		final SimpleDateFormat date = new SimpleDateFormat( "yyyy:MM:dd HH:mm:ss.SS" );

        // if wanted user's local timezone
        TimeZone local = TimeZone.getDefault();

        SDF.setTimeZone( local );

        // new Date() gets current date/elapsedTime
        String dateString = SDF.format( new Date() );

        // display the date YYYY-MM-DD, adjusted for timezon and daylight savings.
        out.println( dateString );

        // display TimeZone
        String timeZoneName = local.getDisplayName();
        out.println( timeZoneName );
		
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