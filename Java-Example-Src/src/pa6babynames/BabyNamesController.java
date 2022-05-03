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
 * File name:   BabyNamesController.java
 * <p>
 * Description: Controller class for the Baby Names (PA6) assignment problem. 
 *              This class will instantiate the BabyNamesModel and use the 
 *              methods of the BabyNamesView to show input and output.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 19-Mar-2021
 */

public class BabyNamesController
{
    
    //-------Instance Fields-------
    
    
    /**
     * Model used to store the lists of boy and girl names
     */
    private BabyNamesModel model;
    
    /**
     * View window to prompt for input and show the user output
     */
    private BabyNamesView view;
    
    
    //-------Contructors-------
    
    
    /**
     * Begin running the program and construct the model/view
     */
    public BabyNamesController( )
    {
        constructModel();
        constructView();
        
        String input;
        String output;
        do
        {
            input = view.getInput("Pleas enter the name you"
                    + " wish to search or \"Q\" to quit: ");
            if(input.equalsIgnoreCase("Q"))
            {
                break;
            }
            output = findName(input);
            view.showOutput(output);
            
        }
        while(!input.equalsIgnoreCase("Q"));
        
        output = model.getFirstTwentyGirlNames();
        output = "The first twenty girl names alphabetically:\n" + output;
        view.showOutput(output);
    }//End public BabyNamesController( )
    
    /**
     * Initialize the value of the model field with both list of boy and girl
     * names
     */
    private void constructModel( )
    {
        model = new BabyNamesModel( );
    }//End private void constructModel( )
    
    /**
     * Initialize the view object for the controller class
     */
    private void constructView( )
    {
        view = new BabyNamesView( );
    }//End private void constructView( )
    
    /**
     * Search the list of boy and girl names for the user's entered name and
     * format the result of the search.
     * 
     * @param name  The name the user wishes to find
     * @return      Information about the name formatted so that it can be
     *              viewed as a JOptionPane message
     */
    private String findName(String name)
    {
        String output = "";
        String[] nameInformation = model.searchGirlName(name);
            if(nameInformation == null)
            {
                output = output + name + " is not ranked among the top "
                        + "1,000 girl names.\n";
            }
            else
            {
                output = output + nameInformation[0] + " is ranked " 
                        + nameInformation[2] + " in popularity among girls "
                        + "with " + nameInformation[1] + " namings.\n";
            }
            
            nameInformation = model.searchBoyName(name);
            if(nameInformation == null)
            {
                output = output + name + " is not ranked among the top "
                        + "1,000 boy names.\n";
            }
            else
            {
                output = output + nameInformation[0] + " is ranked " 
                        + nameInformation[2] + " in popularity among boys "
                        + "with " + nameInformation[1] + " namings.\n";
            }
        return output;
    }//End private String findName(String)
    
}//End public class BabyNamesController( )