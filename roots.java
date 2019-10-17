import java.lang.Math;
import java.util.*;

public class roots
{
	public static void main(String[] args)
	{
		double 	x, y, n;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the value of x: ");
		x = s.nextDouble();
		System.out.print("Enter the value of y: ");
		y = s.nextDouble();
		System.out.print("Enter the desired root: ");
		n = s.nextDouble();
		
		if(n > 0)
		{
			ArrayList<String> Roots = new ArrayList<>();
		
			System.out.println("The complex number is " + x + " + " + y + "i.");
			
			Roots = root(x, y, getTheta(x, y), n);

			System.out.println("The roots are: ");
			for(int i = 0; i< Roots.size(); i++)
				System.out.println(Roots.get(i));
		}
		else
			System.out.println("The value of n cannot be negative (or zero).");
		
		s.close();
	}		

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
	
	public static ArrayList<String> root(double x, double y, double theta, double n)
	{
		double a, b, k, p, Q;
		String d_root;
		ArrayList<String> outRoot = new ArrayList<>();

		Q = Math.pow(x,2)+Math.pow(y,2);
		p = 1/(2*n);
		
		for(k = 0; k < n; k++)
		{
			a = Math.pow(Q,p)*Math.cos((theta+2*Math.PI*k)/n);
			b = Math.pow(Q,p)*Math.sin((theta+2*Math.PI*k)/n);
			
			if(b < 0)
				d_root = a + "-" + Math.abs(b) + "i";
			else
				d_root = a + "+" + b + "i";
			
			outRoot.add(d_root);
		}

		return outRoot;
	}			
}