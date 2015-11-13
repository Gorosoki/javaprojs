import java.lang.Math;
/**
 * Calculus allows us to numerically approximate common Calculus operations.
 * 
 * @author Aaron Mead & Gavin Goroski
 * @version October 16, 2012
 */

public class Calculus
{   
    public static double simulateIntegration (double lowerBound, double upperBound, int numberRectangles)
    {
        
        int i=1;
        double width = (upperBound-lowerBound)/ (double) numberRectangles;
        double height = 0;
        double area = 0.0;
        double areatemp = 0.0;
//            while (i<=numberRectangles)
//            {
//                x = lowerBound + height * 
//            }
        
        while (i<=numberRectangles)
        {      
               height = Math.pow((((.5*width)+((width*i)-width))+lowerBound),2);
               areatemp = height*width;
               area += areatemp;
               i++;
           
           
        }

        return area;
    }

    private static double function (double x)
    {
        return x * x;
    }
}