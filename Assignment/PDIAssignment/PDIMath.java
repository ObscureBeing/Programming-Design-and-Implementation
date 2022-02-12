/*********************************************************
* Program: PDIMath                                       *
* Author: Muskan vig                                     *
* Date created: 8 May 2020                               *
* Date modified: 27 May 2020                             *
* Purpose: Math class to perform certain operations.     *
* Reference: Taken from my submitted worksheet-7.        *
**********************************************************/

import java.util.*;
public class PDIMath
{
    //Name: min
    //Import: a(int),b(int)
    //Export: minVar(int)
    //Calculates minimum of 2 given integers.
    
    public static int min(int a, int b)
    {
        int minVar = a;
        if(b<a)
        {
            minVar = b;
        }
        return minVar;
    }
    //Name: min
    //Import: a(double),b(double)
    //Export: minVar(double)
    //Calculates minimum of 2 given double.
 

    public static double min(double a, double b)
    {
        double minVar = a;
        if(b<a)
        {
            minVar = b;
        }
        return minVar;
    }

    //Name: min
    //Import: a(long),b(long)
    //Export: minVar(long)
    //Calculates minimum of 2 given long.
 

    public static long min(long a, long b)
    {
        long minVar = a;
        if(b<a)
        {
            minVar = b;
        }
        return minVar;
    }

    //Name: float
    //Import: a(float),b(float)
    //Export: minVar(float)
    //Calculates minimum of 2 given floats.
 
    public static float min(float a, float b)
    {
        float minVar = a;
        if(b<a)
        {
            minVar = b;
        }
        return minVar;
    }
    
    //Name: max
    //Import: a(int),b(int)
    //Export: maxVar(int)
    //Calculates maximum of 2 given integers.
 
    public static int max(int a, int b)
    {
        int maxVar = a;
        if(b>a)
        {
            maxVar = b;
        }
        return maxVar;
    }

    //Import: a(double),b(double)
    //Export: maxVar(double)
    //Calculates maximum of 2 given doubles.
 
    public static double max(double a, double b)
    {
        double maxVar = a;
        if(b>a)
        {
            maxVar = b;
        }
        return maxVar;
    }

    //Name: max
    //Import: a(long),b(long)
    //Export: maxVar(long)
    //Calculates maximum of 2 given long.
 
    public static long max(long a, long b)
    {
        long maxVar = a;
        if(b>a)
        {
            maxVar = b;
        }
        return maxVar;
    }

    //Name: max
    //Import: a(float),b(float)
    //Export: maxVar(float)
    //Calculates maximum of 2 given floats.
 
    public static float max(float a, float b)
    {
        float maxVar = a;
        if(b>a)
        {
            maxVar = b;
        }
        return maxVar;
    }
    
    //Name: abs
    //Import: a(int)
    //Export: a(int)
    //Calculates absolute value of integer.
 
   public static int abs(int a)
    {
        if(a<0)
        {
            a = -a;
        }
        return a;
    }

    //Name: abs
    //Import: a(double)
    //Export: a(double)
    //Calculates absolute value of double.
 
   public static double abs(double a)
    {
        if(a<0.0)
        {
            a = -a;
        }
        return a;
    }

    //Name: abs
    //Import: a(long)
    //Export: a(long)
    //Calculates absolute value of long.
 
   public static long abs(long a)
    {
        if(a<0)
        {
            a = -a;
        }
        return a;
    }

    //Name: abs
    //Import: a(float)
    //Export: a(float)
    //Calculates absolute value of float.
 
   public static float abs(float a)
    { 
        if(a<0.0)
        {
            a = -a;
        }
        return a;
    }

    //Name: floor
    //Import: a(double)
    //Export: floorVar(double)
    //Calculates floor value.
 
    public static double floor(double a)
    {
        double floorVar;
        
        if(a >= 0.0)
        {
            if(a == a/0.0)
            {
                floorVar = a/0.0;
            }
            else
            {
                floorVar = (int)a;
            }
        }
        
        else 
        {   
            if(a == -a/0.0)
            {
                floorVar = -a / 0.0;
            }

            else
            {
                if( a % 1.0 == 0.0)
                {
                    floorVar = (int)a;
                }
                else
                 {
                    floorVar = (int)a - 1;
                 }   
            }
        }
        
        return floorVar;
    }

    //Name: ceil
    //Import: a(double)
    //Export: ceilVar(double)
    //Calculates ceil value.
 
    public static double ceil(double a)
    {   
        double ceilVar;
        if(a >= 0.0)
        {
            if( a == a/0.0)
            {
                ceilVar = a/0.0;
            }
            else
            {
                if(a % 1.0 == 0.0)
                {
                    ceilVar = (int)a;
                }
            
                else 
                {
                    ceilVar = (int)a + 1;
                }
            }
        }
        
        else 
        {
            if(a == -a / 0.0)
            {
                ceilVar = -a / 0.0;
            }
            else
            {
                ceilVar = (int)a;
            }
        }
        return ceilVar;
    }
    
    //Name: pow
    //Import: base(double), exponent(double)
    //Export: powVar(double)
    //Calculates exponent to value.
 
    public static double pow(double base, int exponent)
    {
        double powVar = 1;
        if(exponent>=0)
        {
            for(int ii = 0; ii <exponent; ii++)
            {
                powVar *= base;
            }
        }
        else 
        {
            exponent = abs(exponent);
            for(int jj = 0; jj < exponent; jj++)
            {
                powVar *= 1/base;
            }
        }
        return powVar;
    }

    //Name: pi
    //Import: precision(int)
    //Export: piVar(double)
    //Calculates pi upto given precision.
 
    public static double pi(int precision)
    {
        double piVar = 0.0;
        for(int ii = 0; ii < precision ; ii++)
        {
            double top = pow(-1, ii);
            piVar += top / ((2.0 * (double)ii) + 1.0);
        }        
        
        return piVar * 4;
    }

    //Name: e
    //Import: precision(int)
    //Export: eVar(double)
    //Calculates value of e upto given precision.
 

    public static double e(int precision)
    {
        double eVar = 0.0;        
        for(int ii = 0; ii < precision ; ii++)
        {
            eVar += 1.0 / (double)calcFactorial(ii);
        }
        return eVar;
    }

    //Name: calcFactorial
    //Import: n(int)
    //Export: fact(int)
    //Calculates factorial of n.
 

    public static int calcFactorial(int n)
    {
        int fact  = 1;
        for(int jj = 2; jj <= n; jj++)
        {
            fact *= jj;
        }
        return fact;
    }    

} //End PDIMath

