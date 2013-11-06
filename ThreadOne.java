/**Class ThreadOne is a threaded class that - if a user activated 
*the thread - sends a text at a certain frequency to the GUI class, i.e. class AppletThread.
*Internetprogrammering 1 - Course
*@author Martin Carlsson
*@see AppletThread
*/

public class ThreadOne extends Thread {
    private boolean looping=false; // flag variable
    private AppletThread aT; // Reference to the GUI class AppletThread
    private int frequency = 1000; // milliseconds
    private String message = "Thread 1 is running\n"; //message to send to the GUI
    
    /*Constructor*/
    ThreadOne(AppletThread aT) {
        this.aT=aT;
    } 
    
    /*Run method with while loop that sends a text to the GUI at a certain frequency.*/
    public void run() {
        while(true) {
            try {
                Thread.sleep(frequency);
                synchronized(this) {
                while (!looping)
                    wait(); // to pause the thread, the thread/object is put in a waiting mode
                } // end of synchronized block
            } //end try
            catch (InterruptedException e) {
            //ignores exception                
            } // end catch
            aT.setThreadText(message);//callback to make the text visible in the GUI	
        } // end while		
    }
    
    /*Used for setting the flag varible to either looping or no looping.*/
    public synchronized void  setLooping(boolean b) {
        looping = b;
        if (looping)
            notify();
    } 
} // End class ThreadOne