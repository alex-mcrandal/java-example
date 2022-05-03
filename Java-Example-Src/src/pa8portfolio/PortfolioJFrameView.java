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

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * File name:   PortfolioJFrameView.java
 * <p>
 * Description: View class for the JMenu portfolio (PA8) assignment problem.
 *              The view will present a basic JMenu that will allow the user to
 *              run a program of their choice.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern. Note: There will be no model class since the JMenu
 *              does not need to store any information.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 16-Apr-2021
 */

public class PortfolioJFrameView
{
    
    //-------Static Fields-------
    
    
    /*
     * The dimensions of the JFrame
     */
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;
    
    
    //-------Instance Fields-------
    
    
    /**
     * JMenu used to present the user interface where different programs can be
     * run, or other options can be taken.
     */
    private JFrame frame;
    
    
    //-------Constructors-------
    
    
    /**
     * Constructor that creates the JFrame for the user to use
     * 
     * @param listener  The listener object from the controller to be attached
     *                  to all widgets.
     */
    public PortfolioJFrameView(ActionListener listener)
    {
        initialize(listener);
    }//End public PortfolioJFrameView( )
    
    
    //-------Instance Methods-------
    
    
    /**
     * Iconify the state of the frame.
     */
    public void lockJFrame( )
    {
        frame.setState(JFrame.ICONIFIED);
    }//End public void lockJFrame( )
    
    /**
     * Set the state of the frame to normal.
     */
    public void unlockJFrame( )
    {
        frame.setState(JFrame.NORMAL);
    }//End public void unlockJFrame(ActionListener)
    
    /**
     * Construct the frame and each of its components.
     * 
     * @param listener  The listener object from the controller to be attached
     *                  to all widgets.
     */
    private void initialize(ActionListener listener)
    {
        //1.0 Set up the frame
        frame = new JFrame("Portfolio McRandal-Hughes");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout( ));
        
        //2.0 Create the CPS 202 Portfolio menu and add choices
        JMenu menuTopCPSPortfolio = new JMenu("CPS-202 Portfolio");
        
        //2.1 Create the Run subMenu
        JMenu menuSubRun = new JMenu("Run");
        
        //2.2 Create the Run options
        JMenuItem menuItemRunPython = new JMenuItem("Compute CD Value");
        menuItemRunPython.addActionListener(listener);
        menuSubRun.add(menuItemRunPython);
        
        JMenuItem menuItemRunPA2 = new JMenuItem("Assign Airplane Seats");
        menuItemRunPA2.addActionListener(listener);
        menuSubRun.add(menuItemRunPA2);
        
        JMenuItem menuItemRunPA6 = new JMenuItem("Look Up a Baby Name");
        menuItemRunPA6.addActionListener(listener);
        menuSubRun.add(menuItemRunPA6);
        
        JMenuItem menuItemRunPA7 = new JMenuItem("Play Tic-Tac-Toe");
        menuItemRunPA7.addActionListener(listener);
        menuSubRun.add(menuItemRunPA7);
        
        menuTopCPSPortfolio.add(menuSubRun);
        
        //2.3 Create the exit option
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(listener);
        menuTopCPSPortfolio.add(menuItemExit);
        
        //3.0 Create the View Menu
        JMenu menuTopView = new JMenu("View");
        
        // 3.1 Create Look and Feel submenu
        JMenu menuSubLookAndFeel = new JMenu("Look and Feel");
        
        // 3.1.1 Add choices to Look and Feel submenu 
        JMenuItem menuItemLookAndFeelMetal = new JMenuItem("Metal (Java)");
        menuItemLookAndFeelMetal.addActionListener(listener);
        menuSubLookAndFeel.add(menuItemLookAndFeelMetal);
        
        JMenuItem menuItemLookAndFeelMotif = new JMenuItem("Motif (UNIX)");
        menuItemLookAndFeelMotif.addActionListener(listener);
        menuSubLookAndFeel.add(menuItemLookAndFeelMotif);
        
        JMenuItem menuItemLookAndFeelWindows = new JMenuItem("Windows");
        menuItemLookAndFeelWindows.addActionListener(listener);
        menuSubLookAndFeel.add(menuItemLookAndFeelWindows);
                
        // 3.2 Create Scroll Bars submenu
        JMenu menuSubScroll = new JMenu("Scroll Bars");
        
        // 3.2.1 Add choices to Scroll Bars submenu
        JMenuItem menuItemScrollNever = new JMenuItem("Never");
        menuItemScrollNever.addActionListener(listener);
        menuSubScroll.add(menuItemScrollNever);
        
        JMenuItem menuItemScrollAlways = new JMenuItem("Always");
        menuItemScrollAlways.addActionListener(listener);
        menuSubScroll.add(menuItemScrollAlways);
        
        JMenuItem menuItemScrollAsNeeded = new JMenuItem("As Needed");
        menuItemScrollAsNeeded.addActionListener(listener);
        menuSubScroll.add(menuItemScrollAsNeeded);
        
        // 3.2.2 Add submenus to View menu (Look and Feel, Scroll Bars)
        menuTopView.add(menuSubLookAndFeel);
        menuTopView.add(menuSubScroll);
        
        // 4.0 Create the Utilities menu and add choices
        JMenu menuTopUtilities = new JMenu("Utilities");
        
        JMenuItem menuItemRunMicrosoftWord = new JMenuItem(
                "Open Microsoft Word");
        menuItemRunMicrosoftWord.addActionListener(listener);
        menuTopUtilities.add(menuItemRunMicrosoftWord);
        
        JMenuItem menuItemRunNotepad = new JMenuItem("Open Notepad");
        menuItemRunNotepad.addActionListener(listener);
        menuTopUtilities.add(menuItemRunNotepad);
        
        // 5.0 Create the Help menu and add choices
        JMenu menuTopHelp = new JMenu("Help");
        
        JMenuItem menuItemHelpIndex = new JMenuItem("Contents");
        menuItemHelpIndex.addActionListener(listener);
        menuTopHelp.add(menuItemHelpIndex);
        
        JMenuItem menuItemHelpAbout = new JMenuItem("About");
        menuItemHelpAbout.addActionListener(listener);
        menuTopHelp.add(menuItemHelpAbout);
        
        //6.0 Set up JMenuBar and add top level choices
        JMenuBar menuBar = new JMenuBar( );
        frame.setJMenuBar(menuBar);
        menuBar.add(menuTopCPSPortfolio);
        menuBar.add(menuTopView);
        menuBar.add(menuTopUtilities);
        menuBar.add(menuTopHelp);
        
        //7.0 Make the frame visible
        frame.setVisible(true);
    }//End public void initialize( )
    
}//End public class PortfolioJFrameView