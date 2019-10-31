/* A simple program to calculate the nth root of a complex number
 * of the form z = x + yi.
 * 
 * The user must enter the x and y of the complex number and the root
 * that they wish to find.
 * (For the second root, the user would enter 2 for n.)
 * 
 * Created by Eric Sullivan on October 31st, 2019.
*/
using System;
using System.Collections;

namespace ComplexRoots
{
    class Program
    {
        /* Takes prompted user input (from the comand line) and calculates the 
         * desired roots of a specified complex number (which the user also selects), 
         * then displayes those roots to the screen.
         */
        static void Main(string[] args)
        {
            double x, y, n;
            
            //It is possible that an exception might occur here.
            try
            {
                Console.Write("Enter the value of x: ");
                x = Double.Parse(Console.ReadLine());

                Console.Write("Enter the value of y: ");
                y = Double.Parse(Console.ReadLine());

                Console.Write("Enter the desired root: ");
                n = Double.Parse(Console.ReadLine());

                //Checks the value of n.
                if (n > 0.0)
                {
                    //Creates the arraylist for the roots of the user's complex number.
                    ArrayList Roots = new ArrayList((int)n);

                    //Displays the user's complex number to the screen.
                    Console.WriteLine("");
                    if (y > 0)
                        Console.WriteLine($"The complex number is {x} + {y}i.");
                    else
                        Console.WriteLine($"The complex number is {x} + {Math.Abs(y)}i.");

                    //Calculates the roots of the user's complex numebr.
                    Roots = Root(x, y, n);

                    //Prints the roots of the user's complex number to the screen.
                    Console.WriteLine("The roots are: ");
                    foreach (Object obj in Roots)
                        Console.WriteLine(" {0}", obj);

                    Console.ReadKey();

                    //Empties the arraylist of roots.
                    Roots.Clear();
                }
                else
                    Console.WriteLine("The value of n cannot be negative (or zero).");
            }
            catch (Exception e)
            {
                //Console.Write(e.StackTrace);
                Console.WriteLine("All inputs are numbers only!");
                Console.ReadKey();
            }
        }

        /* Determines the sutiable value for theta, the angle formed by the
         * user's complex number in the complex plane, based on the x and y
         * values of the user's complex number.
         * 
         * The values x and y are passed in as arguments.
         */
        public static double GetTheta(double x, double y)
        {
            if ((x > 0 && y > 0) || (x > 0 && y < 0))
                return Math.Atan(y / x);
            else if (x < 0 && y > 0)
                return Math.PI - Math.Abs(Math.Atan(y / x));
            else if (x < 0 && y < 0)
                return Math.Atan(y / x) - Math.PI;
            else if (x == 0)
            {
                if (y > 0)
                    return Math.PI / 2;
                else
                    return -(Math.PI / 2);
            }
            else if (y == 0)
            {
                if (x > 0)
                    return 0.0;
                else
                    return Math.PI;
            }
            else
                return 0.0;
        }

        /* Calculates the roots of the given complex number, converts them to a string
         * then adds them to an arraylist. This arraylist contains all roots of the
         * given complex number. Once all the roots are calculated, the arraylist containing
         * the roots is then returned. The number of roots is determined by the value of n.
         * 
         * The values x, y, and n are passed in as arguments.
         */
        public static ArrayList Root(double x, double y, double n)
        {
            double a, b, k, p, Q, theta;
            String d_root;
            ArrayList outRoot = new ArrayList();

            Q = Math.Pow(x, 2) + Math.Pow(y, 2);
            p = 1 / (2 * n);

            //Get the correct value of theta
            theta = GetTheta(x, y);

            //Loop to get all the roots
            for(k = 0; k < n; k++)
            {
                //Root of the complex number in the form a + bi.
                a = Math.Pow(Q, p) * Math.Cos((theta + 2 * Math.PI * k) / n);
                b = Math.Pow(Q, p) * Math.Sin((theta + 2 * Math.PI * k) / n);

                //Root is recorded as a string.
                if (b < 0)
                    d_root = a + "-" + Math.Abs(b) + "i";
                else
                    d_root = a + "+" + b + "i";

                //Root is added to the arraylist of roots.
                outRoot.Add(d_root);
            }
            //The arraylist of roots is returned.
            return outRoot;
        }
    }
}