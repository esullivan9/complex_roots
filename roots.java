/**
 * A simple program to calculate the nth root of a complex 
 * number of the form z = x + yi. 
 * 
 * The user must enter the x and y of the complex number and 
 * the root that they wish to find.
 * (For the second root, the user would enter 2 for n).
 * 
 * Created by Eric Sullivan on October 19th, 2019.
 *
 */

import java.lang.Math;
import java.util.*;

public class roots
{
	/**
	 * Takes prompted (from the command line) user input and calculates the 
	 * desired roots of a user specified complex number, then displayes those 
	 * roots to the screen.
	 * @param args Main does not take command line arguments.
	 */
	public static void main(String[] args)
	{
		double 	x, y, n;
		Scanner s = new Scanner(System.in);

		try
		{
			System.out.print("Enter the value of x: ");
			x = s.nextDouble();
			System.out.print("Enter the value of y: ");
			y = s.nextDouble();
			System.out.print("Enter the desired root: ");
			n = s.nextDouble();
			
			//Checks the value of n.
			if(n > 0)
			{
				//Creates the arraylist for the roots of the user's complex number.
				ArrayList<String> Roots = new ArrayList<>((int) n);
			
				System.out.println("The complex number is " + x + " + " + y + "i.");
				
				//Calculates the roots of the user's complex number.
				Roots = root(x, y, getTheta(x, y), n);

				//Prints the roots of the user's complex number to the screen.
				System.out.println("The roots are: ");
				for(int i = 0; i < (int) n; i++)
					System.out.println(Roots.get(i));
			}
			else
				System.out.println("The value of n cannot be negative (or zero).");
			
			//Close the scanner.
			s.close();
		}
		catch(InputMismatchException e)
		{
			System.out.println("All inputs are numbers only!");
		}
	}		

	/**
	 * Determines the sutiable value for theta, the angle formed by the 
	 * user's complex number in the complex plane, based on the x and y
	 * values of the user's complex number.
	 * 
	 * @param x The x value of the entered complex number.
	 * @param y The y value of the entered complex number.
	 * @return The sutiable value of theta.
	 */
	public static double getTheta(double x, double y)
	{
		if((x > 0 && y > 0) || (x > 0 && y < 0))
			return Math.atan(y/x);
		else if(x < 0 && y > 0)
			return Math.PI - Math.abs(Math.atan(y/x));
		else if(x < 0 && y < 0)
			return Math.atan(y/x) - Math.PI;
		else if(x == 0)
		{
			if(y > 0)
				return Math.PI/2;
			else
				return -(Math.PI/2);
		}
		else if(y == 0)
		{
			if(x > 0)
				return 0.0;
			else
				return Math.PI;
		}
		else
			return 0.0;
	}
	
	/**
	 * Calculates the roots of the given complex number, converts them to a string
	 * then adds them to an arraylist. This arraylist contains all roots of the 
	 * given complex number. Once all the roots are calculated, the arraylist containing
	 * the roots is then returned.
	 * @param x The x value of the entered complex number.
	 * @param y The y value of the entered complex number.
	 * @param theta The angle formed by the complex number when plotted in the complex plane.
	 * @param n The root the user requested. 
	 * @return An arraylist of strings of the values of the roots of the given complex number.
	 */
	public static ArrayList<String> root(double x, double y, double theta, double n)
	{
		double a, a2, b, b2, k, p, Q;
		String d_root;
		ArrayList<String> outRoot = new ArrayList<>();

		Q = Math.pow(x,2)+Math.pow(y,2);
		p = 1/(2*n);
		
		for(k = 0; k < n; k++)
		{
			//Root of the complex number in the form a + bi
			a = Math.pow(Q,p)*Math.cos((theta+2*Math.PI*k)/n);
			b = Math.pow(Q,p)*Math.sin((theta+2*Math.PI*k)/n);
			
			//Rounds the values of a and b to 12 decimal places
			a2 = Math.round(a * 100000000000d) / 100000000000d;
			b2 = Math.round(b * 100000000000d) / 100000000000d;

			//Root is recorded as a string
			if(b < 0)
				d_root = a2 + "-" + Math.abs(b2) + "i";
			else
				d_root = a2 + "+" + b2 + "i";
			
			//Root is added to the arraylist of roots
			outRoot.add(d_root);
		}

		return outRoot;
	}			
}