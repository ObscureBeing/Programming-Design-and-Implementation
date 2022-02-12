/*****************************************************************************************************
* Program: Menu                                                                                      *
* Author: Muskan vig                                                                                 *
* Date created: 25 May 2020                                                                          *
* Date modified:                                                                                     *
* Purpose: It has submodules which have their own jon. One submodule has one action to perform.      *
* It has the main working, menu flow and design of the assignment.                                   *
******************************************************************************************************/

import java.util.*;
public class Menu
{

    /*********************************************************************************
    * Name: importImage                                                              *
    * Import: sc(Scanner)                                                            *
    * Export: array(int[][])                                                         *
    * Purpose: Allows to import image by display menu from either file or manually.  *
    **********************************************************************************/    

    public static int[][] importImage(Scanner sc)
    {
        int choice;
        int[][] array = null;
        UserInterface.display("How you want to get the image? \n");
        UserInterface.display("1.From File. \n");
        UserInterface.display("2.Manually input. \n");
        choice = UserInterface.userInput("Please enter (inclusive)", 1,2);

        switch(choice)
        {
            case 1: char fileType;
                    array = menu(sc);
                    break;
            case 2: array = userInputImage(sc);
                    break;
            default: UserInterface.display("Please choose a valid option.");
        }
        return array;
        
    } //End importImage.

    /*********************************************************************************************
    * Name: menu                                                                                 *
    * Import: sc(Scanner)                                                                        *
    * Export: imageArray(int[][])                                                                *
    * Purpose: Allows the user to choose image in different file format and reads accordingly.   *
    **********************************************************************************************/

    public static int[][] menu(Scanner sc)
    {
        char option;
        String csvFile, pngFile;
        int[][] imageArray = null; 
        UserInterface.display("What file would you like to choose? \n");
        UserInterface.display("(C)SV \n");
        UserInterface.display("(P)NG \n");
    
        option = UserInterface.userInput("Please enter (C)(c) or (P),(p)", 'C', 'P');
        
        switch(option)
        {   
            case 'c' : case 'C' : UserInterface.display("Please enter the filename of the CSV with(.csv) extension : ");
                                  csvFile = UserInterface.userInput("");
                                  imageArray = FileIO.readFile(csvFile); //reads file by calling readFile msubmodule of static class FileIO.
                                  break;                                //reads file in 2D array.
            case 'p' : case 'P' : UserInterface.display("Please enter the filename of the PNG with(.png) extension : ");
                                  pngFile = UserInterface.userInput("");
                                  imageArray = FileIO.readPNG(pngFile); //reads PNG by calling readPNG submodule of static class FileIO.
                                  break;
            default: 
            UserInterface.display("Please enter valid file type. \n");
            
        }
        return imageArray;
    } //End menu.

    /************************************************************************************
    * Name: userInputImage                                                              *
    * Import: sc(Scanner)                                                               *
    * Export: myImage(int[][])                                                          *
    * Purpose: inputs image by user manually when user chooses to do so from the menu.  *
    *************************************************************************************/

    public static int[][] userInputImage(Scanner sc)
    {
        int rows, cols;
        UserInterface.display("Please enter in the x-dimension: ");
        cols = UserInterface.userInput("Image's size will be validated in Image class.",0,2147483647);
        UserInterface.display("Please enter in the y-dimension: ");
        rows = UserInterface.userInput("Image's size will be validated in Image class.",0,2147483647);

        int[][] myImage = new int[rows][cols];  

        UserInterface.display("These Coordinates are (x,y) \n");
        //Fills the 2D array, image.
        for(int col = 0; col < cols; col++)  
        {
            for(int row = 0; row < rows; row++)
            {
                UserInterface.display("(" + (col+1) + "," + (row+1) + ") : ");
                myImage[row][col] = UserInterface.userInput("Please enter values (inclusive) for ("
                +(col+1) +","+(row+1) + ") :", 0, 255);
           
            }
        }   
        sc.nextLine();
        return myImage;
        
    } //End userInputImage.

    /***********************************************************************************************
    * Name: importKernel                                                                           *
    * Import: sc(Scanner)                                                                          *
    * Export: kernelArray(int[][])                                                                 *
    * Purpose: Allows user to choose the option for importing kernel either from file or manually. *
    ************************************************************************************************/

    public static int[][] importKernel(Scanner sc)
    {
        int choice;
        String csvFile;
        int[][] kernelArray = null;
        UserInterface.display("How you want to get the kernel? \n");
        UserInterface.display("1.File (.csv) \n");
        UserInterface.display("2.Manually input \n");
        choice = UserInterface.userInput("Either 1 or 2.", 1, 2);

        switch(choice)
        {
            case 1: UserInterface.display("Please enter the filename of the CSV : ");
                    csvFile = UserInterface.userInput("with(.csv) extension."); 
                    kernelArray = FileIO.readFile(csvFile); //reads csv file in 2D array by calling readFile submodule of static class FileIO.
                    break;
            case 2: kernelArray = userInputKernel(sc);
                    break;
            default:
        }
        return kernelArray;
    } //End importKernel.

    /****************************************************
    * Name: userInputKernel                             *
    * Import: sc(Scanner)                               *
    * Export: myKernel(int[][])                         *
    * Purpose: Allows user to import kernel manually.   *
    *****************************************************/

