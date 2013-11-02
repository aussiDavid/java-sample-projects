class numberThread implements Runnable{
	
	Thread t;
	int i = 0;
	
	public numberThread() {
	}
	
	public numberThread(String threadName) {
        t = new Thread(this, threadName);   // (1) Create a new thread.
        t.start();                          // (2) Start the thread.
	}
	
	public void run(){
	while(i < 100){
		try {
			t.sleep(1000);
			}
			catch(InterruptedException e){}
			i++;
			System.out.println(" i : " + (char)i);	//Display info about this particular thread
		}
	}
}

class stringThread implements Runnable{
	
	Thread t;
	String str = "a";
	
	public stringThread() {
	}
	
	public stringThread(String threadName) {
        t = new Thread(this, threadName);   // (1) Create a new thread.
        t.start();                          // (2) Start the thread.
	}
	
	public void run(){
		while(str.length() < 100){
		try {
			t.sleep(1500);
			}
			catch(InterruptedException e){}
			str = str + "a";
			System.out.println("str : " + str);	//Display info about this particular thread
		}	
	}
}


public class RunnableExample{


	public static void main(String[] args){
	    Thread thread1 =  new Thread(new numberThread(),"Numbers");
	    Thread thread2 =  new Thread(new stringThread(),"Strings");
	    
		//Start the threads
	    thread1.start();
	    thread2.start();
		
		/*
	    try{
	      thread1.sleep(2000);	//delay for one second
	      thread2.sleep(1000);	//delay for one second
	    }
		catch(InterruptedException e){}
		*/
	}
}