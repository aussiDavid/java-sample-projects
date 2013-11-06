/**Class AppletThread is the GUI class that implements ActionListener
*to register user actions. Also, since it make use of swing components it extends JApplet instead of Applet.
*JApplet is a subclass to Applet.
*Internetprogrammering 1 - Course
*@author Martin Carlsson
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AppletThread extends JApplet implements ActionListener {
    private JButton jb1, jb2;
    private JTextArea jTa;
    private AppletThread aT=this;
    private String deactivate1 ="Deactivate Thread 1";
    private String deactivate2 ="Deactivate Thread 2";    
    private String activate1 ="Activate Thread 1";
    private String activate2 ="Activate Thread 2";
    private ThreadOne t1;
    private ThreadTwo t2;
    private Thread thread;
    
    public void init () {
        // Container to put all graphical components in	
        Container con=getContentPane();
        // North panel with a button
        JPanel north=new JPanel();
        jb1 = new JButton(activate1);
        north.add(jb1);
        con.add(north,BorderLayout.NORTH);
        // Sount panel with a button
        JPanel south=new JPanel();
        jb2 = new JButton (activate2);
        south.add(jb2);
        con.add(south,BorderLayout.SOUTH);
        jb1.addActionListener(this); // Adds this class as a listener for button 1
        jb2.addActionListener(this); // Same for button 2
        // Middle text area
        jTa=new JTextArea();
        JScrollPane scrollPane = new JScrollPane(jTa);
        scrollPane.setHorizontalScrollBarPolicy
        (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        jTa.setCaretPosition(jTa.getText().length()); 
        con.add(scrollPane,BorderLayout.CENTER);
        
        // Creates the two thread classes and starts them
        t1 = new ThreadOne(this);// Creates and instance of ThreadOne that extends class Thread...
        t1.start();// ...and starts that thread.
        t2 = new ThreadTwo(this);//Createst an instance of ThreadTwo that implements the Runnable Interface...
        thread = new Thread(t2);//...and uses the instance as a constructur argument when creating a new thread...
        thread.start();	//...and starts that thread.
    }
        
    // Listens to when a user presses a button
    public void actionPerformed(ActionEvent aE) {
        if(aE.getSource()==jb1) {
            if(jb1.getText().equals(activate1)) {
                jb1.setText(deactivate1);
                t1.setLooping(true);
                
            }
            else if(jb1.getText().equals(deactivate1)) {
                jb1.setText(activate1);
                t1.setLooping(false);
            }
        } 
        else if(aE.getSource()==jb2) {
            if(jb2.getText().equals(activate2)) {
                jb2.setText(deactivate2);
                t2.setLooping(true);
            }
            else if(jb2.getText().equals(deactivate2)) {
                jb2.setText(activate2);
                t2.setLooping(false);
            }
            
        } 
    } 
    
    /*Used by the threaded classes for callbacks, i.e. to set the text in the middle area*/
    public synchronized void setThreadText(String s) { 
        jTa.append(s);
    } 
} // End class AppletThread	
            
    
            
        
        

