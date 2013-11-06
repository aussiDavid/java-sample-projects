import java.io.*;
import java.util.*;
import java.*;

public class readingApp
{
	// Main method
	public static void main (String args[]){
	String[] entry = {"First name", "Surname", "Day", "Month", "Year"};
			int i = 0;
			String input;
	
		try{
			FileInputStream fin = new FileInputStream ("word.txt");

		    // Read a line of text
			
			input = new  DataInputStream(fin).readLine();
			
			while(input != null) {
				entry[i] += " : " + input;
				input = new  DataInputStream(fin).readLine();
				System.out.println(entry[i]);
				i++;
			}
			
		    fin.close();		
		}
		
		// Catches any error conditions
		catch (IOException e)
		{
			System.err.println ("Unable to read from file");
			System.exit(-1);
		}
		catch(ArrayIndexOutOfBoundsException e) {}
	}	
}