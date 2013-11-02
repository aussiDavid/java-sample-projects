import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

    private JButton btnPaint;
    private JTextArea outputPaint;
    private PThread[] threads = new PThread[3];

    public MyFrame() {
	btnPaint = new JButton("Paint");
	outputPaint = new JTextArea(50, 100);
	btnPaint.addActionListener(new listener());
	this.add(btnPaint, BorderLayout.NORTH);
	this.add(outputPaint);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(200, 200);
	this.setVisible(true);
    }
	
	private class listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
		//Thread th = new Thread(new Runnable() {
		//    public void run() {
				for(int i = 0; i < 3 ; i++)
					threads[i] = new PThread(i, outputPaint);
		//    }
		//});
		//th.start();
	    }
	}
	
    public static void main(String[] args) {
	new MyFrame();
    }
}

class PThread extends Thread implements Runnable {

private JTextArea output;
private int number;

	PThread(int number, JTextArea output) {
		super("Thread C"+number);
		this.number = number;
		this.output = output;
		start();
	}

	public void run() {
		output.setText(output.getText() + number + " | before sleep\n");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		output.setText(output.getText() + number + " | after sleep sleep\n");
	}
}