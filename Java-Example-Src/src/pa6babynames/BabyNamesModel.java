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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * File name:   BabyNamesModel.java
 * <p>
 * Description: Model class for the Baby Names (PA6) assignment problem. This
 *              class will store two lists of the top 1,000 boy and top 1,000
 *              girl names, and the number of times each one was registered.
 * <p>
 *              This class is designed to support the Model-View-Controller 
 *              pattern.
 * <p>
 * @author Alex McRandal amcranda@heidelberg.edu 
 * @author Brandon Hughes bhughes1@heidelberg.edu
 * @version 19-Mar-2021
 */

public class BabyNamesModel
{
    
    //-------Static Fields-------
    
    /**
     * The length of each array for the boy and girl names
     */
    public static final int ARRAY_SIZE = 1000;
    
    /**
     * A constant used as a parameter by outside classes to call findBoyName( )
     * or findGirlName( )
     */
    public static final int UPPER_INDEX = ARRAY_SIZE - 1;
    
    
    //-------Instance Fields-------
    
    
    /**
     * A list of the top 1,000 boy names and the number of times each one was
     * registered
     */
    private List<BabyName> boyNames;
    
    /**
     * A list of the top 1,000 girl names and the number of times each one was
     * registered
     */
    private List<BabyName> girlNames;
    
    
    //-------Constructors-------
    
    
    /**
     * Populate the data of boyNames and girlNames from the text files within 
     * the source folder
     */
    public BabyNamesModel( )
    {
        boyNames = new ArrayList<>();
        girlNames = new ArrayList<>();
        
        String[] fileNames = {"boynames2020.txt", "girlnames2020.txt"};
        readFiles(fileNames);
        
        sortBoyNames(0, UPPER_INDEX);
        sortGirlNames(0, UPPER_INDEX);
    }//End public BabyNamesModel( )
    
    
    //-------Instance Methods-------
    
    
    /**
     * Read each line of all the text files and populate a list of boy names
     * and another for girl names
     * 
     * @param listOfFileNames   The names of the two files containing boy and
     *                          girl names
     */
    private void readFiles(String[] listOfFileNames)
    {
        for(String file : listOfFileNames)
        {
            List<BabyName> nameArrayAddress;
            if(file.equals("boynames2020.txt"))
            {
                nameArrayAddress = boyNames;
            }
            else
            {
                nameArrayAddress = girlNames;
            }
            
            Scanner inputStream = null;
            try
            {
                inputStream = new Scanner(new FileInputStream(file));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Error: File " + file + " was not found");
                System.out.println("or could not be opened!");
                System.exit(0);
            }
            
            int index = 0;    
            while(inputStream.hasNextLine())
            {
                nameArrayAddress.add(new 
                        BabyName(inputStream.next(), 
                        inputStream.nextInt(),
                        index + 1));
                index++;
            }
                
            inputStream.close();
        }
    }//End private void readFiles(String[])
    
    /**
     * Give the name, frequency, and rank of the first twenty girl names in a 
     * vertical list
     * 
     * @return A formatted String of the first twenty girl name records 
     */
    public String getFirstTwentyGirlNames( )
    {
        String result = "";
        for(int i = 0; i < 20; i++)
        {
            result = result + girlNames.get(i).toString() + "\n";
        }
        return result;
    }//End public String getFirstTwentyGirlNames( )
    
    /**
     * Search the boyNames list for the desired name, but this method is meant
     * for outside classes to call it so they don't have to worry about the
     * index parameters
     * 
     * @param target    The name to be searched for
     * @return          The BabyName object containing the name, frequency, and
     *                  rank (or null if the name was not found)
     */
    public String[] searchBoyName(String target)
    {   
        BabyName resultOfSearch = findBoyName(target, 0, UPPER_INDEX);
        if(resultOfSearch == null)
        {
            return null;
        }
        String[] nameInformation = {resultOfSearch.name, 
            resultOfSearch.frequency + "", resultOfSearch.rank + ""};
        return nameInformation;
    }//End public BabyName searchBoyName(String)
    
