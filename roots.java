import java.lang.Math;
import java.util.*;

public class roots
{
	public static void main(String[] args)
	{
		double 	x2, y2, n, Q, P, theta;
		
		if(args.length == 0 || args.length < 3)
		{
			System.out.println("Usage: java roots <x value> <y value> <desired root>");
			System.exit(0);
		}
		
		ArrayList<String> Roots = new ArrayList<>();
		
		x2 = Double.valueOf(args[0]);
		y2 = Double.valueOf(args[1]);
		n = Double.valueOf(args[2]);
		
		System.out.println("Your complex number is " + x2 + " + " + y2 + "i.");
		
		P = 1/(2*n);

		if((x2 > 0 && y2 > 0) || (x2 > 0 && y2 < 0))
		{
			theta = Math.atan(y2/x2);
			Q = Math.pow(x2,2)+Math.pow(y2,2);
		
			Roots = root(Q,P,theta,n);
		}
		else if(x2 < 0 && y2 > 0)
		{
			theta = Math.PI - Math.abs(Math.atan(y2/x2));
			Q = Math.pow(x2,2)+Math.pow(y2,2);
			
			Roots = root(Q,P,theta,n);			
		}
		else if(x2 < 0 && y2 < 0)
		{
			theta = Math.atan(y2/x2) - Math.PI;
			Q = Math.pow(x2,2)+Math.pow(y2,2);
			
			Roots = root(Q,P,theta,n);		
		}
		else if(x2 == 0)
		{
			if(y2 > 0)
			{
				theta = Math.PI/2;
				Q = Math.pow(y2,2);
				
				Roots = root(Q,P,theta,n);
			}
			else
			{
				theta = -(Math.PI/2);
				Q = Math.pow(y2,2);
				
				Roots = root(Q,P,theta,n);
			}
		}
		else if(y2 == 0)
		{
			if(x2 > 0)
			{
				theta = 0;
				Q = Math.pow(x2,2);
				
				Roots = root(Q,P,theta,n);
			}
			else
			{
				theta = Math.PI;
				Q = Math.pow(x2,2);
				
				Roots = root(Q,P,theta,n);
			}
		}

		for(int i = 0; i< Roots.size(); i++)
			System.out.println(Roots.get(i));

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