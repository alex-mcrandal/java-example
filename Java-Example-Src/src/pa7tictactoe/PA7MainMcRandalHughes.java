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

package pa7tictactoe;

/**
 * File name:   PA7MainMcRandalHughes.java
 * <p>
 * Description: Main class for the JFrame Tic-Tac-Toe (PA7) assignment problem.
 *              This class will instantiate a delegate class (either a JFrame or
 *              a console delegate).
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 26-Mar-2021
 */

public class PA7MainMcRandalHughes
{
    
    /**
     * Initialize the controller for PA7
     * 
     * @param args  String arguments from the command input
     */
    public static void main(String[] args)
    {
        new TicTacToeJFController( );
    }//End public static void main(String[])
    
}//End public class PA7MainMcRandalHughes
