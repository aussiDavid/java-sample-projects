import java.net.*;
import java.io.*;

public class IPstuff {
	public static void main(String[] args){
	
	String host = "SERVER";
	int timeOut = 3000; // I recommend 3 seconds at least
	InetAddress hostName = null; 
	boolean status = false;
	try{
		hostName = InetAddress.getByName(host);
		System.out.println("Address found");
	}
	catch(UnknownHostException e){
		System.out.println("Address not found");
		System.exit(-1);
	}	
	
	try{
		status = hostName.isReachable(timeOut);
	}
	catch(IOException e){
		System.out.println("IOException Error");
	}
		System.out.println("address reachable : " + status);
	
	}
}