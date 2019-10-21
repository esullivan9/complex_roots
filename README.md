# complex_roots
Determining the nth roots of a complex number
------------------------------------------------------------------------------------------------------------------------------------------

A complex number has the forms:

#1: z = x + yi (standard notation) or 

#2: z = r(cos(theta) + i sin(theta)) where r = abs(z) = sqrt(x^2 + y^2) or

#3: z = r(e^(i*theta)).

------------------------------------------------------------------------------------------------------------------------------------------

This program takes a complex number (the user enters the values for x and y) in and finds the nth roots (n is entered by the user) of it. 

The user inputs values for x and y, which determine what complex number will be used. The program then displays the complex 
number using the values of x and y which the user entered (ex: if the user entered 3 for x and -2 for y, the program would 
tell them that their complex number is 3+-2i). It then prompts them for the root they which to find (ex: if the user enters 
a 2, they have requested for the second roots of their complex number) and after they have entered this value, the program 
will display to the screen the roots (in form #1) for the selected complex number. The number of roots that will be displayed 
is determined by the value of n; thus, the number of roots displayed is equal to n - 1.

-----------------------------------------------------------------------------------------------------------------------------------------
Example: A user enters 3 for x, -5 for y and 4 for n. 

Result: The user's complex number is 3-5i and they are looking for the fourth roots of this number. The program will display the 4 roots: 
{1.50267092127-0.39587435522i, 0.39587435522+1.50267092127i, -1.50267092127+0.39587435522i, -0.39587435522-1.50267092127i}. 
