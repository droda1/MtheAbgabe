
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Tester extends JFrame{
	
	private BufferedImage backBuffer;
	
	public Tester () {
		
		setTitle("MatheSimulation");
		setSize(Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backBuffer = new BufferedImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
	
		}

	public static void main(String[] args) {
	
	MassenSimulation toTest = new MassenSimulation(1,600,20,5,10,10,10,5);
		
	Tester testObject = new Tester();
	testObject.setVisible(true);
	double absT = 0;
	while (true) {
		testObject.drawsp(toTest, absT);
		try {
			Thread.sleep((int) (Constants.TPF * 1000));absT += Constants.TPF;
			} catch (InterruptedException e) {
		}
	}
}

double f_sp(MassenSimulation object_input, double t) {
	
	object_input.simulate(t);
	return 100 + object_input.schwerpunkt;
	
}
double f_x1(MassenSimulation object_input, double t) {
	
	object_input.simulate(t);
	return 100 + object_input.x1;
	
}
double f_x2(MassenSimulation object_input, double t) {
	
	object_input.simulate(t);
	return 100 + object_input.x2;
	
}


public void drawsp(MassenSimulation object_input, double time) {	
	Graphics g = getGraphics();
	Graphics bbg = backBuffer.getGraphics();
	
	bbg.setColor(Color.LIGHT_GRAY);
	bbg.fillRect(0, 0,Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	
	double posSp = f_sp(object_input, time);
	double posX1 = f_x1(object_input, time);
	double posX2 = f_x2(object_input, time);
	
	
	
	bbg.setColor(Color.BLACK);
	bbg.fillRect((int) posX1, (Constants.WINDOW_HEIGHT/2), 80, 80);
	bbg.fillRect((int) posX2,(Constants.WINDOW_HEIGHT/2), 80, 80);
	
	bbg.setColor(Color.RED);
	bbg.fillOval((int) posSp,(Constants.WINDOW_HEIGHT/2), 14, 80);
	bbg.setColor(Color.BLUE);
	bbg.drawLine((int) posX1,(Constants.WINDOW_HEIGHT/2)+40, (int) posX2, (Constants.WINDOW_HEIGHT/2)+40);
	
	g.drawImage(backBuffer, 0, 0, null);	
	
	}
}
