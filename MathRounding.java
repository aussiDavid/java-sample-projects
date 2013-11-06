import java.text.*;

public class MathRounding {

public static void main (String [] args) {

        double giveaway = 1000000.0;
        DecimalFormat lon = new DecimalFormat("#00.000 degrees");
        for (int rec = 90; rec > 0; rec--) {
                double amount = rec;
                System.out.print ("With "+rec+ " recipients ");
                String howmuch = lon.format(amount);
                System.out.println ("each gets "+howmuch);
                }
        }
}