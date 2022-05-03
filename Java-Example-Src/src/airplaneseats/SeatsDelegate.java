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

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * File name:   SeatsDelegate.java
 * <p>
 * Description: Console-based Delegate (View/Controller) class for the airplane 
 *              seat assignments problem.
 * <p>
 *              This class is designed to support the Model-Delegate pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 11-Feb-2021
 */

public class SeatsDelegate
{
    
    //-------instance fields------- 
    
    
    private SeatsModel seats;
   
    
    //-------constructors-------  
    
    
    /**
     * No-arg constructor designed to handle I/O
     */
    public SeatsDelegate()
    {   
        seats = new SeatsModel(); 
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("\n\t\tTEST OF AIRPLANE SEATS ASSIGNMENTS\n");
        System.out.println("Alex McRandal and Brandon Hughes");
        System.out.println("February 12, 2021\n");
        System.out.println("You will be selecting seats for this airplane "
                            + "seating plan:\n");
        
        displaySeats();
        
        System.out.println("You will input the seat selection with "
                            + "the row");
        System.out.println("number followed by the seat letter (ex. 3B)\n");
        
        boolean quitProgram = false;
        
        while(!quitProgram)
        {
            String input = obtainSeat(keyboard);
            while(!isValidInput(input))
            {
                input = obtainSeat (keyboard);
            }
            if(seats.checkSeatLocation(input))
            {
                System.out.println("Seat " + input.toUpperCase() + 
                                    " is now assigned.\n" +
                                    "Seats remaining = " + 
                                    seats.getSeatsLeft() +"\n");
            }
            else
            {
                System.out.println("Seat " + input + 
                                    " has already been assigned.");
            }
            
            displaySeats( );
            
            if(seats.getSeatsLeft() == 0)
            {
                System.out.println("All seats assigned.");
                displaySeats();
                break;
            }
            
            System.out.print("Assign another seat (Y/N): ");
            input = keyboard.nextLine();
            System.out.println();
            if(input.equalsIgnoreCase("N"))
            {
                quitProgram = true;
            }
        }

    }//End no-arg constructor
    
    
    //-------instance methods------- 
    
    
    /**
     * Get a seating request from the user
     * 
     * @param keyboard The Scanner object used to receive input from the user
     * @return The String that will be used to determine the seat in the chart
     */
    private String obtainSeat(Scanner keyboard)
    {
        String input = "";
        
        System.out.print("Please enter the seat selection: ");
        input = keyboard.nextLine();
        System.out.println();
        
        return input;
    }//End public String obtainSeat(Scanner)
    
    /**
     * Check to make sure the user's input is correct
     * 
     * @param input The String the user inputted
     * @return true if the input is valid, false otherwise
     */
    private boolean isValidInput(String input)
    {
        String regex = "[1-7]{1}([A-D]||[a-d]){1}";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        
        return m.matches();
    }//End private static boolean isValidInput(String)
    
    /**
     * Output the organized seating assignment
     */
    private void displaySeats( )
    {
        System.out.println(seats.toString( ));
    }//End private void displaySeats( )
    
}//End public class SeatsDelegate
