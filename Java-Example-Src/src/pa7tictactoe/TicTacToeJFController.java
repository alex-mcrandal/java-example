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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * File name:   TicTacToeJFController.java
 * <p>
 * Description: Controller class for the Tic-Tac-Toe (PA7) assignment problem.
 *              This class creates the model and JFView to show the players a
 *              game of tic-tac-toe.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 29-Mar-2021
 */

public class TicTacToeJFController
{
    
    //-------Instance Fields-------
    
    
    /**
     * The class containing the JFrame used to present the entire application.
     */
    private TicTacToeJFView view;
    
    /**
     * The game board.
     */
    private TicTacToeModel model;
    
    /**
     * A count of the total number of plays made by the players so that when the
     * count reaches 9, the game may end in a draw.
     */
    private int numberOfPlays;
    
    /**
     * The boolean variable used to control the user's input so that nothing
     * undesirable happens after a game is won.
     */
    private boolean gameControlVar;
    
    
    //--------Constructors-------
    
    
    /**
     * Create a new application for playing Tic-Tac-Toe.
     */
    public TicTacToeJFController( )
    {
        gameControlVar = false;
        constructModel( );
        initializeJFView( );
    }//End public TicTacToeJFController( )
    
    
    //-------Instance Methods-------
    
    
    /**
     * Instantiate the model field to contain an empty board and no wins.
     */
    private void constructModel( )
    {
        model = new TicTacToeModel( );
    }//End private void constructModel( )
    
    /**
     * Create the JFrame and the view class that present the JFrame.
     */
    private void initializeJFView( )
    {
        /*
         *Personal Note:
         *The line below calls the WidgetListener constructor but since none is
         *explicitly written, the default Object constructor is called.
         */
        view = new TicTacToeJFView(new WidgetListener( ));
    }//End private void initializeJFView( )
    
    
    //-------Inner Classes-------
    
    
    /**
     * Description: The inner class implements the ActionListener interface.
     */
    private class WidgetListener implements ActionListener
    {
        /**
         * actionPerformed supports the JButtons in the view class so that the
         * application may run. The buttons will allow the program to run
         * indefinitely until the application is closed. The controller will
         * follow certain instructions depending on what button the user
         * pressed.
         * 
         * @param e The action event that occurred in the application window
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(gameControlVar || e.getActionCommand().equals("Play Again"))
            {
                numberOfPlays = 0;
                model.resetTheGame( );
                view.displayPlayersTurn(model.getPlayerCharacter());
                view.resetScreen( );
                gameControlVar = false;
            }
            else if(e.getActionCommand().equals("X") || 
                    e.getActionCommand().equals("O"))
            {
                //do nothing
            }
            else
            {
                view.updatePlayableButton(
                            Integer.parseInt(e.getActionCommand()) - 1, 
                            model.getPlayerCharacter());
                numberOfPlays++;
                if(model.newMove(
                        (Integer.parseInt(e.getActionCommand()) - 1) / 
                                TicTacToeModel.BOARD_SIDE_LENGTH, 
                        (Integer.parseInt(e.getActionCommand()) - 1) % 
                                TicTacToeModel.BOARD_SIDE_LENGTH))
                {
                    //the game is over and someone won
                    gameControlVar = true;
                    view.displayWinner("Player " + model.getPlayerCharacter() 
                            + " is the winner! Press \"Play Again\" to reset.");
                    view.displayWins(model.getXWins(), model.getOWins());
                }
                else
                {
                    //the game continues or reaches a draw
                    if(numberOfPlays > 8)
                    {
                        gameControlVar = true;
                        view.displayWinner("Game is a draw.");
                    }
                    else
                    {
                        view.displayPlayersTurn(model.getPlayerCharacter());
                    }
                }
            }
        }//End public void actionPerformed(ActionEvent)
        
    }//End private class WidgetListener implements ActionListener
    
}//End public class TicTacToeJFController