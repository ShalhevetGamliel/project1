
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */

/**
 * 
 * @author Shalhevet and Neomi
 *
 */
public class Monom implements function{

	private double _coefficient; 	
	private int _power;

	/**
	 * constructor
	 * @param a
	 * @param b
	 */
	public Monom(double a, int b){



		this.set_coefficient(a);

		this.set_power(b);
		if (b<0){
			throw new RuntimeException("Error: Invalid negative value");
		}
	}

	/**
	 * Copy Constructor
	 * @param ot
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power()); 
	}

	/**
	 * Default constructor
	 */
	public Monom() {

		this._coefficient = 2;
		this._power = 3; 
	}

	/**
	 * string constructor
	 * The value is valid if before the X there is a double number and after the X there is a int power
	 * a*x^b
	 * @param s
	 */
	public Monom(String str) {

		if (str.length() == 0){
			throw new RuntimeException("Error:Invalid Monom");	
		}
		else {
			String s2 = "";// string befor the x
			String s3 = "";//string after the x

			boolean isgood = false;

			//coefficient
			double a1;
			double a2;

			//power
			int b;

			if (str.contains("x") == true) {
				s2 = str.substring(0, str.indexOf('x'));
				if(s2.length() == 0) {
					isgood = true;
					set_coefficient(1); }
				else {
					if(s2.charAt(s2.length()-1) == '*') {
						if(checkDouble(s2.substring( 0 , s2.length()-1) ) == true ) {
							a1 = Double.parseDouble(s2.substring( 0 , s2.length()-1) );
							isgood=true;
							set_coefficient(a1); }}
					else {
						if(checkDouble(s2) == true ) {
							if((s2.charAt(0) == '-') && (s2.length() == 1 )) {
								isgood=true;
								set_coefficient(-1); }
							else {
								a2= Double.parseDouble(s2);
								isgood=true;
								set_coefficient(a2);}}}}
				if(str.length()-s2.length() == 1) {
					set_power(1);
					if(isgood == true) {
						isgood = true; }}
				else {
					s3= str.substring( str.indexOf('x') +1 ) ;
					if(isgood == true) {
						if(checkPower(s3) == true ) {
							b = Integer.parseInt(s3.substring(1));
							set_power(b); }
						else {
							isgood = false;	}}
				}}

			if(str.contains("x") == false) {
				if(checkDouble(str)) {
					double a = Double.parseDouble(str);
					set_coefficient(a);
					set_power(0);
					return;	}
				else {
					throw new RuntimeException("Error:Invalid Monom");}
			}
			if (isgood == false) {
				throw new RuntimeException("Error:Invalid Monom"); 	}}}

	/**
	 * Auxiliary function
	 * Auxiliary function for power test 
	 * @param str
	 * @return
	 */

	private boolean checkPower(String str) {
		if(str.charAt(0)!='^'){
			return false; }
		for(int i = 1 ; i < str.length() ; i++ ) {
			if((str.charAt(i)>'9' ||str.charAt(i)<'0')){
				return false; }}
		return true; }

	/**
	 * Auxiliary function
	 * Auxiliary function for double number test
	 * @param str
	 * @return
	 */
	private boolean checkDouble(String str) {

		int count=0;

		if(((str.charAt(str.length()-1)<'0' || str.charAt(str.length()-1)>'9'))) {
			return false;}
		if(str.length() == 1 && str.charAt(0)=='-') {
			return true;}

		for(int i=1; i<str.length()-1; i++) {
			if((str.charAt(i)!='.')&&(str.charAt(i)<'0'|| str.charAt(i)>'9')) {
				return false;}
			if(str.charAt(i) == '.') {
				count++;}}
		if (count>1) {
			return false;}
		return true;}

	/**
	 * function get coefficient
	 * Returns the value of coefficient
	 * @return
	 */
	public double get_coefficient() {

		return _coefficient; 

	}

	/**
	 * function get power
	 * Returns the value of power
	 * @return
	 */
	public int get_power() {

		return _power; 

	}

	/**
	 * function set coefficient
	 *  receives a value and set it in the value of the coefficient
	 * @param a
	 */
	private void set_coefficient(double a){

		this._coefficient = a; 

	}

	/**
	 * function set power
	 *  receives a value and set it in the value of the power
	 * @param p
	 */
	private void set_power(int p) {

		this._power = p; 

	}


	/**
	 * derivative of Monom m
	 * @param m
	 * @return
	 */
	//
	public  Monom derivative() {
		if(this.get_power()==0) {
			Monom m= new Monom(0,0);
			return m;
		}
		Monom m = new Monom(this);

		m.set_coefficient(this.get_coefficient()*this.get_power());
		m.set_power(this.get_power()-1);

		return m;
	}

	/**
	 * add Monom m to this Monom
	 * Adds only if the powers are equal
	 * @param m
	 */
	public void add(Monom m) {

		if(this.get_power() != m.get_power()) {
			throw new RuntimeException("Error: different power ");
		}

		else { //(this.get_power() == m.get_power()) 
			this.set_coefficient(this.get_coefficient() + m.get_coefficient());
			this.set_power(this.get_power()); 
		}
	}

	/**
	 * Multiply this Monom by Monom m
	 * @param m
	 */
	public void multiply(Monom m) {

		this.set_coefficient(this.get_coefficient() * m.get_coefficient());
		this.set_power( this.get_power() + m.get_power() );
	}

	/**
	 * The function checks whether the Monom is equal to zero
	 * @return
	 */
	public boolean isZero() {
		if(get_coefficient() == 0) {
			return true; }
		return false; }

	@Override
	/**
	 * The function accepts x value and sets it in a Monom
	 */
	public double f(double x) {

		double result =  this.get_coefficient()*(Math.pow(x , this.get_power() ));
		return result; 
	}

	@Override

	/**
	 *  function toString
	 */
	public String toString() {
		if (this._power == 0) {
			return this._coefficient+""; }
		if (this._coefficient == 0) {
			return 0+"";}
		return +this.get_coefficient()+"x^"+ this.get_power(); }

}//END MONOM
