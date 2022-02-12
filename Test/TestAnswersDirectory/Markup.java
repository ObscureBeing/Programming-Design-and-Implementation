/***************************************************************************************************************************
* Program: Markup                                                                                                          *
* Author: Muskan vig                                                                                                       *
* Date created: 29 April 2020                                                                                              *
* Date modified:                                                                                                           *
* Purpose: Calculates the vale of Markup's constant and display values of all individual terms and final value of markup.  *
****************************************************************************************************************************/

import java.util.*;
public class Markup
{
    public static void main(String[] args)  //Main submodule.
    {
        Scanner sc = new Scanner(System.in);
        int numberOfTerms;
        numberOfTerms = inputN("Please enter a number bewteen 2 and 35 (inclusive 2 and 35)", 2, 35, sc); //calls inputN submodule.
        int precisionK;
        precisionK = inputK("Please enter a number between 5 and 100 (inclusive 5 and 100)", 5, 100, sc); //calss inputK submodule.
        double[] array = new double[numberOfTerms+1];
        
        for(int ii = 0; ii < numberOfTerms; ii++)
        {
            array[ii] = calcTerm(ii, numberOfTerms, precisionK);
        }

        array[numberOfTerms] = calcMarkup(array);  //calls calcMarkup submodule.
        outputArrayContents(array);                //calls outputArrayContents submodule.
    } //end main

    /******************************************************************************************
    * Name: inputN                                                                            *
    * Import: prompt(String), lower(Int), upper(Int), sc(Scanner) (OBJCET OF CLASS SCANNER)   *
    * Export: value(Int)                                                                      *
    * Purpose: input value in the range of lower and upper inclusive.                         *
    *******************************************************************************************/

    public static int inputN(String prompt, int lower, int upper, Scanner sc)
    {
        int value;
        String outputPrompt = prompt;
        do
        {
            System.out.println(outputPrompt);
            value = sc.nextInt();
            outputPrompt =  "Error, please enter a number in valid range. \n" + prompt;
        }while(value < lower || value > upper);
        return value;
    } //end inputN

    /*****************************************************************************************
    * Name: inputK                                                                           *
    * Import: prompt(String), lower(int), upper(int), sc(Scanner) (OBJECT OF CLASS SCANNER)  *
    * Export: value(int)                                                                     *
    * Purpose: input value in the range of lower and upper inclusive.                        *
    ******************************************************************************************/

    public static int inputK(String prompt, int lower, int upper, Scanner sc)
    {
        int value;
        String outputPrompt = prompt;
        do
        {
            System.out.println(outputPrompt);
            value = sc.nextInt();
            outputPrompt = "Error, please enter a number in valid range. \n" + prompt;
        }while(value < lower || value > upper);
        return value;
    } //end inputK

    /*****************************************
    * Name: calcTerm                         *
    * Import: i(int), n(int), k(int)         *
    * Export: term(int)                      *
    * Purpose: calculates value of each ter. *
    ******************************************/

    public static double calcTerm(int i, int n, int k)
    {
        double top, bottom, term = 0;
        for(int jj = 1; jj < n; jj++)
        {
            top = (double)Math.pow(i+1, 2) * (calcJ(k) + 1.0);
            bottom = 4.0 * (double)n * (double)k;
            term = (double)top / (double)bottom;
        }
        return term;
    } //end calcTerm

    /*****************************************
    * Name: calcJ                            *
    * Import: k(int)                         *
    * Export: value(int)                     *
    * Purpose: calculates value of j.        *
    ******************************************/

    public static double calcJ(int k)
    {  
        double value = 0.0;
        for(int j = 1; j <= k; j++)
        {
            value *= j;
        }
        return value;
    } //end calcJ

    /********************************************************************************
    * Name: calcMarkup                                                              *
    * Import: array(double)                                                         *
    * Export: sum(double)                                                           *
    * Purpose: calculate value of markup constant by calculating sum of each term.  *
    *********************************************************************************/

    public static double calcMarkup(double array[])
    {
        double sum = 0.0;
        for(int kk = 0; kk < array.length; kk++)
        {
            sum += array[kk];
        }
        return sum;
    } //end calcMarkup

    /************************************************************
    * Name: outputArrayContents                                 *
    * Import: array(double)                                     *
    * Export: none                                              *
    * Purpose: will output all the elements of array on screen. *           
    *************************************************************/

    public static void outputArrayContents(double array[])
    {
        for(int count = 0; count < array.length; count++)
        {
            System.out.print(array[count] + " ");
        }
        System.out.print("\n");
    } //end outputArrayContents

} //end
