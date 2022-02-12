/**********************************
* Name: ImageTestHarness          *
* Author: Muskan vig              *
* Date created: 29 May 2020       *
* Purpose: Tests the Image class. *
***********************************/

import java.util.*;

public class DateTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            Date[] date = new Date[4];

            //object creation
            date[0] = new Date();
            date[1] = new Date(20,5,2020);
            date[2] = new Date(date[1]);
            date[3] = date[1].clone();

            //print out created objects
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < date.length; i++)
            {
                System.out.println("date[" + i + "]: " + date[i].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + date[1].equals(date[3]));
            System.out.println("Equals (object) expected FALSE: " + date[0].equals(date[3]));
   
            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            date[0].setDay(date[1].getDay(), date[0].getMonth(), date[0].getYear());
            System.out.println(date[0].getDay() + " = " + date[1].getDay());

            date[0].setMonth(date[2].getMonth());
            System.out.println(date[0].getMonth() + " = " + date[2].getMonth());

            date[0].setYear(date[1].getYear());
            System.out.println(date[0].getYear() + " = " + date[1].getYear());

            System.out.println("formatted date: ");
            String name = date[0].toFileString();
            System.out.println(name);

         //   System.out.println(date[0].getGrade(student[1].getMark()));
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}// End ImageTestHarness.
