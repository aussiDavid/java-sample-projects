/*
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.io.*;
import java.text.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
*/
public class passwordScrambler extends JFrame {

//static char[] alphabet = ",./<>?!@#$%^&*()_+123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

private static SThread[] threads;
private static ArrayList<SThread> otherThreads = new ArrayList<SThread>();
private static ArrayList<SThread> otherThreadsTemp = new ArrayList<SThread>();
private static String[] input;
private static JTextField[] TAoutput;
private static JPanel[] outputP;
private static JLabel[] pcL;
private static JButton submitB;

final Font font = new Font("Courier new",1,14);

private static int TAwidth = 200;
private static int TAheight = 200;

	public static void main(String[] args) {
		if(args.length == 0){
			input = new String[2];
			input[0] = "abc";
			input[1] = "5";
		} else 
			input = args;
		
		threads = new SThread[Integer.parseInt(input[1])];
		
		new passwordScrambler();
	}
	
	public passwordScrambler() {
		this.setTitle("Password Scrambler");
		
		//Declare and initialise panels.
		outputP = new JPanel[threads.length];
		for(int i = 0; i < threads.length; i++)
			outputP[i] = new JPanel();
		JPanel topP = new JPanel();
		JPanel contentP = new JPanel();
		JPanel middleP = new JPanel();
		JPanel mainP = new JPanel();
		//Create button
		submitB = new JButton("Scramble");
		//Create TextAreas
		TAoutput = new JTextField[threads.length];
		for(int i = 0; i < threads.length; i++){
			TAoutput[i] = new JTextField();
			TAoutput[i].setFont(font);
		}
		//Create Labels
		JLabel storyL = new JLabel("The story so far... You have " + input[1] + " computers at your dispoal, and you are trying log in to someone elses account by guessing their password, hit Scramble to exploite this person");
		pcL = new JLabel[threads.length];
		for(int i = 0; i < threads.length; i++)
			pcL[i] = new JLabel("PC :" + (i+1));
		//Layout the topP panel
		topP.setLayout(new BoxLayout(topP, BoxLayout.X_AXIS));
		topP.add(storyL);
		topP.add(Box.createHorizontalGlue());
		//Layout the middleP panel
		middleP.setLayout(new BoxLayout(middleP, BoxLayout.X_AXIS));
		middleP.add(submitB);
		middleP.add(Box.createHorizontalGlue());
		//Layout the content panel
			//create sub panels
			for(int i = 0; i < threads.length; i++){
				outputP[i].setLayout(new BoxLayout(outputP[i], BoxLayout.Y_AXIS));
				outputP[i].add(pcL[i]);
				outputP[i].add(TAoutput[i]);
				
				TAoutput[i].setEditable(false);
			}
		
		for(int i = 0; i < threads.length; i++){
			contentP.setLayout(new BoxLayout(contentP, BoxLayout.X_AXIS));
			contentP.add(outputP[i]);
		}
		//Layout the bottom panel
		//bottomP.setLayout(new BoxLayout(bottomP, BoxLayout.X_AXIS));
		//Layout the main panel
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.add(topP);
		mainP.add(middleP);
		mainP.add(contentP);
		//mainP.add(bottomP);
		
		//actionListeners
		submitB.addActionListener(new Listener());
		
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
			submitB.setEnabled(false);
			
			ExecutorService threadExecutor = Executors.newFixedThreadPool(threads.length);		// create ExecutorService to manage threads                        
			
			for(int i = 0; i < threads.length; i++)
				threads[i] = new SThread(i, TAoutput[i]); 	//create all Threads

			threadExecutor.shutdown(); 						// shutdown worker threads
		}
	}
	
	public static SThread[] getSThreads(){
		return threads;
	}
	
	public static String getTargetWord(){
		return input[0];
	}
}

class SThread extends Thread implements Runnable {
private static int recursiveCtr = 0;
private static char letter;
private int ctr = 0 ;
private String target;
private String word;
private JTextField outputTA;
private int threadNumber;
private int numOfThreads;
private SThread[] threads;

	SThread(int number, JTextField TA) {
		super("Scrambler Thread #"+number);
		threadNumber = number;
		outputTA = TA;
		target = passwordScrambler.getTargetWord();
		threads = passwordScrambler.getSThreads();
		numOfThreads = threads.length;
		setDaemon(true); 
		start();
	}

	public void run() {
	/*
		//this is the i-th thread so search between i and i+1 sections of the search space
		int load = Math.round((126 - 32)/numOfThreads);
		int start = threadNumber * load;
		int end = (threadNumber+1) * load -1;
		
		if(94 - end < load)
			end = 94;
		for(int i = start; i < end; i++){
			for (int j = 32; j < 127; j++) {
				for(int k = 32; k < 127; k++) { 
					word = (char)(i+32)+""+(char)(j)+(char)k;
					ctr++;
					if(word.equals(target)){
						
						//interrupt the other threads
						for(int n = 0; n < threads.length; n++){
							threads[n].changeText("search terminated");
							if(n == threadNumber)
								continue;
							else
								threads[n].stop();
						}
						
						outputTA.setText(word + " - password found");
						
						return;
					} else { if(ctr%20==0)
								outputTA.setText(word);
					}
				}
			}
		}
		outputTA.setText("password not found");
	*/
		StringBuffer sb = new StringBuffer();
		for (int length = 1;; length++) {
			sb.setLength(length);
			generate(sb, 0);
		}
	}
	
	private void generate(StringBuffer sb, int n) {
		if (n == sb.length()) {
			if((sb.toString()).equals(target)){
				for(int i = 0; i < threads.length; i++){
					if(i == threadNumber)
						continue;
					threads[i].stop();
					threads[i].changeText("search terminaed");
				}
				outputTA.setText(sb.toString() + " - password found");
				
				stop();
			}
			ctr++;
			
			if(ctr == 100)
			//	stop();
			
			if(ctr%1 == 0)
				outputTA.setText(sb.toString());
			
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){}
			
			//System.out.println(sb.toString());
			return;
		}
		//synchronized(this) {
			for (char letter : passwordScrambler.alphabet) {		//for each character in alphabet (char) array
				sb.setCharAt(n, letter);
				generate(sb, n+1);
			}
		//}
	}
	
	public void changeText(String text){
		outputTA.setText(text);
	}
	
	public static synchronized int ctrInc(){
		if(recursiveCtr >= passwordScrambler.alphabet.length)
			recursiveCtr = 0;
		else
			recursiveCtr++;
		System.out.println("recursiveCtr " + recursiveCtr);
		return recursiveCtr;
	}
}