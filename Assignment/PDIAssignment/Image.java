/***************************************************
* Name: Image                                      *
* Date created: 10 May 2020                        *
* Date modified: 27 May 2020                       *
* Purpose: Image class (Model class).              *
* Reference: Taken from my submitted worksheet-6   *
****************************************************/

public class Image
{
    private int[][] originalImage = new int[][] {};  //class field.


    /*****************************************
     * Default Constructor:                  *
     * IMPORT: none                          *
     * EXPORT: address of new Image object   *
     * ASSERTION: originalImage[][] values.  *
     *****************************************/
    public Image()
    {
        originalImage = new int[][] {{1,1,1,1},{1,0,0,2},{1,2,1,2},{1,0,0,1}};
    }

    /*******************************************
     * Alternate Constructor:                  *
     * IMPORT: inOriginalImage (Integer)       *
     * EXPORT: address of new Image object     *
     * ASSERTION: Creates the object           *
     *******************************************/
    public Image(int[][] inOriginalImage)
    {
        setOriginalImage(inOriginalImage);
    }

    /******************************************************************************
     *Copy Constructor:                                                           *
     *IMPORT: inImage (Image)                                                     *
     *EXPORT: address of new Image object                                         *
     *ASSERTION: Creates an object with an identical object state as the import.  *
     ******************************************************************************/
    public Image(Image inImage)
    {
        int[][] copyImage = inImage.getOriginalImage();
        originalImage = new int[copyImage.length][copyImage[0].length];
        for(int i=0; i<copyImage.length; i++)
        { 
            for(int j=0; j<copyImage[i].length; j++)
            {       
                //originalImage[i][j] = inImage.getOriginalImage()[i][j];
                originalImage[i][j] = copyImage[i][j];

            }
        }
    }

    //MUTATORS
    /*********************************************************
     * SUBMODULE: setOriginalImage                           *
     * IMPORT: inOriginalImage (Integer)                     *
     * EXPORT: none                                          *
     * ASSERTION: sets the originalImage to inOriginalImage. *
     *********************************************************/
    public void setOriginalImage(int[][] inOriginalImage)
    {
            originalImage = new int[inOriginalImage.length][inOriginalImage[0].length];
            for(int i = 0; i < inOriginalImage.length; i++)
            {
                for(int j = 0; j < inOriginalImage[i].length; j++)
                {
                    originalImage[i][j] = inOriginalImage[i][j];
                }
            }
    }
    
    
     //Accessor.
    //getOriginalImage().
        
    public int[][] getOriginalImage()
    {    int[][] newOriginalImage = new int[originalImage.length][originalImage[0].length];
        for(int i=0; i<originalImage.length; i++)
        { 
            for(int j=0; j<originalImage[i].length; j++)
            {       
                newOriginalImage[i][j] = originalImage[i][j];
            }
        }
 
        return newOriginalImage;
    }

    /***********************************************************************************
     * SUBMODULE: equals                                                               *
     * IMPORT: inObj (Object)                                                          *
     * EXPORT: same                                                                    *
     * ASSERTION: Two image are interchangeable if they have the same original image.  *
     ***********************************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = true;
        int count = 0;
        if(inObj instanceof Image)
        {
            Image inImage = (Image)inObj;

            if((inImage.originalImage.length == originalImage.length) && (inImage.originalImage[0].length == originalImage.length))
            {
                for(int i=0; i<inImage.originalImage.length; i++)
                {
                    for(int j=0; j<inImage.originalImage[0].length; j++)
                    {
                        if(originalImage[i][j] != (inImage.getOriginalImage()[i][j]))
                        {
                            same = false;
                        }
                    }
                }
            }    
            else
            {
                same = false;
            }
                
        }
        return same;
    }

    public Image clone()
    {
        return new Image(this);
    }

    //Name: toString
    //Imports: none
    //Export: aString(String
    //Purose: returns a string of classfield.
    
    public String toString()
    {
        String aString = " ";
        for(int row = 0; row < originalImage.length; row++) 
        {
            for(int col = 0; col < originalImage[row].length; col++) 
            {
                aString += " " + originalImage[row][col];
            }
            aString += "\n";
        }
        return aString;
    }

    /*******************************************************************************
    * Name: convolution                                                            *
    * Import: kernel(int[][])                                                      *
    * Export: result(int [][])                                                     *
    * Purpose: performs calculation on imported kernel matrix and original matrix. *
    ********************************************************************************/

    public int[][] convolution(int[][] kernel)
    {
        int[][] result = new int[originalImage.length-kernel.length+1][originalImage[0].length-kernel.length+1];
        
        if(validateOriginalImage(originalImage, kernel))
        {
        for(int r=0; r<originalImage.length-kernel.length+1; r++) 
            {   
                for(int l=0; l<originalImage[0].length-kernel.length+1; l++)
                { 
                    for(int s = 0; s<kernel.length; s++)
                    {
                        for(int q=0; q<kernel.length; q++)
                        {   
                            result[r][l] += originalImage[r+s][l+q] * kernel[s][q]; 
                        } //ASSERTION: Ends when q > Kernel's size.
                    }    //ASSERTION: Ends when s > Kernel's size.
                 }      //ASSERTION: Ends when l > original image's column size.
            }          //ASSERTION: Wnds when r > original image's row size.
        }
        else
        {
            throw new IllegalArgumentException("Invalid original image");
        }
        return result;
    }//End convolution.


    
    /*************************************************************************************************
     * SUBMODULE: validateOriginalImage                                                              *
     * IMPORT: inOriginalImage (Integer)                                                             *
     * EXPORT: valid (boolean)                                                                       *
     * ASSERTION: inOriginalImage matrix's size must be equal to or greater than kernel matrix size  *
    **************************************************************************************************/
   private boolean validateOriginalImage(int[][] originalImage, int[][] kernel)
    {
        return ((originalImage.length >= kernel.length) && (originalImage[0].length >= kernel.length));
      
    }
}// End Image.

