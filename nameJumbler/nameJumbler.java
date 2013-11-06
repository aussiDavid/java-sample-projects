import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.io.*;
import java.text.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nameJumbler extends JFrame {
private static NJThread[] threads;
private static CThread[] threadsC;
private static String[] input;
private static JTextArea[] TAoutput;
private static JTextField[] TFanswers;
private static JPanel[] outputP;
private static JLabel[] statusL;
private static JButton submitB;
private static JButton clueB;
private static ExecutorService threadExecutor;

final Font font = new Font("Verdana",1,16);

private static int TAwidth = 110;
private static int TAheight = 400;


	public static void main(String[] args) {
		if(args.length == 0){
			args = new String[5];
			args[0] = "David";
			args[1] = "John";
			args[2] = "Greg";
			args[3] = "Mathews";
			args[4] = "Jackman";
		}
		
		input = args;
		threads = new NJThread[input.length];
		threadsC = new CThread[input.length];
		TAoutput = new JTextArea[input.length];
		
		threadExecutor = Executors.newFixedThreadPool(input.length);		// create ExecutorService to manage threads                        

		for(int i = 0; i < input.length; i++){
			TAoutput[i] = new JTextArea(100,50);
			threads[i] = new NJThread(i, input[i], TAoutput[i]);
			threadExecutor.execute(threads[i]); 		// start threads
		}
		new nameJumbler();

		threadExecutor.shutdown(); 						// shutdown worker threads
		while(!threadExecutor.isTerminated()){}
		for(int i = 0; i < input.length; i++)
			TFanswers[i].setEnabled(true);
		submitB.setEnabled(true);
		clueB.setEnabled(true);
	}
	
	public nameJumbler() {
		this.setTitle("Name Jumbler");
		
		//Declare and initialise panels.
		outputP = new JPanel[threads.length];
		for(int i = 0; i < threads.length; i++)
			outputP[i] = new JPanel();
		JPanel topP = new JPanel();
		JPanel contentP = new JPanel();
		JPanel bottomP = new JPanel();
		JPanel mainP = new JPanel();
		//Create button
		submitB = new JButton("Submit");
		clueB = new JButton("Clue");
		//Create Labels
		statusL = new JLabel[threads.length];
		for(int i = 0; i < threads.length; i++)
			statusL[i] = new JLabel(" - ", SwingConstants.LEFT);
		JLabel title = new JLabel("Word randomizer");
		JLabel label = new JLabel("Can you guess the words?  ~  ");
		//Create text Fields
		TFanswers = new JTextField[threads.length];
		for(int i = 0; i < threads.length; i++)
			TFanswers[i] = new JTextField("<word " + (i+1) + ">");
		//Layout the topP panel
		topP.setLayout(new BoxLayout(topP, BoxLayout.X_AXIS));
		topP.add(title);
		topP.add(Box.createHorizontalGlue());
		//Layout the outputP panel's
		for(int i = 0; i < threads.length; i++){
			outputP[i].setLayout(new BoxLayout(outputP[i], BoxLayout.Y_AXIS));
			outputP[i].add(TAoutput[i]);
			outputP[i].add(statusL[i]);
			outputP[i].add(TFanswers[i]);
			
			TAoutput[i].setEditable(false);
			TFanswers[i].setEnabled(false);
		}
		//Layout the content panel
		for(int i = 0; i < threads.length; i++){
			contentP.setLayout(new BoxLayout(contentP, BoxLayout.X_AXIS));
			contentP.add(outputP[i]);
		}
		//Layout the bottom panel
		bottomP.setLayout(new BoxLayout(bottomP, BoxLayout.X_AXIS));
		bottomP.add(label);
		bottomP.add(submitB);
		bottomP.add(clueB);
		bottomP.add(Box.createHorizontalGlue());
		//Layout the main panel
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.add(topP);
		mainP.add(contentP);
		mainP.add(bottomP);
		
		//actionListeners
		for(int i = 0; i < threads.length; i++)
			TFanswers[i].addActionListener(new Listener());
		submitB.addActionListener(new Listener());
		clueB.addActionListener(new clueListener());
		
		//change compnent state
		submitB.setEnabled(false);
		clueB.setEnabled(false);
		
		//Attach main panel to window.
		this.setContentPane(mainP);
		
		//Set size and minimum size
		this.setSize((threads.length)*TAwidth, TAheight);
		this.setMinimumSize(new Dimension((threads.length)*TAwidth, TAheight));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
		
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent action)	{
			for(int i = 0; i < input.length; i++){
				if(TFanswers[i].getText().equalsIgnoreCase(input[i]))
					statusL[i].setText("Correct");
				else
					statusL[i].setText("Incorrect");
			}
		}
	}

	/*private class clueListener implements ActionListener {
		public void actionPerformed(ActionEvent action)	{
		clueB.setEnabled(false);
	
		ExecutorService threadExecutor = Executors.newFixedThreadPool(input.length);		// create ExecutorService to manage threads                        

		for(int i = 0; i < input.length; i++) {
			threadsC[i] = new CThread(i, TAoutput[i], statusL[i], threads[i].getOutputArray(), input[i]); //create Threads
			threadExecutor.execute(threadsC[i]); 		// start threads
		}
		
		threadExecutor.shutdown(); 						// shutdown worker threads
		}
	}
*/

