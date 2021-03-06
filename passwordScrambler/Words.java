import java.util.*;

public class Words {
    static char[] alphabet = ",./<>?!@#$%^&*()_+123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	//static Vector buffer = new Vector();
	
    static void generate(StringBuffer sb, int n) {
        if (n == sb.length()) {
            System.out.println(sb.toString());
			//buffer.add(sb.toString());
			return;
        }
        for (char letter : alphabet) {
            sb.setCharAt(n, letter);
            generate(sb, n + 1);
        }
    }
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for (int length = 1; length <= 2; length++) {
            sb.setLength(length);
            generate(sb, 0);
        }
		//System.out.println(Arrays.toString(buffer.toArray()));
    }
}