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
 * File name:   TicTacToeModel.java
 * <p>
 * Description: Model class for the Tic-Tac-Toe (PA7) assignment problem. This
 *              class will keep track of the game and previous games played and
 *              communicate to the controller what is occurring.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 29-Mar-2021
 */

public class TicTacToeModel
{
    
    //-------Static Fields-------
    
    
    /**
     * The number of spaces for one side of the game board.
     */
    public static final int BOARD_SIDE_LENGTH = 3;
    
    
    //-------Instance Fields-------
    
    
    /**
     * The storage of the game itself.
     */
    private String[][] gameBoard;
    
    /**
     * The symbol for the current player (either "X" or "O").
     */
    private String playerCharacter;
    
    /**
     * The number of times player "X" has won
     */
    private int xWins;
    
    /**
     * The number of times player "O" has won
     */
    private int oWins;
    
    
    //-------Constructors-------
    
    
    /**
     * Create an empty game board where player "X" goes first and no player has
     * any wins.
     */
    public TicTacToeModel( )
    {
        resetTheGame( );
        xWins = 0;
        oWins = 0;
    }//End public TicTacToeModel( )
    
    
    //-------Instance Methods-------
    
    
    /**
     * Get the symbol for the current player.
     * 
     * @return "X" or "O" depending on the turn player.
     */
    public String getPlayerCharacter( )
    {
        return playerCharacter;
    }//End public String getPlayerCharacter( )
    
    /**
     * Get the number of wins player "X" has.
     * 
     * @return The number of wins
     */
    public int getXWins( )
    {
        return xWins;
    }//End public int getXWins( )
    
    /**
     * Get the number of wins player "O" has.
     * 
     * @return The number of wins
     */
    public int getOWins( )
    {
        return oWins;
    }//End public int getOWins( )
    
    /**
     * Update the model with the newest move by the current player. Then check
     * to see if the most recent move lead the current player to victory.
     * 
     * @param row       The row number the play was made in.
     * @param column    The column number the play was made in.
     * @return          True if the play lead to the current player's victory,
     *                  false otherwise and the game will continue
     */
    public boolean newMove(int row, int column)
    {
        gameBoard[row][column] = playerCharacter;
        if(checkForWin(row, column))
        {
            increasePlayerWins( );
            return true;
        }
        else
        {
            switchPlayer( );
            return false;
        }
    }//End public boolean newMove(int, int)
    
    /**
     * Clear the board for a new game and "X" will start again.
     */
    public void resetTheGame( )
    {
        gameBoard = new String[][]{{"", "", ""}, {"", "", ""}, {"", "", ""}};
        playerCharacter = "X";
    }//End public void resetTheGame( )
    
    /**
     * Change the current player's character to the character for the other
     * player.
     */
    private void switchPlayer( )
    {
        if(playerCharacter.equals("X"))
        {
            playerCharacter = "O";
        }
        else
        {
           playerCharacter = "X"; 
        }
    }//End private void switchPlayer( )
    
    /**
     * Check to see if the current player has won.
     * 
     * @param row       The row number where the most recent move was made.
     * @param column    The column number where the most recent move was made.
     * @return          True if the current player won, false otherwise.
     */
    private boolean checkForWin(int row, int column)
    {
        String testStr = "";
        
        //check the row for a straight win
        for(int c = 0; c < BOARD_SIDE_LENGTH; c++)
        {
            testStr += gameBoard[row][c];
        }
        if(testStr.equals("XXX") || testStr.equals("OOO"))
        {
            return true;
        }
        
        //check the column for a straight win
        testStr = "";
        for(int r = 0; r < BOARD_SIDE_LENGTH; r++)
        {
            testStr += gameBoard[r][column];
        }
        if(testStr.equals("XXX") || testStr.equals("OOO"))
        {
            return true;
        }
        
        //check one of the diagonals for a straight win
        testStr = "";
        for(int i = 0; i < BOARD_SIDE_LENGTH; i++)
        {
            testStr += gameBoard[i][i];
        }
        if(testStr.equals("XXX") || testStr.equals("OOO"))
        {
            return true;
        }
        
        //check the last possible diagonal for a straight win
        testStr = "";
        for(int i = 0; i < BOARD_SIDE_LENGTH; i++)
        {
            testStr += gameBoard[2 - i][i];
        }
        if(testStr.equals("XXX") || testStr.equals("OOO"))
        {
            return true;
        }
        
        //no win was found
        return false;
    }//End private boolean checkForWin(int, int)
    
    /**
     * Increment the current player's win count by 1.
     */
    private void increasePlayerWins( )
    {
        if(playerCharacter.equals("X"))
        {
            xWins++;
        }
        else
        {
            oWins++;
        }
    }//End private void increasePlayerWins( )
    
}//End public class TicTacToeModel
