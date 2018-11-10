package myMath;

import javax.sound.midi.Synthesizer;

public class Test {

	public static void main(String[] args) {
//
//		/* MONOM TEST*/
//		double a1 =5;
//		int b1 = 10;
//		double a2 = 3;
//		int b2 = 3;	
//
//		/*constructor*/
//		Monom m1 = new Monom(a1, b1);
//		System.out.println(m1);
//
//		/*Copy Constructor*/
//		Monom m2 = new Monom (m1);	
//		System.out.println("Monom m2:"+m2);
//
//		/*Default constructor*/
//		Monom m3 = new Monom ();
//		System.out.println("Monom m3:"+m3);
//
//		/*string constructor*/
//		String str="34*x^2";
//		Monom m4= new Monom(str);
//		System.out.println("Momon m4:"+m4);
//
//		/*derivative */
//		Monom m5 = new Monom(4,0);
//		System.out.println("Monom befor derivative: "+m5);
//		System.out.println("derivative Monom: "+ m5.derivative());
//
//		/*Add*/
//		Monom m6 = new Monom(2, 2);
//		Monom m7 = new Monom(5, 2);
//		Monom m8= new Monom (m6); 
//
//		
//
//		m6.add(m7); // m6+m7 = m6
//		System.out.println("Sum of two monoms: " + m8+ " + "+ m7+" = "+m6);	
//
//		/*Multiply*/			
//		Monom m9 = new Monom(2, 8);
//		Monom m10 = new Monom(5, 2);
//		Monom m11= new Monom (m9);
//		m9.multiply(m10);
//		System.out.println("Multiplication between two Monoms : "+ m11 +" * "+ m10 +" = "+ m9);
//
//		/*Value to x*/
//		// m10 =5x^2;
//		double val = 2;
//		System.out.println("Monom after value to x : " +m10.f(val));
//
//		/*POLYNOM TEST---------------------------------------------------------------*/
//		System.out.println("POlynom test");
//
//		/*The default constructor*/
//		Polynom p=new Polynom();
//		System.out.println("p"+" "+":"+p);
//
//		/*The copy constructor*/
//		Polynom p1=new Polynom(p); 
//		System.out.println("p1"+" "+":"+p1);
//
//		/*string constructor*/
//		Polynom p2=new Polynom("-5*x^10+9*x^6-7");   
//		System.out.println("p2:"+p2);
//
//		/*Value to x*/
//		System.out.println("f(1) = "+p2.f(1)); 
//
//		/*add a Polynom_able */ 
//		Polynom_able p3= new Polynom("4*x^10+1");
//		System.out.println("p3:"+p3);
//		System.out.println("p2:"+p2);
//		p2.add(p3);
//		System.out.println("add a Polynom_able: p2+p3 = "+p2);
//
//		/*add a Monom*/
//		System.out.println("p2:"+p2);
//		System.out.println("m1:"+m1);
//		p2.add(m1);
//		System.out.println("add: p2 + m1 = "+p2);
//
//		/*substract a Polynom_able*/
//		System.out.println("p3:"+p3);
//		System.out.println("p2:"+p2);
//		p3.substract(p2);
//		System.out.println("substract: p3-p2 = "+p3);
//
//		/*multiply a polynom_able */
//		Polynom_able p90= new Polynom("0");
//		Polynom p4= new Polynom("4*x^8+1+5*x^2");
//		System.out.println("p4:"+p4);
//		System.out.println("p90:"+p90);
//		p4.multiply(p90);
//		System.out.println("multiply a polynom_able: p90 * p4 = "+p4);
//
//		/*equals*/
//		Polynom_able p5= new Polynom("0");
//		Polynom p6= new Polynom("4*x^8+1");
//		System.out.println("p6:"+p6);
//		System.out.println("p5:"+p5);
//		System.out.println("equals:"+ p6.equals(p5));
//
//		/*isZero*/
//		Polynom zero =new Polynom();
//		System.out.println("isZero:"+zero.isZero()); 
//
//		/*root*/
		Polynom_able p7 = new Polynom("x-2");
		
//		System.out.println("root:"+p7.root(0,4,0.01));
//		
//		/*area*/
	Polynom p11=new Polynom("-8*x^3+9");
		System.out.println( "area:"+p11.area(5, 4, 0.0001));
	
//
//		/*copy*/
//		
		Polynom_able p8 =new Polynom(); 
		p8=p7.copy();
		System.out.println("p7: "+ p7);
//		System.out.println("copy: p8 = p7 = " +p7);
//		
//		/*derivative */
//		Polynom p12=new Polynom("-4*x^3+1");
//		System.out.println("p12:"+p12);
//		System.out.println("derivative of p12="+p12.derivative());
//
//		Polynom p6 = new Polynom("x-2");
//		System.out.println("area test:");
//		double are=p6.area(0,4,0.01);
//		boolean ans= (are>=2 && are<=2.01);
//		System.out.println("test success ? :" + ans);
	}}