    /**
     * Find a specified boy name in the list using binary search (recursively). 
     * Returns the BabyName object or null if the name is not on the list
     * 
     * @param target        The name to find on the list
     * @param lowerIndex    The lower bound to check on the list (a zero should
     *                      be passed as an argument the first time this method
     *                      is called)
     * @param upperIndex    The upper bound to check on the list 
     *                      (BabyNamesModel.UPPER_INDEX should be passed as an 
     *                      argument the first time this method is called)
     * @return              The BabyName object containing the name, frequency, 
     *                      and rank (or null if the name was not found)
     */
    private BabyName findBoyName(String target, int lowerIndex, int upperIndex)
    {
        if(lowerIndex > upperIndex)
        {
            return null;
        }
        
        int middle = (lowerIndex + upperIndex) / 2;
        int comparisonValue = 
                target.compareToIgnoreCase(boyNames.get(middle).name);
        
        if(comparisonValue == 0)
        {
            return new BabyName(boyNames.get(middle));
        }
        else if(comparisonValue > 0)
        {
            return findBoyName(target, middle + 1, upperIndex);
        }
        else
        {
            return findBoyName(target, lowerIndex, middle - 1);
        }
    }//End private BabyName findBoyName(String, int, int)
    
    /**
     * Search the girlNames list for the desired name, but this method is meant
     * for outside classes to call it so they don't have to worry about the
     * index parameters
     * 
     * @param target    The name to be searched for
     * @return          The BabyName object containing the name, frequency, and
     *                  rank (or null if the name was not found)
     */
    public String[] searchGirlName(String target)
    {
        BabyName resultOfSearch = findGirlName(target, 0, UPPER_INDEX);
        if(resultOfSearch == null)
        {
            return null;
        }
        String[] nameInformation = {resultOfSearch.name, 
            resultOfSearch.frequency + "", resultOfSearch.rank + ""};
        return nameInformation;
    }//End public BabyName searchGirlName(String)
    
    /**
     * Find a specified girl name in the list using binary search (recursively). 
     * Returns the BabyName object or null if the name is not on the list
     * 
     * @param target        The name to find on the list
     * @param lowerIndex    The lower bound to check on the list (a zero should
     *                      be passed as an argument the first time this method
     *                      is called)
     * @param upperIndex    The upper bound to check on the list 
     *                      (BabyNamesModel.UPPER_INDEX should be passed as an 
     *                      argument the first time this method is called)
     * @return              The BabyName object containing the name, frequency, 
     *                      and rank (or null if the name was not found)
     */
    private BabyName findGirlName(String target, int lowerIndex, int upperIndex)
    {
        if(lowerIndex > upperIndex)
        {
            return null;
        }
        
        int middle = (lowerIndex + upperIndex) / 2;
        int comparisonValue = 
                target.compareToIgnoreCase(girlNames.get(middle).name);
        
        if(comparisonValue == 0)
        {
            return new BabyName(girlNames.get(middle));
        }
        else if(comparisonValue > 0)
        {
            return findGirlName(target, middle + 1, upperIndex);
        }
        else
        {
            return findGirlName(target, lowerIndex, middle - 1);
        }
    }//End private BabyName findGirlName(String, int, int)
    
    /**
     * sortBoyNames uses merge sort (recursion) to sort the list of boy names 
     * by name alphabetically
     * 
     * @param lowerIndex    The lower bounds of the merge sort (0 first time)
     * @param upperIndex    The upper bounds of the merge sort (length - 1)
     */
    private void sortBoyNames(int lowerIndex, int upperIndex)
    {
        if(upperIndex - lowerIndex <= 0)
        {
            return;
        }
        
        sortBoyNames(lowerIndex, (lowerIndex + upperIndex) / 2);
        sortBoyNames((lowerIndex + upperIndex) / 2 + 1, upperIndex);
        
        merge(boyNames, lowerIndex, upperIndex);
    }//End public void sortBoyNames(int, int)
    
    /**
     * sortGirlNames uses merge sort (recursion) to sort the list of girl names 
     * by name alphabetically
     * 
     * @param lowerIndex    The lower bounds of the merge sort (0 first time)
     * @param upperIndex    The upper bounds of the merge sort (length - 1)
     */
    private void sortGirlNames(int lowerIndex, int upperIndex)
    {
        if(upperIndex - lowerIndex <= 0)
        {
            return;
        }
        
        sortGirlNames(lowerIndex, (lowerIndex + upperIndex) / 2);
        sortGirlNames((lowerIndex + upperIndex) / 2 + 1, upperIndex);
        
        merge(girlNames, lowerIndex, upperIndex);
    }//End public void sortGirlNames(int, int)
    
