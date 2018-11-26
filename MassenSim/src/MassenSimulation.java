
public class MassenSimulation{

	public double x1_start;
	public double x2_start;
	public double x1;
	public double x2;
	public double m1;
	public double m2;
	public double l_start;
	public double l;
	public double d;
	public double v1;
	public double v2;
	public double start_schwerpunkt;
	public double schwerpunkt;
	
	public MassenSimulation(double x1, double x2, double m1, double m2, double d, double l_start, double v1_start, double v2_start){
        
		this.x1_start= x1;
        this.x2_start= x2;
        this.x1= x1;
        this.x2= x2;
        this.m1= m1;
        this.m2= m2;
        this.d= d;
        this.l_start= l_start;
        this.v1= v1_start;
        this.v2= v2_start;
        this.schwerpunkt= ((m1*x1)+(m2*x2))/(m1+m2);
        this.start_schwerpunkt= schwerpunkt;
    }
	
	
	
	public void simulate(double absT) {
		double m_red = (m1*m2)/(m1+m2);
		
		double A = (x2_start - x1_start)-l_start;
		double B = (v2-v1-l_start)/Math.sqrt(m_red/d);
		
		double dt = A*Math.cos(Math.sqrt(d/m_red)*absT)+B * 
				Math.sin(Math.sqrt(d/m_red)*absT)+l_start;
		double vo= ((m1*v1)+(m2*v2))/(m1+m2);
		
		x1 = schwerpunkt-(m2/(m1+m2))*dt;
		x2 = schwerpunkt+(m1/(m1+m2))*dt;
		schwerpunkt = start_schwerpunkt + vo * absT;
	}

}
