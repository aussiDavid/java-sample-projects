import java.awt.event.*;
import javax.swing.*;
public class menuTester {
   JFrame myFrame = null;
   public static void main(String[] a) {
      (new menuTester()).test();
   }
   private void test() {
      myFrame = new JFrame("Menu Listener Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setBounds(50,50,250,150);
      myFrame.setContentPane(new JDesktopPane());

      JMenuBar myMenuBar = new JMenuBar();
      JMenu myMenu = getFileMenu();
      myMenuBar.add(myMenu);
      myMenu = getColorMenu();
      myMenuBar.add(myMenu);

      MyMenuItem myItem = new MyMenuItem("Help");
      myMenuBar.add(myItem);

      myFrame.setJMenuBar(myMenuBar);
      myFrame.setVisible(true);
   }
   private JMenu getFileMenu() {
      JMenu myMenu = new JMenu("File");
      MyMenuItem myItem = new MyMenuItem("Open");
      myMenu.add(myItem);
      myItem = new MyMenuItem("Close");
      myMenu.add(myItem);
      myMenu.addSeparator();
      myItem = new MyMenuItem("Exit");
      myMenu.add(myItem);
      return myMenu;
   }
   private JMenu getColorMenu() {
      JMenu myMenu = new JMenu("Color");
      ButtonGroup myGroup = new ButtonGroup();
      MyRadioButtonMenuItem myItem 
         = new MyRadioButtonMenuItem("Red");
      myItem.setSelected(true);
      myGroup.add(myItem);
      myMenu.add(myItem);
      myItem = new MyRadioButtonMenuItem("Green");
      myGroup.add(myItem);
      myMenu.add(myItem);
      myItem = new MyRadioButtonMenuItem("Blue");
      myGroup.add(myItem);
      myMenu.add(myItem);
      return myMenu;
   }
   private class MyMenuItem extends JMenuItem 
      implements ActionListener {
      public MyMenuItem(String text) {
         super(text);
         addActionListener(this);
      }
      public void actionPerformed(ActionEvent e) {
         System.out.println("Item clicked: "+e.getActionCommand());
      }
   }
   private class MyRadioButtonMenuItem extends JRadioButtonMenuItem
      implements ActionListener, ItemListener {
      public MyRadioButtonMenuItem(String text) {
         super(text);
         addActionListener(this);
         addItemListener(this);
      }
      public void actionPerformed(ActionEvent e) {
         System.out.println("Item clicked: "+e.getActionCommand());
      }
      public void itemStateChanged(ItemEvent e) {
         System.out.println("State changed: "+e.getStateChange()
            +" on "+((MyRadioButtonMenuItem) e.getItem()).getText());
      }
   }
}