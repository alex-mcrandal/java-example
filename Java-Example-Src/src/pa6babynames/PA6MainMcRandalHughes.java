/*
 * CPS 202
 * Spring 2021
 * Alex McRandal
 * Brandon Hughes
 * 
 * Copyright © 2021 Alex McRandal & Brandon Hughes
 * This work is licensed under the Creative Commons 
 * Attribution-Noncommercial-No Derivative Works 3.0 United States License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-nc-nd/3.0/us/ 
 * or send a letter to Creative Commons, 171 Second Street, Suite 300, 
 * San Francisco, California, 94105, USA. 
 */

package pa6babynames;

/**
 * File name:   PA6MainMcRandalHughes.java
 * <p>
 * Description: Main class for the Baby Names (PA6) assignment problem. This
 *              class will instantiate a delegate class (either a JODelegate or
 *              a console delegate).
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 17-Mar-2021
 */

public class PA6MainMcRandalHughes
{
    
    /**
     * Instantiate the controller for PA 6
     * 
     * @param args String array for command line arguments
     */
    public static void main(String[] args)
    {
        new BabyNamesController( );
    }//End public static void main(String[])
    
}//End public class PA6MainMcRandalHughes
