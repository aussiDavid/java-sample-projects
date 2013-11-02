/**Class ThreadTwo is a threaded class that - if a user activated 
*the thread - sends a text at a certain frequency to the GUI.
*Internetprogrammering 1 - Course
*@author Martin Carlsson
*@see AppletThread
*/

public class ThreadTwo implements Runnable {
    
    private int frequency = 1000; //milliseconds
    boolean looping = false; //Flag variable
    AppletThread at; //Reference for the GUI class AppletThread
    private String message = "Thread 2 is running\n"; //Message to send to the GUI
    /*Constructor*/
    ThreadTwo(AppletThread at) {
        this.at=at; 
    } 

    /*Run method with a while loop that sends a text
    to the GUI class, i.e. class AppletThread.*/
    public void run() {
        while(true) {
            try {
                Thread.sleep(frequency);
                synchronized(this) {
                while (!looping)
                    wait(); // used for putting the thread object in a waiting mode
                } 
            } 
            catch (InterruptedException e) {
            //ignored                
            } 
            at.setThreadText(message);//Callback to the GUI
        }
    }
    
    /*Used for setting setting the flag for stopping/pausing the thread.*/
    public synchronized void  setLooping(boolean b) {
        looping = b;
            if (looping)
            notify();
    } 
} // End klass ThreadTwo	