private final ExecutorService TE = Executors.newFixedThreadPool(input.length);		// create ExecutorService to manage threads                        

	private class clueListener implements ActionListener {
		public void actionPerformed(ActionEvent action)	{
		/*threadExecutor.submit(new Runnable(){
			clueB.setEnabled(false);
		
			//threadExecutor = Executors.newFixedThreadPool(input.length);		// create ExecutorService to manage threads                        

			for(int i = 0; i < input.length; i++) {
				threadsC[i] = new CThread(i, TAoutput[i], statusL[i], threads[i].getOutputArray(), input[i]); //create Threads
				threadExecutor.execute(threadsC[i]); 		// start threads
			}
			
			threadExecutor.shutdown(); 						// shutdown worker threads
			//while(!threadExecutor.isTerminated()){
			//}
		});*/
		}
	}

}

class NJThread extends Thread implements Runnable {

private String word;
private String[] processedWord = new String[18];
private JTextArea output;
private ArrayList<Integer> numbers = new ArrayList<Integer>();
private int ctr;
private int loopNum = 16;

	NJThread(int number, String word, JTextArea TA) {
		super("ThreadNJ"+number);
		this.word = word;
		output = TA;
	}

	public void run() {
		processedWord[0] = "";
		
		for(int i = 0; i < word.length(); i++)
			numbers.add(i);
			
		while(ctr < 3){
			ctr = 0;
			jumble();
		}
		
		for(int i = 1; i < processedWord.length-1; i++){
			output.setText(output.getText() + processedWord[i] + "\n");
			try{
				Thread.sleep(150);
			} catch(InterruptedException e){}
		}
	}
	
	public void jumble() {
		for(int i = 0; i < loopNum; i++){
			processedWord[i+1] = "";							//initialize
			Collections.shuffle(numbers);								//shuffle the numbers
				for(int j = 0; j < word.length(); j++){
					processedWord[i+1] += word.charAt(numbers.get(j));		//assemble the jumbled word
				}
			//do not display the word or the same jumbled word twice
			if(processedWord[i+1].equals(word) || processedWord[i].equals(processedWord[i+1])){
				i--;
				continue;
			}
			//do some checks
			if(processedWord[i+1] == null || processedWord[i+1].equals(""))
				continue;
				
			//if the processed word starts with the first chacter of the word...
			if(processedWord[i+1].startsWith(word.charAt(0)+""))
				ctr++;
		}
	}
	
	public String[] getOutputArray(){
		return processedWord;
	}
}

class CThread extends Thread implements Runnable {

private String word;
private String[] processedWord;
private String input;
private JTextArea outputTA;
private JLabel outputL;

	CThread(int number, JTextArea TA, JLabel L, String[] pWord, String in) {
		super("Thread C"+number);
		outputTA = TA;
		outputL = L;
		processedWord = pWord;
		input = in;
	}

	public void run() {
		outputTA.setText("");
		
		outputL.setText("Starts with : " + input.charAt(0));
		for(int j = 0; j < processedWord.length; j++){
			if(processedWord[j] == null || processedWord[j].equals(""))
				continue;
			
			if(!processedWord[j].startsWith(input.charAt(0)+""))
				continue;
			
			outputTA.setText(outputTA.getText() + processedWord[j] + "\n");
			try{
				Thread.sleep(250);
			} catch(InterruptedException e){}
		}
	}
}