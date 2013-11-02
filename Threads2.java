import java.applet.*;
import java.awt.*;

public class Threads2 extends Applet implements Runnable {
   int width, height;
   int i = 1;
   Thread t = new Thread( this );
   boolean threadSuspended  = false;
	
	public void init() {
	System.out.println("init() : start");
	width = getSize().width;
	height = getSize().height;
	setBackground( Color.black );
	System.out.println("init() : start");
	}
	
	// Executed within the thread that this applet created.
   public void start() {
      System.out.println("start(): begin");
      if ( t == null ) {
         System.out.println("start(): creating thread");
         System.out.println("start(): starting thread");
         threadSuspended = false;
         t.start();
      } else {
         if ( threadSuspended ) {
            threadSuspended = false;
            System.out.println("start(): notifying thread");
            synchronized( this ) {
               notify();
            }
         }
      }
      System.out.println("start(): end");
   }
	
    // Executed after the applet is created; and also whenever the browser returns to the page containing the applet.
   public void run() {
      System.out.println("run(): begin");
      try {
         while (true) {
            System.out.println("run(): awake");

            // Here's where the thread does some work
            ++i;  // this is shorthand for "i = i+1;"
            if ( i == 10 ) {
               i = 1;
            }
            showStatus( "i is " + i );

            // Now the thread checks to see if it should suspend itself
            if ( threadSuspended ) {
               synchronized( this ) {
                  while ( threadSuspended ) {
                     System.out.println("run(): waiting");
                     wait();
                  }
               }
            }
            System.out.println("run(): requesting repaint");
            repaint();
            System.out.println("run(): sleeping");
            t.sleep( 1000 );  // interval given in milliseconds
         }
      }
      catch (InterruptedException e) { }
      System.out.println("run(): end");
   }

	public void paint( Graphics g ) {
		g.setColor( Color.black );
		//g.drawOval( 100, 100,10*i,10*i);
		g.drawLine( width, height, i * width / 10, 0 );
    }	
}