    /**
     * Sort and combine sub-sections of the lists of boy and girl names
     * 
     * @param nameArray     Address to the instance field of boy or girl names
     * @param lowerBound    The smaller index of the range of the sub-section
     * @param upperBound    The greater index of the range of the sub-section
     */
    private void merge(List<BabyName> nameArray, int lowerBound, 
            int upperBound)
    {
        BabyName[] tempSortedArray = new BabyName[upperBound - lowerBound + 1];
        int i = 0;
        
        int l = lowerBound;
        int u = (lowerBound + upperBound) / 2 + 1;
        
        //Find the "smaller" of the two values in the two sub-sections
        while(l <= (lowerBound + upperBound) / 2 &&
                u <= upperBound)
        {
            if(nameArray.get(l).compareTo(nameArray.get(u)) <= 0)
            {
                tempSortedArray[i] = nameArray.get(l);
                i++;
                l++;
            }
            else
            {
                tempSortedArray[i] = nameArray.get(u);
                i++;
                u++;
            }
        }
        
        //Once one sub-section reaches the end, copy the remaining sub-section
        if(l > (lowerBound + upperBound) / 2)
        {
            while(u <= upperBound)
            {
                tempSortedArray[i] = nameArray.get(u);
                i++;
                u++;
            }
        }
        else
        {
            while(l <= (lowerBound + upperBound) / 2)
            {
                tempSortedArray[i] = nameArray.get(l);
                i++;
                l++;
            }
        }
        
        //Write over the current section with the combined/sorted sub-sections
        for(int index = lowerBound; index <= upperBound; index++)
        {
            nameArray.set(index, tempSortedArray[index - lowerBound]);
        }
    }//End private void merge(BabyName[], int, int)
    
    /**
     * Description: Helper class for the BabyNames Model. BabyName stores the
     *              record of each name, frequency, and rank for each of the 
     *              1,000 boy and 1,000 girl names. BabyNamesModel will contain
     *              two arrays of type BabyName to store each record for boy 
     *              and girl names.
     * <p>
     *              This class supports the Inner and Outer class concept
     * <p>
     * @author Alex McRandal amcranda@heidelberg.edu 
     * @author Brandon Hughes bhughes1@heidelberg.edu
     * @version 19-Mar-2021
     */
    private class BabyName implements Comparable<BabyName>
    {
    
        //-------Instance Fields-------
    
    
        /**
         * The name of a child
         */
        private String name;
    
        /**
         * The number of times name was registered in 2003
         */
        private int frequency;
    
        /**
         * The rank of the name from 1 to 1,000
         */
        private int rank;
    
    
        //--------Constructors-------
    
    
        /**
         * Create a record of a name ,the number of times it was registered, and
         * the rank it holds out of 1,000 names
         * 
         * @param newName       The name of a child
         * @param newFrequency  The number of times the name was registered
         * @param newRank       The rank of a child name
         */
        public BabyName(String newName, int newFrequency, int newRank)
        {
            name = newName;
            frequency = newFrequency;
            rank = newRank;
        }//End public BabyName(String, int)
    
        /**
         * No-arg constructor for a BabyName object
         */
        public BabyName( )
        {
            name = "No name yet";
            frequency = 0;
            rank = 1;
        }//End public BabyName( )
    
        /**
         * Copy constructor
         * 
         * @param originalBabyName The BabyName object to be cloned
         */
        public BabyName(BabyName originalBabyName)
        {
            name = originalBabyName.name;
            frequency = originalBabyName.frequency;
            rank = originalBabyName.rank;
        }//End public BabyName(BabyName)
    
    
        //-------Instance Methods-------
    
    
        /**
         * Compare the field name of each BabyName object to find out
         * which name comes first alphabetically
         * 
         * @param otherBabyName The other BabyName object to be compared with
         * @return              -A negative number if this precedes other
         *                      -Zero if this and other have the same name
         *                      -A positive number if this follows other
         */
        @Override
        public int compareTo(BabyName otherBabyName)
        {  
            return this.name.compareToIgnoreCase(otherBabyName.name);
        }//End public int compareTo(Object)
    
        /**
         * Format the number of times a certain name was registered into a String
         * 
         * @return  A String representation of the name and number of times it 
         *          was used
         */
        @Override
        public String toString( )
        {
            return "Name: " + name + "  Frequency: " + frequency + 
                    "  Rank: " + rank;
        }//End public String toString( )
    
    }//End private class BabyName implements Comparable<BabyName>
    
}//End public class BabyNamesModel
