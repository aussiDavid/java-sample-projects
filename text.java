import java.applet.*;
import java.awt.*;

public class text extends Applet {
	int num = 0;
	String word = "Hello";
	public void init() {
		word = "Bye";
	}
		
	public void paint( Graphics g ) {
	g.setColor( Color.black );
	g.drawString(word,10,10);
	}
}