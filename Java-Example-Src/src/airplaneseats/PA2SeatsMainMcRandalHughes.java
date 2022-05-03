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

package airplaneseats;

/**
 * File name:   PA2SeatsMainMcRandalHughes.java
 * <p>
 * Description: Main  class for the airplane seat assignments problem.
 * <p>
 *              This class is designed to support the Model-Delegate pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 11-Feb-2021
 */

public class PA2SeatsMainMcRandalHughes
{
    /**
     * Initiate the SeatsDelegate class and begin running the program
     * 
     * @param args  String array for command line arguments
     */
    public static void main(String[] args)
    {
        new SeatsDelegate( );
    }//End public static void main(String[])
    
}//End public class PA2SeatsMainMcRandal