import java.io.*;
import java.util.*;

public class argsWrite {
	public static void main (String[] args)	{
		boolean first = true;
		// Stream to write file
		FileOutputStream fout = null;
		FileReader fin = null;
		
		//Checks if there is anything in the file already
		try {
			fin = new FileReader(args[0]);
			Scanner in = new Scanner(fin);
			if (in.hasNext())
				first = false;
			}
			
			catch (FileNotFoundException e){
				first = false;  
			}
			
			finally{
				if(fin != null) {
					try{
						fin.close();
					} catch(IOException e){
					System.out.println("File could not close");
					}
				}
			}
			
		try{
		    // Open an output stream
		    fout = new FileOutputStream (args[0],true); 
		    // Print a text to file
			for(int i = 1; i < args.length; i++){
				if (!first && i == 1)
					new PrintStream(fout).print("\n" + args[i] + " ");
				else
					new PrintStream(fout).print(args[i] + " ");
			}
			}		
			
		// Catches any error conditions
		catch (IOException e){
			System.err.println ("Unable to write to file. May be in use be another program");
			System.exit(-1);
		}
		finally{
		    // Close our output stream
			if(fout != null) {
				try{
					fout.close();
				} catch(IOException e){
				System.out.println("File could not close");
				}
			}
		}
		
	}
}	
