public class MathMethods {

	/*
	Regression Equation(y) = b + mx 
	Slope(m) = (NSXY - (SX)(SY)) / (NSX2 - (SX)2) 
	Intercept(b) = (SY - m(SX)) / N Where,

	x and y are the variables. 
	X = First Score				 
	Y = Second Score			<-- values the user enters. 
	
	m = The slope of the regression line 
	b = The intercept point of the regression line and the y axis. 
	N = Number of values or elements 
	SXY = Sum of the product of first and Second Scores 
	SX = Sum of First Scores 
	SY = Sum of Second Scores 
	SX2 = Sum of square First Scores 
	*/

	private int n;

	public int get_n(){
		return this.n;
	}

	public double get_sx(double[] x_values, double[] y_values) {
		
		for(int i = 0; i < get_n(); i++){
			
		}

		return 0.0;	
	}

	public double get_sy(){}

	public double get_m() {}	
	public double get_b(){}
	public double get_sxy(){}
	public double get_sx2(){}

	// set methods
	public void set_n(int n){
		this.n = n;
	}

	public void set_m(){}	
	public void set_b(){}
	public void set_sxy(){}
	public void set_sx(){}
	public void  set_sy(){}
	public void set_sx2(){}
}
