package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import javax.management.RuntimeErrorException;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */


/**
 * 
 * @author Shalhevet and Neomi
 *
 */
public class Polynom implements Polynom_able{

	private final Monom_Comperator compare= new Monom_Comperator();
	private ArrayList<Monom> polynom;

	/**
	 *  Default constructor
	 *  An empty polynom is a polynom equal to 0
	 */
	public Polynom(){
		polynom = new ArrayList<Monom>();
		Monom m= new Monom (0,0);
		polynom.add(m);
	}

	/**
	 * Copy Constructor
	 * @param p
	 */
	public Polynom (Polynom p){

		this.polynom=new ArrayList<Monom>();

		Iterator<Monom> itp = p.iteretor();

		while(itp.hasNext()){

			Monom m1 = itp.next();

			this.add(new Monom(m1));
		}
	}

	/**
	 * The function accepts x value and sets it in a Monom and return sum
	 */

	@Override
	public double f(double x){

		double sum = 0;

		Iterator<Monom> iter = this.iteretor();

		while(iter.hasNext()){

			Monom m1 = iter.next();

			sum = sum + m1.f(x) ;
		}
		return sum;
	}

	/**
	 * string constructor
	 * @param s
	 */
	public Polynom(String s) {

		this.polynom=new ArrayList<Monom>();

		String m ="";

		String s1 = "";

		for(int i = 0 ; i<s.length();  i++ ) {

			if((s.charAt(i)=='-' ) && (i!=0)) {

				s1 = s1 +"+"+ s.charAt(i);} 
			else {

				s1= s1 + s.charAt(i); }}

		s = s1 + "+";

		for(int i=0; i<s.length();) {

			m =s.substring(0 , s.indexOf('+'));

			for(int k= 0; k<m.length() ; k++) {

				if(m.charAt(k) == ' ') {

					m =	m.substring(k+1);

				}

				else {

					break;}}

			for(int l=m.length()-1 ; l>-1  ;l-- ) {

				if(m.charAt(l) == ' ') {

					m =	m.substring(0,l);}

				else {
					break; }}

			s = s.substring (s.indexOf('+') + 1, s.length());

			Monom m1=new Monom(m);

			add(m1); }}


	/**
	 * Add polynom able to this Polynom
	 */
	@Override
	public void add(Polynom_able p1) {

		Iterator<Monom> itrp1 = p1.iteretor();

		while (itrp1.hasNext()) {
			Monom m1 = itrp1.next();
			add(m1);	
		}
	}

	/**
	 *  Add Monom m1 this Polynom 
	 */
	@Override

	public void add(Monom m1) {

		boolean add = false;

		Iterator<Monom> iter = this.iteretor();

		while(( add == false) && (iter.hasNext())) {

			Monom m2 =iter.next();

			if(m2.get_power()==m1.get_power()) { 

				m2.add(m1);

				add = true;

			}
			if(m2.get_coefficient()==0) { 

				iter.remove();
			}
		}

		if (add == false) {

			polynom.add(m1);

			this.polynom.sort(compare); }}

	/**
	 * substract between this polynom to Polynom_able p1
	 */
	@Override
	public void substract(Polynom_able p1) {

		Iterator<Monom> itrp1 =p1.iteretor();

		while (itrp1.hasNext()) {

			Monom m2=itrp1.next();

			double a = ((m2.get_coefficient())* (-1));

			int b = m2.get_power();

			Monom n1 = new Monom (a,b);

			add(n1);

		}}

	/**
	 * multiply between this polynom with Polynom_able p1
	 */

	@Override
	public void multiply(Polynom_able p1) {
		Polynom polynomnew= new Polynom();
		Iterator<Monom> itrp1 = p1.iteretor();
		
		while (itrp1.hasNext()) {
			Monom n1 = new Monom(itrp1.next());
			Iterator<Monom> itr = this.iteretor();
			while (itr.hasNext()) {
				Monom n3= new Monom (n1);
				Monom n2 = new Monom (itr.next());
				n3.multiply(n2);
				if (n3.get_coefficient()==0)
					itr.remove();
				polynomnew.add(n3);
				//n1=n3;
			}
		}
		this.polynom=polynomnew.polynom; 
	}

