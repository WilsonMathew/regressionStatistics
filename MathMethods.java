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

		// solve this problem emore efficiently
		x_values  = new double[this.n];
		y_values = new double[this.n];

		// initializing arrays
		for(int i = 0; i < this.n; i++) {
			this.x_values[i] = 0;
			this.y_values[i] = 0;
		}

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

		// why were you using and then assigning it. 
		// can't use a variable if you haven't defined it before.
		this.n = n;

		this.x_values  = new double[this.n];
		this.y_values = new double[this.n];

		// putting each values of erray passed to local erray
		for(int i = 0; i < this.n; i++) {

			this.x_values[i] = x_values[i];
			this.y_values[i] = y_values[i];
		}

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

		x_values = new double[this.n];
		y_values = new double[this.n];

		// initializing arrays
		for(int i = 0; i < this.n; i++) {
			this.x_values[i] = 0;
			this.y_values[i] = 0;
		}

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
	/* this are the formulas used to get the methods
	 * Slope(m) = (NSXY - (SX)(SY)) / (NSX2 - (SX)2) 
	 * the set_sxy, set_sx, set_sy, set_sx2, and set_n 
	 * shold be called before calling this methods 
	 * to not get 0 or a wrong answer 
	 */
	public void set_m() { this.m = ((n*get_sxy()) - (get_sx()*get_sy())) / ((n*get_sx2()) - (2*get_sx())); }	
	/*
	 * this are the formulas used to get the methods
	 * Intercept(b) = (SY - m(SX)) / N 
	 * the set_sy, set_m, and set_sx should be called before callig this method 
	 * to not get 0 or a wrong answer
	 */

	public void set_b() { this.b = (get_sy() - (get_m()*get_sx())) / n; }

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
			this.sx2 += (this.x_values[i] * this.x_values[i]);	
		}
	}

	/*
	 * This method retunrs a string with the y equation in the form
	 * Y = mx + b variale descrived above 
	 */ 
	public String yEquation () {
		return String.format("Y = %.3f x + %.3f", this.m, this.b);
	}

	/*
	 * To string method that java automaticlly calls.
	 */
	public String toString() {
		return String.format("sum(x): %.3f sum(y): %.3f sum(xy): %.3f sum(x^2): %.3f m: %.3f b: %.3f n: %d",this.sx, this.sy, this.sxy, this.sx2, this.m, this.b, this.n);
	}
}
