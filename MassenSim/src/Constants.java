import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public static int WINDOW_WIDTH = (int) screenSize.getWidth();
	public static int WINDOW_HEIGHT = (int) screenSize.getHeight();
	public static int FPS = 120;
	public static double TPF = 1.0 / FPS;
}
