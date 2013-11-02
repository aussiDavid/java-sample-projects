import java.io.*;
import java.util.*;


public class argsRead{
	// Main method
	public static void main (String args[]){
		int i = 1;
		
		try{
			FileReader fin = new FileReader(args[0]);
		}
			
		try{
			Scanner in = new Scanner(fin);
			in.useDelimiter(",\\s*");

			while(in.hasNext()){
				System.out.println("entry " + i + " : " + in.next());
				i++;
			}
		} catch (IOException e){
			System.err.println ("Unable to read from file");
			System.exit(-1);
		} finally {
			fin.close();
		}
	}	
}