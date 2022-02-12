/*********************************************************************************************************************
* Program: FileIO                                                                                                    *
* Author: Muskan Vig                                                                                                 *
* Date created: 19 March 2020                                                                                        *
* Date modified: 29 May 2020                                                                                         *
* Purpose: Static class which reads csv files in 2D arrays, reads PNG files and writes csv, PNG files in PNG format. *
* Reference: Taken from my submitted worksheet-8.                                                                    *
**********************************************************************************************************************/

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
public class FileIO
{
    /*********************************************************************
    * Name: readFile                                                     *
    * Import: inFileName(String)                                         *
    * Export: myArray(int[][])                                           *
    * Purpose: will read a csv file in 2D array and return it to caller. *
    **********************************************************************/
    
   public static int[][] readFile(String inFileName)
    {
    
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        int[][] myArray = null;
        try
        {
            fileStream = new FileInputStream(inFileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            String[] myLine = null;
            int colSize = 0;
            line = bufRdr.readLine();
            if(line!= null)                
            {
                myLine = line.split(",");          //Gets the row size of the matrix that will store file content.
                colSize = myLine.length;          //Gets the column size of the matrix that store the file content.
            }
            while((line != null) && (colSize == myLine.length)) //Check for staggered arrays too.
            {
                lineNum ++;
                myLine = line.split(",");
                line = bufRdr.readLine();
            }
        
            myArray = new int[lineNum][colSize];
 
            myArray = inputArrayValues(myArray, inFileName);

            fileStream.close();
                    
        }
        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {}
            }
            UserInterface.displayError("Error in fileProcessing: " + e.getMessage());
        }
    
        return myArray;
    } //End readFile.

    /**************************************************************
    * Name: inputArrayValues                                      *
    * Import: myArray(int[][]), inFileName(String)                *
    * Export:  myArray(int[][])                                   *
    * Purpose: will fill 2D array with the content of csv File.   *
    ***************************************************************/
    
    public static int[][] inputArrayValues(int[][] myArray, String inFileName)
    {   
            FileInputStream fileStream = null;
            InputStreamReader rdr;
            BufferedReader bufRdr;
            int lineNum;
            String line;
            try
            {
                fileStream = new FileInputStream(inFileName);
                rdr = new InputStreamReader(fileStream);
                bufRdr = new BufferedReader(rdr);
                lineNum = 0;
                String[] myLine;
                line = bufRdr.readLine();
 
                while(line != null)
                {
                    myLine = line.split(",");
                
                        //Fills the 2D array with the content of csv file.

                        for(int col = 0; col < myArray[0].length; col++)
                        {
                            myArray[lineNum][col] = Integer.parseInt(myLine[col]);
                        }
                
                    lineNum++;
                    line = bufRdr.readLine();

                }
                fileStream.close();
            }
            catch(IOException e)
            {
        
                if(fileStream != null)
                {
                    try
                    {
                        fileStream.close();
                    }
                    catch(IOException ex2)
                    {}
                }
                UserInterface.displayError("Error in fileProcessing: " + e.getMessage());
            }
 
            return myArray;
    } //End inputArrayVaues.

    /***************************************************
    * Name: writeFile                                  *
    * Import: filename(String), writeArray(int[][])    *
    * Export: none                                     *
    * Purpose: will write a 2D array on csv file.      *
    ****************************************************/

    public static void writeFile(String filename, int[][] writeArray)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);
            for(int ii = 0; ii < writeArray.length; ii++)
            {
                for(int jj = 0; jj < writeArray[ii].length; jj++)
                {
                    pw.print(writeArray[ii][jj] + ",");   //will write 2D array on csv file element by element.
                }
                pw.print("\n");
            }
            pw.close();
        }
        catch(IOException e)
        {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                {}
            }
            UserInterface.displayError("Error in writing to file: " + e.getMessage());
        }
    } //End writeFile.

        /**********************************
        * Name: readPNG                   *
        * Import: fileName(String)        *
        * Export:image(int[][])           *
        * Purpose: will read PNG file.    *
        ***********************************/
       
        public static int[][] readPNG(String fileName)
        {
            BufferedImage img;
            File inputFile;
            int[][] image = null;
            try
            {
                // Open the file
                inputFile = new File(fileName);
                // Turn file into an Image
                img = ImageIO.read(inputFile);
                // Construct array to hold image
                image = new int[img.getHeight()][img.getWidth()];
                // Loop through each pixel
                for (int y = 0; y < img.getHeight(); y++)
                {
                    for (int x = 0; x < img.getWidth(); x++)
                    {
                        // Turn the pixel into a Color object.
                        Color pixel = new Color(img.getRGB(x, y), true);
                        // Converts each pixel to a grayscale equivalent
                        // using weightings on each colour.
                        image[y][x] = (int)((pixel.getRed() * 0.299) +
                        (pixel.getBlue() * 0.587) +
                        (pixel.getGreen() * 0.114));
                    }
                }
            }
            catch(IOException e)
            {
                UserInterface.displayError("Error with .png reading: "
                + e.getMessage());
                // Alternatively you could rethrow an IllegalArgumentException
            }
            return image;
        } //End readPNG.

        /**************************************************
        * Name: writePNG                                  *
        * Import: fileName(String), writeArray(int[][])   *
        * Export: none                                    *
        * Purpose: will write a PNG file.                 *
        ***************************************************/

        public static void writePNG(String fileName, int[][] writeArray)
        {
            // The following is very Java specific and is implemented in a way to
            // reconstruct a colour image from a set of 8bit colours.
            BufferedImage theImage;
            File outputfile;
            try
            {
                // Open the file
                outputfile = new File(fileName);
                // Construct a BufferedImage, with dimensions and of type RGB
                theImage = new BufferedImage(writeArray[0].length,
                writeArray.length,
                BufferedImage.TYPE_INT_RGB);
                // This will step through each element of our "writeArray"
                for(int y = 0; y < writeArray.length; y++)
                {
                    for (int x = 0; x < writeArray[0].length; x++)
                    {
                        // This will ensure that we are only putting a value into
                        // our png, between 0 and 255. (8bit colour depth)
                        int value = Math.abs(writeArray[y][x] % 256);
                        // Turns the greyscale pixel to a "colour" representation
                        Color newColor = new Color(value, value, value);
                        // This will set the value of the pixel within the .png
                        theImage.setRGB(x, y, newColor.getRGB());
                    }
                }
                // Write the image to a .png
                ImageIO.write(theImage,"png",outputfile);
            }
            catch(IOException e)
            {
                UserInterface.displayError("Error with .png reading: "
                + e.getMessage());
                // Alternatively you could rethrow an IllegalArgumentException
            }
        } //End writePNG.
} //END Main.

