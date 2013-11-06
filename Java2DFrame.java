import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
/**
 * Displays a JFrame and draws a line on it using the Java 2D Graphics API
 *
 * @author www.javadb.com
 */
public class Java2DFrame extends javax.swing.JFrame {
    
    /**
     * Creates a new instance of Java2DFrame
     */
    public Java2DFrame() {
        initComponents();
    }
    
    /**
     * This is the method where the line is drawn.
     *
     * @param g The graphics object
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code "> 
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold> 
    
    /**
     * Starts the program
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java2DFrame().setVisible(true);
            }
        });
    }
}