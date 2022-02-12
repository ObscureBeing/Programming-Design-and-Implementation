/*****************************************************************************************
* Program: DetectEdges                                                                   *
* Author: Muskan vig                                                                     *
* Date created: 28 May 2020                                                              *
* Purpose: Entry point for assignemnt and calls methods of static classes.               *
* program to detect horizontal and vertical lines in a PNG (Portable Network Graphic).   *
******************************************************************************************/

import java.util.*;
import java.io.*;
public class DetectEdges
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[][] mainImage;
        int[][] kernel;
        int[][] result = null;
        int operation;

        UserInterface.display("=> Import Image. \n");
        mainImage = Menu.importImage(sc);
        Image myImage = new Image(mainImage);

        UserInterface.display("=> Import Kernel. \n");
        kernel = Menu.importKernel(sc);

        UserInterface.display("=>Which operation you want to perform? \n");
        UserInterface.display("1. Convolution \n");
        UserInterface.display("2. Smoothing \n");
        operation = UserInterface.userInput("",1,2);

        switch(operation)
        {
            case 1: result = Menu.convolution(myImage, kernel);
            break;

            case 2: result = Menu.smoothing(mainImage);
            break;
        }

        UserInterface.display("=> Export Image. \n");
        Menu.exportImage(result, sc);
    
    } //End Main.
}// End DetectEdges.

