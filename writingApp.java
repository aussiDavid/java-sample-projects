import java.io.*;

public class writingApp {
	// Main method
	public static void main (String args[])
	{
		// Stream to write file
		FileOutputStream fout;		

		try
		{
		    // Open an output stream
		    fout = new FileOutputStream ("word.txt");

		    // Print a line of text
		    new PrintStream(fout).println ("David");
		    new PrintStream(fout).println ("Milanese");
		    new PrintStream(fout).println ("13");
		    new PrintStream(fout).println ("05");
		    new PrintStream(fout).println ("1992");

		    // Close our output stream
		    fout.close();		
		}
		// Catches any error conditions
		catch (IOException e)
		{
			System.err.println ("Unable to write to file");
			System.exit(-1);
		}
	}	
}