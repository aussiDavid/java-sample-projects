import java.util.Scanner;

public class ScannerTest1 {
    public static void main(String[] args) {

	String text = "This is an example of some text";
	Scanner in = new Scanner(text);

	while (in.hasNext()) {
	    System.out.println(in.next());
	}

	System.out.println(in.delimiter());

	String text2 = "This|| is an example||of some text";
	Scanner in2 = new Scanner(text2);

	in2.useDelimiter("\\|\\|");
	//in2.useDelimiter("||");
	while (in2.hasNext()) {
	    System.out.println(in2.next());
	}

	Scanner in3 = new Scanner(System.in);
	System.out.println("Enter a line of text: ");
	String text3 = in3.nextLine();
	System.out.println(text3);

    }
}