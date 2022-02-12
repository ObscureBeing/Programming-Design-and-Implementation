/***************************************
* Name: ImageTestHarness.              *
* Author: Muskan vig                   *
* Date created: 29 May 2020.           *
* Purpose: Will test the Image class.  *
****************************************/

import java.util.*;

public class ImageTestHarness
{           
    public static final int[][] MATRIX_A =
    {
        {10, 10, 10,  0,  0,  0},
        {10, 10, 10,  0,  0,  0},
        {10, 10, 10,  0,  0,  0},
        {10, 10, 10,  0,  0,  0},
        {10, 10, 10,  0,  0,  0},
        {10, 10, 10,  0,  0,  0}
     }; 


    public static void main(String[] args)
    {
        try
        {
            Image[] image = new Image[4];

            //object creation
            image[0] = new Image();
            image[1] = new Image(MATRIX_A);
            image[2] = new Image(image[1]);
            image[3] = image[1].clone();

            //print out created objects
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < image.length; i++)
            {
                System.out.println("Image[" + i + "]: " + image[i].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + image[1].equals(image[3]));
            System.out.println("Equals (object) expected FALSE: " + image[0].equals(image[3]));
   
            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");  

         
             int[][] finalResult = new int[image[1].getOriginalImage().length-Kernel.VERTICAL.length+1][image[1].getOriginalImage().length-Kernel.VERTICAL.length+1];
            
            finalResult = image[1].convolution(Kernel.VERTICAL);



            for(int y = 0; y<image.length; y++)
            {
                String array = image[y].toString();
                System.out.println(array);
            }
            
                
            for(int i = 0; i < finalResult.length; i++)
            {
                for(int j = 0; j < finalResult[i].length; j++)
                {
                    System.out.print(finalResult[i][j] + " ");
                }
                System.out.print("\n");
            }
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
