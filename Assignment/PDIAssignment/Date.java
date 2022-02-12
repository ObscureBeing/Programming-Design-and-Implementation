/*********************************************************
* Program: Date.                                         *
* Author: Muskan vig                                     *
* Date created: 28 May 2020                              *
* Purpose: Date (model class) with date validateions.    *
**********************************************************/

public class Date
{
    //private class fields

    private int day;
    private int month;
    private int year;

    /*****************************************************
     * Default Constructor:                              *
     * IMPORT: none                                      *
     * EXPORT: address of new Date object                *
     * ASSERTION: will make object with default values.  *
     *****************************************************/
    public Date()
    {
        day = 01;
        month= 01;
        year = 2000;
    }

    /*******************************************************************************
     * Alternate Constructor:                                                      *
     * IMPORT:                                                                     *
     * EXPORT: address of new Date object                                          *
     * ASSERTION: Creates the object if the imports are valid and FAILS otherwise  *
     ********************************************************************************/
    public Date(int inDay, int inMonth, int inYear)
    {
        setDay(inDay, inMonth, inYear);
        setMonth(inMonth);
        setYear(inYear);
    }

    /******************************************************************************
     *Copy Constructor:                                                           *
     *IMPORT: inDate (Date)                                                       *
     *EXPORT: address of new Date object                                          *
     *ASSERTION: Creates an object with an identical object state as the import.  *
     ******************************************************************************/
    public Date(Date inDate)
    {
        day = inDate.getDay();
        month = inDate.getMonth();
        year = inDate.getYear();
    }

    //MUTATORS
    /**************************************
     * SUBMODULE: setDay                  *
     * IMPORT: inDay (int)                *
     * EXPORT: none                       *
     * ASSERTION: sets the day to inDay.  *
     **************************************/
    public void setDay(int inDay, int inMonth, int inYear)
    {
        if(validateDay(inDay, inMonth, inYear))
        {
            day = inDay;
        }
        else
        {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    /*********************************************************************
     * SUBMODULE: setMonth                                               *
     * IMPORT: inMonth (int)                                             *
     * EXPORT: none                                                      *
     * ASSERTION: sets the current month if valid and FAILS otherwise.   *
     *********************************************************************/
    public void setMonth(int inMonth)
    {
        if(validateMonth(inMonth))
        {
            month = inMonth;
        }
        else
        {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    /**********************************************************
     *SUBMODULE: setYear                                      *
     *IMPORT: inYear (int)                                    *
     *EXPORT: none                                            *
     *ASSERTION: sets the year if valid and FAILS otherwise.  *
     **********************************************************/
    public void setYear(int inYear)
    {
        year = inYear;
    }

    
    //ACCESSORS

    //getDay()
    //getMonth()
    //getYear()

    //Purpose: gets the day.
    public int getDay()
    {
        return day;
    }

    //gets the month.
    public int getMonth()
    {
        return month;
    }

    //gets the year.
    public int getYear()
    {
        return year;
    }

    /****************************************************************************************
     * SUBMODULE: equals                                                                    *
     * IMPORT: inObj (Object)                                                               *
     * EXPORT: same                                                                         *
     * ASSERTION: Two dates are interchangeable if they have the same day, month and year.  *
     ****************************************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if(inObj instanceof Date)
        {
            Date inDate = (Date)inObj;
            same = (day == inDate.getDay()) && 
                   (month == inDate.getMonth()) &&
                   (year == inDate.getYear());
        }
        return same;
    }

    //clones the object by calling copy constructor.

    public Date clone()
    {
        return new Date(this);
    }

    //returns a string of classfields data.
    
    public String toString()
    {
    
        return ("Day: " + day + " Month: " + month + 
                " Year: " + year);
    }

    /*******************************************************
    * Name: isLeapYear.                                    *
    * Import: year(int)                                    *
    * Export: leap(boolean)                                *
    * Purpose: checks if the year is a leap year or not.   *
    ********************************************************/

    public boolean isLeapYear(int year)
    {        
        boolean leap = false;
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
        {
            leap = true;
        }
        return leap;            
    } //End isLeapyear.

    /******************************************************
    * Name: toFileString                                  *
    * Import: none                                        *
    * Export: subFileName(String)                         *
    * Purpose: will return a string with formatted date.  *
    *******************************************************/

    public String toFileString()
    {
        String subFileName;
        if(day < 10 && month < 10)
        {
            subFileName = year + "-0" + month + "-0" + day;
        }
        else if(day < 10)
        {
            subFileName = year + "-" + month + "-0" + day;
        }
        else if(month < 10)
        {
            subFileName = year + "-0" + month + "-" + day;
        }
        else
        {
            subFileName = year + "-" + month + "-" + day;
        }
        return subFileName;
    } //End toFileString.

    
    /************************************************************************************************************
     * SUBMODULE: validateDay
     * IMPORT: inDay (int), inMonth (int), inYear (int)
     * EXPORT: valid (boolean)
     * ASSERTION: Day is either less than 30 or less than 31. Also less than 28 or less than 29 for month 02.
    **************************************************************************************************************/
    private boolean validateDay(int inDay, int inMonth, int inYear)
    {
        boolean valid = false;
        if(validateMonth(inMonth))
        {
            switch(inMonth)
            {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if((inDay >= 01) && (inDay <= 31))
                {
                    valid = true;
                }
                break;
    
                case 2:
                if((isLeapYear(inYear)) && ((inDay >=01) && (inDay <= 29)))
                {
                    valid = true;
                }
                else if(!(isLeapYear(inYear)) && ((inDay >=01) && (inDay <=28)))
                {
                    valid = true;
                }
                else
                {
                }
                break;

                case 4: case 6: case 9: case 11:
                if((inDay >= 01) && (inDay <=30))
                {
                    valid = true;
                }
                break;
            }
        }
        else
        {
            throw new IllegalArgumentException("Inavlid month");
        }
        return valid;
    } //End validateDay.

    /********************************************************
     * SUBMODULE: validateMonth                             *
     * IMPORT: inMonth (int)                                *
     * EXPORT: valid (boolean)                              *
     * ASSERTION: Month is between 1 and 12 (inclusive).    *
     ********************************************************/
    private boolean validateMonth(int inMonth)
    {
        
        return ((inMonth >= 01) && (inMonth <= 12));
    }

} //End Date.


