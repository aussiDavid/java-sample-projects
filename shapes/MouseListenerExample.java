// MouseListener MouseMotionListener Example
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseListenerExample extends JFrame implements MouseListener, MouseMotionListener {

   JLabel label = new JLabel("Move the mouse...");

   public MouseListenerExample() {
      super("Mousing around");

      Container cp = getContentPane();
      cp.setLayout(new FlowLayout(FlowLayout.CENTER));
      cp.add(label);

      setSize(300, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      cp.addMouseListener(this);
      cp.addMouseMotionListener(this);
   }

   public void mouseMoved(MouseEvent evt) {
      int x = evt.getX(), y = evt.getY();
      System.out.println("x="+x+" y="+y);
   }
   public void mouseDragged(MouseEvent evt) {label.setText("dragged");}

   public void mouseClicked(MouseEvent evt) {label.setText("clicked");}
   public void mousePressed(MouseEvent evt) {label.setText("pressed");}
   public void mouseReleased(MouseEvent evt) {label.setText("released");}
   public void mouseEntered(MouseEvent evt) {label.setText("entered");}
   public void mouseExited(MouseEvent evt){label.setText("exited");}

   public static void main(String[] args) {
      new MouseListenerExample();
   }
}