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

package pa8portfolio;

/**
 * File name:   PA8PortfolioMainMcRandalHughes.java
 * <p>
 * Description: Main class for the JMenu portfolio (PA8) assignment problem.
 *              This class will instantiate a controller class.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern. Note: There will be no model class since the JMenu
 *              does not need to store any information.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 15-Apr-2021
 */

public class PA8PortfolioMainMcRandalHughes
{
    
    //-------Static Methods-------
    
    
    /**
     * Main class for PA8 that will instantiate the controller for the JMenu.
     * 
     * @param args  Command line inputs
     */
    public static void main(String[] args)
    {
        new PortfolioJFrameController( ); 
    }//End public static void main(String[])
    
}//End public class PA8PortfolioMainMcRandalHughes