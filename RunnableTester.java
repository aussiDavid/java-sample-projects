import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import javax.swing.*;

public class RunnableTester extends JFrame {
	public static void main(String[] args){
		new RunnableTester();
		
		update[] task = new update[4];
		JTextArea[] JTA = {outputA, outputB, outputC, outputD, outputE};
		// create and name each runnable
		for(int i = 0; i < task.length; i++)		
			task[i] = new threadCalc("Thread"+(i+1), JTA[i]);
		/*update task2 = new update("thread2", outputB);
		update task3 = new update("thread3", outputC);
		
		update task4 = null;
		update task5 = null;
		try{
			task4 = new update("thread4",args[0], outputD);
		}catch(ArrayIndexOutOfBoundsException e){
			task4 = new update("thread4", outputD);
		}		
		try{
			task5 = new update("thread5",args[1], outputE);
		}catch(ArrayIndexOutOfBoundsException e){
			task5 = new update("thread5", outputE);
		}
		PrintTask task6 = new PrintTask("thread6");
		PrintTask task7 = new PrintTask("thread7");
		*/
		System.out.println("Starting threads");
			
		ExecutorService threadExecutor = Executors.newFixedThreadPool(7); // create ExecutorService to manage threads                        

		// start threads and place in runnable state   
		for(int i = 0; i < task.length; i++)
			threadExecutor.execute(task[i]); 		// start tasks
			
		threadExecutor.shutdown(); // shutdown worker threads
			
	 	System.out.println("Threads Started, Main finsihed");
		
		while(!threadExecutor.isTerminated()){}
		
		JOptionPane.showMessageDialog(null, "All Threads Completed", "Complete", JOptionPane.PLAIN_MESSAGE);
	
		System.exit(0);
	}
	
	//text area
	public static JTextArea outputA = new JTextArea(100,50);
	public static JTextArea outputB = new JTextArea(100,50);
	public static JTextArea outputC = new JTextArea(100,50);
	public static JTextArea outputD = new JTextArea(100,50);
	public static JTextArea outputE = new JTextArea(100,50);
	
	public RunnableTester() {		
		//Declare and initialise panels.
		JPanel outputP = new JPanel();
		
		//Layout outputP panel
		outputP.setLayout(new BoxLayout(outputP, BoxLayout.X_AXIS));
		outputP.add(Box.createHorizontalGlue());
		outputP.add(outputA);
		outputP.add(Box.createHorizontalGlue());
		outputP.add(outputB);
		outputP.add(Box.createHorizontalGlue());
		outputP.add(outputC);
		outputP.add(Box.createHorizontalGlue());
		outputP.add(outputD);
		outputP.add(Box.createHorizontalGlue());
		outputP.add(outputE);
		outputP.add(Box.createHorizontalGlue());
		
		//Attach main panel to window
		this.setContentPane(outputP);
		
		//Frame Attributes
		this.setTitle("MultiThreading is Cool");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
}