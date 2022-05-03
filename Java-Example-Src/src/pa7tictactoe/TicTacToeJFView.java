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
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * File name:   TicTacToeJFView.java
 * <p>
 * Description: View class for the Tic-Tac-Toe (PA7) assignment problem.
 *              This class utilizes GUI programming to represent the game Tic-
 *              Tac-Toe as a visual application.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 21-Apr-2021
 */

public class TicTacToeJFView
{
    
    //-------Instance Fields-------
    
    
    /**
     * Application window used to present the game of tic-tac-toe and other
     * features.
     */
    private JFrame frame;
    
    /**
     * Text field used to show the user the number of wins each player has.
     */
    private JLabel winsLabel;
    
    /**
     * Text field that will tell the players whose turn it is or who won the
     * game.
     */
    private JLabel turnPlayerLbl;
    
    /**
     * The list of nine buttons used to make the tic-tac-toe grid.
     */
    private JButton[][] playableButtons;
    
    
    //-------Constructors-------
    
    
    /**
     * Create the application window for tic-tac-toe.
     * 
     * @param listener  A reference to the ActionListener used in the controller
     *                  class.
     */
    public TicTacToeJFView(ActionListener listener)
    {
        createGUIWindow(listener);
    }//End public TicTacToeJFView( )
    
    
    //-------Instance Methods-------
    
    
   /**
    * Change the JLabel to show who the current player is.
    * 
    * @param playerToken    Either "X" or "O" to show the current player
    */ 
   public void displayPlayersTurn(String playerToken)
   {
       turnPlayerLbl.setText("Player " + playerToken + "'s Turn");
   }//End public void displayPlayersTurn(String)
   
   /**
    * Show that the game is over and someone won.
    * 
    * @param message    The player who won, either "X" or "O" (possibly a draw)
    */
   public void displayWinner(String message)
   {
       turnPlayerLbl.setText(message);
   }//End public void displayWinner(String)
   
   /**
    * Change the text field showing the number of wins each player has.
    * 
    * @param xWins  The number of times player "X" won
    * @param oWins  The number of times player "O" won
    */
   public void displayWins(int xWins, int oWins)
   {
       winsLabel.setText("\"X\" Wins: " + xWins + "    \"O\" Wins: " + oWins);
   }//End public void displayWins(int, int)
   
   /**
    * Changes the symbol displayed on a particular button to show where each
    * player has made a move.
    * 
    * @param indexNumber    The index position of the button on the grid
    * @param symbol         The current player's character
    */
   public void updatePlayableButton(int indexNumber, String symbol)
   {
       int row = indexNumber / TicTacToeModel.BOARD_SIDE_LENGTH;
       int column = indexNumber % TicTacToeModel.BOARD_SIDE_LENGTH;
       playableButtons[row][column].setText(symbol);
   }//End public void updatePlayableButton(int, String)
   
   /**
    * Reset the 9 buttons to display numbers and not X's and O's.
    */
   public void resetScreen( )
   {
       for(int r = 0; r < TicTacToeModel.BOARD_SIDE_LENGTH ; r++)
        {
            for(int c = 0; c < TicTacToeModel.BOARD_SIDE_LENGTH; c++)
            {
                playableButtons[r][c].setText("" + (r * 
                        TicTacToeModel.BOARD_SIDE_LENGTH + c + 1));
            }
        }
   }//End public void resetScreen( )
       
    /**
     * Using layout managers and widgets, construct the look of the application
     * window.
     * 
     * @param listener  A reference to the ActionListener used in the controller
     *                  class.
     */
    private void createGUIWindow(ActionListener listener)
    {
        //create the overall application window
        frame = new JFrame("Tic-Tac-Toe");
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout( ));
        
        //construct the top panel of the application window
        JPanel northPanel = new JPanel(new BorderLayout( ));
        winsLabel = new JLabel("\"X\" Wins: " + 0 + 
                "    \"O\" Wins: " + 0);
        northPanel.add(winsLabel, BorderLayout.NORTH);
        turnPlayerLbl = new JLabel("Player " + 
                "X" + "'s Turn");
        northPanel.add(turnPlayerLbl, BorderLayout.SOUTH);
        
        //construct the central panel of the application window
        JPanel centerPanel = new JPanel(new GridLayout
                                (TicTacToeModel.BOARD_SIDE_LENGTH, 
                                 TicTacToeModel.BOARD_SIDE_LENGTH));
        playableButtons = new JButton[TicTacToeModel.BOARD_SIDE_LENGTH] 
                [TicTacToeModel.BOARD_SIDE_LENGTH];
        for(int r = 0; r < TicTacToeModel.BOARD_SIDE_LENGTH; r++)
        {
            for(int c = 0; c < TicTacToeModel.BOARD_SIDE_LENGTH; c++)
            {    
                playableButtons[r][c] = new JButton("" + (r * 
                        TicTacToeModel.BOARD_SIDE_LENGTH + c + 1));
                playableButtons[r][c].addActionListener(listener);
                centerPanel.add(playableButtons[r][c]);
            }
        }
        
        //construct the southern panel of the application window
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton playAgainBtn = new JButton("Play Again");
        playAgainBtn.addActionListener(listener);
        southPanel.add(playAgainBtn);
        
        //add all of the panels to the application window
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        
        //make the frame visible
        frame.setVisible(true);
    }//End private void createGUIWindow( )
    
}//End public class TicTacToeJFView