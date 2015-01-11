public class MathMethods {

	/*
	Regression Equation(y) = b + mx 
	Slope(m) = (NSXY - (SX)(SY)) / (NSX2 - (SX)2) 
	Intercept(b) = (SY - m(SX)) / N 

	Where,
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

	private int n = 0;
	private double sx = 0;
	private double sy = 0;
	private double m = 0;
	private double b = 0;
	private double sxy = 0;
	private double sx2 = 0;

	private double[] x_values;
	private double[] y_values;

	// Overloadding contructors
	public MathMethods(){

		// setting up all values
		set_sx();
		set_sy();
		set_sxy();
		set_sx2();
		set_m();
		set_b();

		System.out.println("Argumetns missing");
	}

	/*
	 * This constructor is called when two double errays
	 * are passed to object and a n values as well.
	 * x,y,n
	 */
	public MathMethods(double[] x_values, double[] y_values, int n) {
		// putting each values of erray passed to local erray
		for(int i = 0; i < this.n; i++) {

			this.x_values[i] = x_values[i];
			this.y_values[i] = y_values[i];
		}

		this.n = n;

		// setting up all values
		set_sx();
		set_sy();
		set_sxy();
		set_sx2();
		set_m();
		set_b();
	}

	/*
	 * This constructor is called when two double errays
	 * are passed to object
	 * x,y
	 */
	public MathMethods(double[] x_values, double[] y_values) {

		for(int i = 0; i < this.n; i++) {

			this.x_values[i] = x_values[i];
			this.y_values[i] = y_values[i];
		}

		//setting all values
		set_sx();
		set_sy();
		set_sxy();
		set_sx2();
		set_m();
		set_b();
	}

	public int get_n(){return this.n;}
	public double get_sx() {return this.sx;}
	public double get_sy(){return this.sy;}
	public double get_m() {return this.m;}	
	public double get_b(){return this.b;}
	public double get_sxy(){return this.sxy;}
	public double get_sx2(){return this.sx2;}

	// set methods
	//Slope(m) = (NSXY - (SX)(SY)) / (NSX2 - (SX)2) 
	//Intercept(b) = (SY - m(SX)) / N Where,
	public void set_m() {
		this.m = ((n*get_sxy()) - (get_sx()*get_sy())) / ((n*get_sx2()) - (2*get_sx()));
	}	

	public void set_b() {
		this.b = (get_sy() - (get_m()*get_sx())) / n;
	}

	public void set_n(int n){this.n = n;}

	/*
	 * This method adds all the values of x. the sum of(x)
	 */
	public void set_sx() {
		for(int i = 0; i < this.n; i++) {
			this.sx += this.x_values[i];	
		}
	}

	/*
	 * This method adds all the values of y. the sum of(y)
	 */
	public void  set_sy() {
		for(int i = 0; i < this.n; i++) {
			this.sy += this.y_values[i];	
		}
	}

	/*
	 * This method adds all the values of the product of x an y
	 * The sum of(xy)
	 */
	public void set_sxy() {
		for(int i = 0; i < this.n; i++) {
			this.sxy += (this.x_values[i] * this.y_values[i]);	
		}
	} 

	/*
	 * This method adds all the values of x^2. 
	 * The sum of(x^2)
	 */
	public void set_sx2() {
		for(int i = 0; i < this.n; i++) {
			this.sxy += (this.x_values[i] * this.x_values[i]);	
		}
	}
}