// PrintTask class sleeps for a random time from 0 to .5 seconds
import java.util.Random;
import javax.swing.*;

class update implements Runnable {
	private int sleepTime; // random sleep time for thread
	private String threadName; // name of thread
	private static Random generator = new Random();
	private JTextArea output;
	
   // assign name to thread
	public update(String name, JTextArea JTA){
		threadName = name; 							// set name of thread
		sleepTime = generator.nextInt(250);			// pick random sleep time between 0 and 5 seconds
		output = JTA;
		output.setEditable(false);
	}	

	public update(String name, String rand, JTextArea JTA){
		threadName = name; 											// set name of thread
		sleepTime = generator.nextInt(Integer.parseInt(rand));		// pick random sleep time between 0 and 5 seconds
		output = JTA;
		output.setEditable(false);
	}		
	
	// method run is the code to be executed by new thread
	public void run(){
		try{										// put thread to sleep for sleepTime amount of time
			addText(threadName + " going to sleep \nfor " + sleepTime + " milliseconds after \ndisplaying each number");
			for(int i = 0; i < 35; i++){
				addText("" + i);
				Thread.sleep(sleepTime); 				// put thread to sleep
			}
			
		} catch (InterruptedException exception) {
         exception.printStackTrace();
		}

		addText(threadName + " Complete");
	}
	
	public void addText(String text){
		output.setText(output.getText() + text + "\n");
	}
}