    public static int[][] userInputKernel(Scanner sc)
    {
        int size;
        UserInterface.display("Please enter in the kernel size k: ");
        size = UserInterface.userInput("It will velidated to be less than image's size", 0, 2147483647);
        
        int[][] myKernel = new int[size][size];
        UserInterface.display("These Coordinates are (x,y) \n");

        for(int ii = 0; ii < size ; ii++)
        {
            for(int jj = 0; jj < size; jj++)
            {
                UserInterface.display("(" + (ii+1) + "," + (jj+1) + ") : ");
                myKernel[jj][ii] = UserInterface.userInput("", -2147483648, 2147483647);
            }
        }
        return myKernel;
        
    } //End userInputKernel.

    /***********************************************************************
    * Name: convolution                                                    *
    * Import: myImage(Image), kernel(int[][])                              *
    * Export: convolutedImage(int[][])                                     *
    * Purpose: will perform convolution on the image and kernel imported.  *
    ************************************************************************/

    public static int[][] convolution(Image myImage, int[][] kernel)
    {
        int[][] convolutedImage;
        convolutedImage = myImage.convolution(kernel);
        return convolutedImage;
    } //End convolution.

    /************************************************************************************************
    * Name: exportImage                                                                             *
    * Import: resultArray(int[][]), sc(Scanner)                                                     *
    * Export: none                                                                                  *
    * Purpose: writes the the result on file according to the format chosen that is, CSV or PNG.    *
    *************************************************************************************************/

    public static void exportImage(int[][] resultArray, Scanner sc)
    {
        String fileName;
        String subFileName;
        String writeFileName;
        int date;
        char choice;
        UserInterface.display("Please enter the File Name to be saved with : ");
      
        fileName = UserInterface.userInput(""); 
        UserInterface.display("What filetype would you like to save with? (C)SV pr (P)NG: ");
        choice = sc.next().charAt(0);

        switch(choice)
        {
            case 'c' : case 'C' :
            UserInterface.display("Please enter a date to save with in (DDMMYYYY) format: ");
            date = UserInterface.userInput("",00000000,99999999);
            subFileName = splitDate(date);
            writeFileName = subFileName + "_Processed_" + fileName + ".csv";
            FileIO.writeFile(writeFileName, resultArray); //writes 2D array on a csv File.
            UserInterface.display("File " + "(" + writeFileName + ") \n");
            break;

            case 'p' : case 'P' :
            UserInterface.display("Please enter a date to save with in (DDMMYYYY) format: ");
            date = UserInterface.userInput("",00000000,99999999);  //inputs date upto 8 digits only.
            subFileName = splitDate(date);
            writeFileName = subFileName + "_Processed_" + fileName + ".png";
            FileIO.writePNG(writeFileName, resultArray); //writes PNG to a .png File.
            UserInterface.display("File " + "(" + writeFileName + ") \n");
            break;

            default:
            UserInterface.display("Invalid file type.\n");

        }
    } //end exportImage.

    /************************************************************************************************
    * Name: splitDate                                                                               *
    * Import: date(int)                                                                             *
    * Export: subName(String)                                                                       *
    * Purpose: splits the date in its components and return the formatted date to save file with.   *
    *************************************************************************************************/

    public static String splitDate(int date)
    {
        int day, month, year;
        String subName;

        day = date/1000000;
        // stores the date with only MMYYYY part
        date %= 1000000;

        // stores the month, MM by truncating date's value (MMYYYY)
        month = date/10000;

        // stores the year YY with only YYYY part
        year = date%10000;

        Date newDate = new Date(day, month, year);
        subName = newDate.toFileString();
       // System.out.println(subName);
        return subName;
    } //End splitDate.

    /****************************************************************
    * Name: smoothing                                               *
    * Import: myImage(int[][])                                      *
    * Export: myImage(int[][])                                      *
    * Purpose: Performs smoothing operation on the imported image.  *
    *****************************************************************/


    public static int[][] smoothing(int[][] myImage)
    {
        Scanner sc = new Scanner(System.in);
        int smoothSurface, pixelX, pixelY, valueZ, minX, minY, maxX, maxY;
        int counter = 1;
        double smoothFactor;
        double sum = 0.0, avg;
        String outputPrompt = "Please enter a smoothing surface (odd) : ";
        //will loop unless user enters correct value of smoothing surface which will be odd.
        do 
        {  
            UserInterface.display(outputPrompt + "\n");
            smoothSurface = UserInterface.userInput("Odd less than Image's length - 1 to account boundaries : ",1,101);
            outputPrompt = "Error," + outputPrompt;
        }while(smoothSurface % 2 == 0);

        UserInterface.display("Please enter a pixel to smooth (x,y): ");
        UserInterface.display("Enter x coordinate :");
        pixelX = sc.nextInt();
        UserInterface.display("Enter y coordinate :");
        pixelY = sc.nextInt();
        UserInterface.display("Please enter a smoothness factor between 0 and 1 (inclusive): ");
        smoothFactor = UserInterface.userInput(" ", 0.0, 1.0);
        valueZ = (smoothSurface-1) / 2;

        minX = pixelX - valueZ;
        minY = pixelY - valueZ;

        maxX = pixelX + valueZ;
        maxY = pixelY + valueZ;
    
        for(int i = minX; i <= maxX; i++) //sums the values of smooth surface.
        {
            for(int j = minY; j <= maxY; j++)
            {
                sum += myImage[i][j] * smoothFactor;
                counter = counter + 1; 
            }
        }   
    
        avg = sum / counter;
        int smoothValue = (int)PDIMath.ceil(avg); //ceil the value to be filled in smooth surface.

        for(int ii = minX; ii <= maxX; ii++)
        {
            for(int jj = minY; jj <= maxY; jj++)
            {
                myImage[ii][jj] = smoothValue;
            }
        }
    
        return myImage;

    } //End smoothing.

} //End Menu.
