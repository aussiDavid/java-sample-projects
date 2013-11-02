import java.io.*;

public class test {
static String  a = "hello";

	public static void main(String[] args) {
		String b = "world";
		System.out.println(a + " and " + b);
		
		test t = new test(a);
		System.out.println(t.upperCase(a));
		
		new test("cool").getOut();
		
		 BufferedReader in  = new BufferedReader(new InputStreamReader(System.in), 10);
		 
		 int i = 0;
		 
		 try{
			in.mark(10);
			System.out.println(in.readLine());
			System.out.println(in.markSupported());
			System.out.println(in.read());
			i = in.read();
		 }
				 
		 catch(IOException e) {
			System.out.println("IO Eception thrown");
			}
			
		System.out.println("i : " + i);
	}
	
	//constructor
	public test (String a){
		this.a = a;
	}
	//methods
	public String upperCase(String a){
		String b = a.toUpperCase();
		return b;
	}
	
	public void getOut() {
		System.out.println(a);
	}
}