	/**
	 * check if the this polynom is equals to Polynom_able p1
	 * return true or false
	 */

	@Override

	public boolean equals(Polynom_able p1) {
		Iterator<Monom> itrp1 = p1.iteretor();
		Iterator<Monom> itr = polynom.iterator();

		while (itrp1.hasNext()|| itr.hasNext()) {

			if (itrp1.hasNext()==true && itr.hasNext()==false) {
				return false;
			}
			if (itrp1.hasNext()==false && itr.hasNext()==true) {
				return false;
			}
			Monom n1 = itrp1.next();
			Monom n2 = itr.next();

			if (n1.get_coefficient()!= n2.get_coefficient()|| n1.get_power()!=n2.get_power()) {
				return false;
			}
		}

		return true;
	}
	/**
	 * check if the polynom equals zero
	 * return true or false
	 */
	@Override
	public boolean isZero() {
		if (this.polynom.size()==0) {
			return true;
		}
		return false;
	}
	/**
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
	 */
	@Override
	public double root(double x0, double x1, double eps) {

		if(f(x0)*f(x1) > 0) 
			throw new RuntimeException("worng input");
		else 
		{
			double x2=(x1+x0)/2;
			if(0-eps<=f(x2) && 0+eps>f(x2)) {
				return x2;
			}
			else {
				if((f(x2)<0 && f(0)<0)||(f(x2)>0 && f(x0)>0)){
					x0=x2;
					return root(x0,x1,eps);
				}
				else {
					return root(x0,x2,eps);
				}}}}

	@Override
	/**
	 * copy the Polynom_able
	 */
	public Polynom_able copy() {

		Polynom_able ablep1= new Polynom();

		Iterator<Monom> itr = polynom.iterator();

		while(itr.hasNext()) {
			Monom m1= itr.next();
			ablep1.add(m1);
		}	

		return ablep1;
	}

	@Override
	/**
	 * derivative of the Polynom_able
	 */
	public Polynom_able derivative() {
		Polynom_able ablep1= new Polynom();
		Iterator<Monom> itr= iteretor();

		while(itr.hasNext()) {
			Monom m1= new Monom(itr.next());
			Monom m2= new Monom ();
			m2=m1.derivative();

			ablep1.add(m2);	
		}
		return ablep1;
	}



	@Override
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps
	 */
	public double area(double x0, double x1, double eps) {
		 if (x0>x1) {
			 throw new RuntimeException("worng input");
		 }

		double area=0;

		while (x0<=x1) {

			if (f(x0)<0) {
				x0=x0+eps;
			}
			else {
				area= area + (f(x0)*eps);
				x0=x0+eps;
			}
		}

		return area;
	}

	@Override
	/**
	 *  return iteretor of the this polynom
	 */
	public Iterator<Monom> iteretor() {
		return this.polynom.iterator();
	}

	/**
	 * function get Polynom
	 * Returns the ArrayList of Polynom
	 * @return
	 */
	public ArrayList<Monom> getPolynom() {
		return polynom;
	}

	/**
	 * function toString
	 */
	public String toString(){
		String ans = "";

		Iterator<Monom> it = polynom.iterator();
		if(!it.hasNext()) {
			return "0";
		}
		ans= ans+it.next();
		while(it.hasNext())
		{
			Monom m1 = it.next();
			if(m1.get_coefficient()>0) {
				ans= ans+" + "+m1.toString();
			}
			else {
				ans= ans+" "+ m1.toString();
			}
		}


		if (ans!="") {
			return ans;
		}
		else {
			return 0+"";
		}

	}}

