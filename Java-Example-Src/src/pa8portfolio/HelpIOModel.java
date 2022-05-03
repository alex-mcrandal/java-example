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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File Name: HelpIOModel.java
 * <p>
 * Description: The HelpIOModel class is designed to read a text file stored in
 *              the project folder. The file may not be overwritten or altered
 *              in any way using this class.
 * <p>
 *              Once the contents have been read, the class will display the
 *              contents inside a JTextArea on a JOptionPane.
 * <p>
 *              This class combines the roles of both the model and the delegate
 *              to create a simple flow of sequential-executable code.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 27-Apr-2021
 */

public class HelpIOModel
{
    
    /**
     * The following method is just a helper method to read the contents of
     * a text file and display it to the user.
     * <p>
     * Since the only function the method has to perform is file reading and
     * displaying its contents, the method is made static since an object
     * would be unnecessary.
     */
    public static void displayHelpContents( )
    {
        Scanner fileReader = null;
        String displayStr = "";
        
        try
        {
            fileReader = new Scanner(new FileInputStream("HelpContents.txt"));
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(HelpIOModel.class.getName( ))
                        .log(Level.SEVERE, null, ex);
        }
        
        while(fileReader.hasNextLine( ))
        {
            displayStr += fileReader.nextLine( ) + "\n";
        }
        
        fileReader.close( );
        
        JTextArea textArea = new JTextArea(displayStr);
        
        JOptionPane.showMessageDialog(null, textArea);
    }//End public static void displayHelpContents( )
    
}//End public class HelpIOModel