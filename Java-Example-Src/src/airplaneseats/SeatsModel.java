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

package airplaneseats;

/**
 * File name:   SeatsModel.java
 * <p>
 * Description: Data-based Model class for the airplane seat assignments 
 *              problem.
 * <p>
 *              This class is designed to support the Model-Delegate pattern.
 * <p>
 *
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 11-Feb-2021
 */

public class SeatsModel
{
    //-------Instance Fields-------

    /**
     * Seating chart for the airplane
     */
    private char[][] seats;
    
    /**
     * The number of seats left
     */
    private int seatsLeft;
    
    
    //-------Constructors-------
    
    
    /**
     * No-arg constructor that creates a seating chart with no seats taken
     */
    public SeatsModel( )
    {
        seats = new char[][] { {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'},
                                {'A', 'B', 'C', 'D'} };
        
        seatsLeft = seats.length * seats[0].length;
        
    }//End public SeatsModel()
    
    
    //-------Instance Methods-------
    
    /**
     * Retrieve the number of seats left
     * 
     * @return the number of seats left
     */
    public int getSeatsLeft( )
    {
        return seatsLeft;
    }
    
    /**
     * Format the seats model into a string representation to be printed
     * 
     * @return The string representation of the airplane seating chart
     */
    @Override
    public String toString( )
    {
        String seatModel = "";
        
        for(int i = 0; i < seats.length; i++)
        {
            seatModel += (i + 1) + " ";
            
            for(int j = 0; j < seats[i].length; j++)
            {
                seatModel += seats[i][j];
                if(j == 1)
                {
                    seatModel += " ";
                }   
            }
            
            seatModel += "\n";
        }
        
        return seatModel;
        
    }//End public String toString( )
    
    /**
     * This method takes the String the user inputted, converts it to a readable
     * position, and determines if that seat is available
     * 
     * @param s The user's desired seat in String form
     * @return true if the desired seat was open, false otherwise
     */
    public boolean checkSeatLocation(String s)
    {
        if(seatsLeft == 0)
        {
            return false;
        }
        
        int row;
        int column;
        
        try
        {
           row = Integer.parseInt(s.substring(0, 1)) - 1;
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: checkSeatLocation row index is invalid");
            return false;
        }
        
        column = (s.charAt(1) - 1) % 32;
        
        if(seats[row][column] != 'X')
        {
            updateSeat(row, column);
            return true;
        }
        else
        {
            return false;
        }
    }//End public void checkSeatLocation(String)
    
    /**
     * Change the desired seat to taken and decrement the number of seats left
     * 
     * @param rowIndex      The row of the seat
     * @param columnIndex   The column of the seat
     */
    private void updateSeat(int rowIndex, int columnIndex)
    {
        seats[rowIndex][columnIndex] = 'X';
        seatsLeft--;
    }//End private void updateSeats(int, int)
    
}//End public class SeatsModel
