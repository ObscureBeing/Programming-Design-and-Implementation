/**************************************************************************************************************
* Program : UserInterface                                                                                     *
* Author : Muskan vig                                                                                         *
* Date created : 8 May 2020                                                                                   *
* Date modified : 29 May 2020.                                                                                *
* Purpose : Will act as point of contact between user and program as it will and will handle the exceptions.  *
***************************************************************************************************************/

import java.util.*;
public class UserInterface
{
    /***********************************************************************
    * Name : userInput                                                     *
    * Import :prompt(String), lower(int), upper(int)                       *
    * Export : will input value in the given range and handle exceptions.  *
    * Purpose : num(int)                                                   *
    ************************************************************************/
    public static int userInput(String prompt, int lower, int upper)
    {
        int num;
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
        do
        {
            try
            {
                System.out.println(outputPrompt + " between " + lower + " and " + upper);
                num = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                num = lower - 1;
                displayError("Please enter an integer.");
            }            
            outputPrompt = "ERROR: please enter a valid value \n" + prompt;
            
        }while((num < lower) || (num > upper));
        return num;
    } //userInput ends

    /*********************************************************************
    * Name : userInput                                                   *
    * Import : prompt(String), lower(double), upper(double)              *
    * Export : num(double)                                               *
    * Purpose : Will input num in the given range and handle exceptions  *
    **********************************************************************/

    public static double userInput(String prompt, double lower, double upper)
    {
        double num;
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
        do
        {
            try
            {
                System.out.println(outputPrompt + " between " + lower + " and " + upper);
                num = sc.nextDouble();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                num = lower - 1.0;

               displayError(e.getMessage());
            }            
            
            outputPrompt = "ERROR: please enter a valid value \n" + prompt;
        }while((num < lower) || (num > upper));
        return num;
    } //userInput ends.

    /*********************************************************************
    * Name : userInput                                                   *
    * Import : prompt(string), lower(long), upper(long)                  *
    * Export : num(long)                                                 *
    * Purpose : Will input num in the given range and handle exceptions. *
    **********************************************************************/
    public static long userInput(String prompt, long lower, long upper)
    {
        long num;
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
        do
        {
            try
            {
                System.out.println(outputPrompt + " between " + lower + " and " + upper);
                num = sc.nextLong();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                num = lower - 1;

               displayError(e.getMessage());
            }            
            
            outputPrompt = "ERROR: please enter a valid value \n" + prompt;
        }while((num < lower) || (num > upper));
        return num;
    } //userInput ends.

    /***************************************************************************
    * Name : userInput                                                         *
    * Import : prompt(String), lower(float), upper(float)                      *
    * Export : num(float)                                                      *
    * Purpose : will input num in the given valid range and handle exceptions. *
    ****************************************************************************/

    public static float userInput(String prompt, float lower, float upper)
    {
        float num;
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
        do
        {
            try
            {
                System.out.println(outputPrompt + " between " + lower + " and " + upper);
                num = sc.nextFloat();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                num = lower - 1.0f;

               displayError(e.getMessage());
            }            
            
            outputPrompt = "ERROR: please enter a valid value \n" + prompt;
        }while((num < lower) || (num > upper));
        return num;
    } //userInput ends.

    /******************************************************************
    * Name : userInput                                                *
    * Import : prompt(String), lower(char), upper(char)               *
    * Export : value(char)                                            *
    * Purpose : will input value in given range and handles exception.*
    *******************************************************************/

    public static char userInput(String prompt, char lower, char upper)
    {
        char value = ' ';
        int charVar;
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
       
            try
            {
                System.out.println(outputPrompt + " either " + lower + " or " + upper);
                value = sc.next().charAt(0);
            }
            catch(InputMismatchException e)
            {
                sc.next();
                charVar = (int)lower - 1;

               displayError("Please enter a character.");
            }            
            
        return value;
    } //userInput ends.

    /****************************************************
    * Name : userInput                                  *
    * Import : prompt(String)                           *
    * Export : value(String)                            *
    * Purpose : will input string and handle exception. *
    *****************************************************/

    public static String userInput(String prompt)
    {
        String value = "";
        Scanner sc = new Scanner(System.in);
        String outputPrompt = prompt;
            do
            {        
            try
            {
                System.out.println(outputPrompt);
                value = sc.nextLine();
            }
            catch(InputMismatchException e)
            {
                sc.nextLine();

               displayError("Please enter string.");
            }
            }while(value == null);            
        
        return value;
    } //userInput ends.

    /*********************************************************
    * Name : dispalayError                                   *
    * Import : error(String)                                 *
    * Export : none                                          *
    * Purpose : outputs error message or exceptions message. *
    **********************************************************/

    public static void displayError(String error)
    {
        System.out.println("Error: please check your input ");
        System.out.println(error);

    } //displayError ends.

    /************************************
    * Name: display                     *
    * Import: outout(String)            *
    * Export: none                      *
    * Purpose: outputs string message.  *
    *************************************/

    public static void display(String output)
    {
        System.out.print(output);
    } //display ends.

} //UserInterface ends.




 

