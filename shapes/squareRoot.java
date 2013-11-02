public class squareRoot{
	public static void main(String[] ags){
		System.out.println("Square root of " + args[0] + " : " + sqrt(args[0]));
	}
	
	public static double sqrt(n) {
		if(n == 1)
			return 1;
		return 0.5(sqrt(n-1) + 3/sqrt(n-1));
	}
}