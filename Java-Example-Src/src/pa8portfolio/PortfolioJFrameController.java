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

import airplaneseats.PA2SeatsMainMcRandalHughes;
import pa6babynames.PA6MainMcRandalHughes;
import pa7tictactoe.PA7MainMcRandalHughes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File name:   PortfolioJFrameController.java
 * <p>
 * Description: Controller class for the JMenu portfolio (PA8) assignment 
 *              problem. The controller creates a view (JMenu) for the user to
 *              select the program they want to run, and based off that input
 *              will run the corresponding program.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern. Note: There will be no model class since the JMenu
 *              does not need to store any information.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 27-Apr-2021
 */

public class PortfolioJFrameController
{
    
    //-------Instance Fields-------
    
    
    /**
     * JFrame that the user uses as menu to fire events
     */
    private PortfolioJFrameView view;
    
    
    //-------Constructors-------
    
    
    /**
     * No-arg constructor to create the JMenu for the user to use.
     */
    public PortfolioJFrameController( )
    {
        view = new PortfolioJFrameView(new WidgetListener( ));
    }//End No-arg constructor
    
    
    //-------Helper Classes-------
    
    
    /**
     * This class is used by the JMenu to create event-driven programming. This
     * class will pass a WidgetListener object to the view so the menu can fire
     * events.
     */
    private class WidgetListener implements ActionListener
    {
        /**
         * No-arg constructor for the WidgetListener class. No need to assign
         * any variables since the helper class does not contain any private
         * fields.
         */
        public WidgetListener( )
        {
            //deliberately empty
        }//End public WidgetListener( )
        
        /**
         * Method called when the JMenu fires and event. The logic behind how
         * the program runs is determined in this method.
         * 
         * @param e ActionEvent that most recently occurred
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            switch(e.getActionCommand( ))
            {
                case "Exit":
                    System.exit(0);
                
                case "Look Up a Baby Name":
                    view.lockJFrame( );
                    PA6MainMcRandalHughes.main(new String[1]);
                    view.unlockJFrame( );
                    break;
                    
                case "Play Tic-Tac-Toe":
                    PA7MainMcRandalHughes.main(new String[1]);
                    view.unlockJFrame( );
                    break;
                    
                case "Assign Airplane Seats":
                    view.lockJFrame( );
                    PA2SeatsMainMcRandalHughes.main(new String[1]);
                    view.unlockJFrame( );
                    break;
                    
                case "Compute CD Value":
                    view.lockJFrame( );
                    computeCDValue( );
                    view.unlockJFrame( );
                    break;
                
                case "Contents":
                    view.lockJFrame( );
                    HelpIOModel.displayHelpContents( );
                    view.unlockJFrame( );
                    break;
                
                case "Open Microsoft Word":
                    openWord( );
                    view.unlockJFrame( );
                    break;
                    
                case "Open Notepad":
                    openNotepad( );
                    view.unlockJFrame( );
                    break;
                    
            }
        }//End public void actionPerformed(ActionEvent)
        
        /**
         * Method to locate and run the Compute CD Python program.
         * <p>
         * The python program will be stored in the project folder similar to
         * text files.
         */
        private void computeCDValue( )
        {
            String pythonPathString;
            String pythonModuleString;
            String execArgumentString;
            
            pythonPathString = "python ";
            pythonModuleString = "ComputeCDValue.py";
            execArgumentString = "cmd /c start cmd.exe /K"
                                 + "\"color f0 && \""
                                 + pythonPathString
                                 + pythonModuleString;
            
            try
            {
                Runtime.getRuntime( ).exec(execArgumentString);
            }
            catch(IOException ex)
            {
                Logger.getLogger(PortfolioJFrameController.class.getName( ))
                        .log(Level.SEVERE, null, ex);
            }
        }//End private void computeCDValue( )
        
        /**
         * Call the command to run Microsoft Word on the local machine.
         * <p>
         * This method's success will vary from machine to machine, since Word
         * could be stored in a different location in memory.
         */
        private void openWord( )
        {
            String execArgumentStr;
            
            execArgumentStr = "cmd /c " + "\"C:\\Program Files\\Microsoft Office"
                            + "\\root\\Office16\\WINWORD.EXE\"";
            
            try
            {
                Runtime.getRuntime( ).exec(execArgumentStr);
            }
            catch(IOException ex)
            {
                Logger.getLogger(PortfolioJFrameController.class.getName( ))
                        .log(Level.SEVERE, null, ex);
            }
        }//End private void openWord( )
        
        /**
         * Call the command to run Notepad on the local machine.
         * <p>
         * This method's success will vary from machine to machine, since 
         * Notepad could be stored in a different location in memory.
         */
        private void openNotepad( )
        {
            String execArgumentStr;
            
            execArgumentStr = "cmd /c " + "%windir%\\system32\\notepad.exe";
            
            try
            {
                Runtime.getRuntime( ).exec(execArgumentStr);
            }
            catch(IOException ex)
            {
                Logger.getLogger(PortfolioJFrameController.class.getName( ))
                        .log(Level.SEVERE, null, ex);
            }
        }//End private void openNotepad( )
        
    }//End private class WidgetListener implements ActionListener
    
}//End public class PortfolioJFrameController