import java.lang.Math;
import java.util.*;

public class roots
{
	public static void main(String[] args)
	{
		double 	x, y, n, Q, P, theta;
		
		if(args.length == 0 || args.length < 3)
		{
			System.out.println("Usage: java roots <x value> <y value> <desired root>");
			System.exit(0);
		}
		
		x = Double.valueOf(args[0]);
		y = Double.valueOf(args[1]);
		n = Double.valueOf(args[2]);

		ArrayList<String> Roots = new ArrayList<>();
		
		System.out.println("Your complex number is " + x + " + " + y + "i.");
		
		P = 1/(2*n);

		if((x > 0 && y > 0) || (x > 0 && y < 0))
		{
			theta = Math.atan(y/x);
			Q = newQ(x,y);
		
			Roots = root(Q,P,theta,n);
		}
		else if(x < 0 && y > 0)
		{
			theta = Math.PI - Math.abs(Math.atan(y/x));
			Q = newQ(x,y);
			
			Roots = root(Q,P,theta,n);			
		}
		else if(x < 0 && y < 0)
		{
			theta = Math.atan(y/x) - Math.PI;
			Q = newQ(x,y);
			
			Roots = root(Q,P,theta,n);		
		}
		else if(x == 0)
		{
			if(y > 0)
			{
				theta = Math.PI/2;
				Q = newQ(0,y);
				
				Roots = root(Q,P,theta,n);
			}
			else
			{
				theta = -(Math.PI/2);
				Q = newQ(0,y);
				
				Roots = root(Q,P,theta,n);
			}
		}
		else if(y == 0)
		{
			if(x > 0)
			{
				theta = 0;
				Q = newQ(x,0);
				
				Roots = root(Q,P,theta,n);
			}
			else
			{
				theta = Math.PI;
				Q = newQ(x,0);
				
				Roots = root(Q,P,theta,n);
			}
		}

		for(int i = 0; i< Roots.size(); i++)
			System.out.println(Roots.get(i));

	}		
	
	public static double newQ(double x, double y)
	{
		return Math.pow(x,2)+Math.pow(y,2);
	}


	public static ArrayList<String> root(double Q, double P, double theta, double n)
	{
		double a, b, k;
		String d_root = "";
		ArrayList<String> outRoot = new ArrayList<>();
		
		for(k = 0; k < n; k++)
		{
			a = Math.pow(Q,P)*Math.cos((theta+2*Math.PI*k)/n);
			
			b = Math.pow(Q,P)*Math.sin((theta+2*Math.PI*k)/n);
			
			if(b < 0)
				d_root = a + "-" + Math.abs(b) + "i";
			else
				d_root = a + "+" + b + "i";
			
			outRoot.add(d_root);
		}

		return outRoot;
	}			
}