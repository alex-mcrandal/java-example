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

import javax.swing.JOptionPane;

/**
 * File name:   BabyNamesView.java
 * <p>
 * Description: View class for the Baby Names (PA6) assignment problem. This
 *              class will prompt the user for input and return the input to 
 *              the controller. The output from the controller will be 
 *              displayed from the view.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 19-Mar-2021
 */

public class BabyNamesView
{
    
    //-------Constructors-------
    
    
    /**
     * Create an empty BabyNamesView object to call the input and output methods
     */
    public BabyNamesView( )
    {
        
    }//End public BabyNamesView
    
    //-------Instance Methods-------
    
    
    /**
     * Display a JOptionPane asking for the user's input and a text box for 
     * the user input.
     * 
     * @param prompt    The String that tells the user what to input
     * @return          The user's input
     */
    public String getInput(String prompt)
    {
        return JOptionPane.showInputDialog(null, prompt);
    }//End public static String getInput(String)
    
    /**
     * Display the output from the user's input in a different JOptionPane
     * 
     * @param output    The message the program wants the user to see 
     */
    public void showOutput(String output)
    {
        JOptionPane.showMessageDialog(null, output);
    }//End public static void showOutput(String)
    
}//End public class BabyNamesView