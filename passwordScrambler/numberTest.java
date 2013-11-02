import java.text.*;

public class numberTest {
	public static void main(String[] args){
		 NumberFormat nf = NumberFormat.getInstance();
		 
		 
		double[] in = {1, 10, 5210 , 1020};
		 for (int i = 0; i < in.length; ++i) {
			System.out.print("Input : " + in[i]);
			System.out.println(" -> " + nf.format(in[i]) + "; ");
		 }
	}
}