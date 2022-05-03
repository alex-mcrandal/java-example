# !/usr/bin/env python
# -*- coding: utf-8 -*-

"""  
    CPS 202--Intermediate Computer Programming
    Spring 2021
    Dr. Close

    Copyright (C) 2021 Daryl Close This work is licensed under the Creative
    Commons Attribution-Noncommercial-No Derivative Works 3.0 United States
    License.
     
    File name:    ComputeCDValue.py

    Description:  Non-OO program computes CD values by month based on user
                  inputs. Solves Programming Exercise 5.33, Y. Daniel Liang,
                  Introduction to Programming Using Python, pp. 164-165. 

                  Illustrates/reviews the following:
                  --> basic separation of concerns with division
                      of labor in separate functions. N.B. the data
                      model and delegate are combined in this
                      "pile-of-mud" module.
                  --> bullet-proofing user input via regex in the
                      input validation loops,
                  --> the type() function,
                  --> the while and for loops, 
                  --> simple table layout using format(), and
                  --> optional currency formatting using locale
                      import,
                  --> docstring comments, and PEP 484 and 526 type annotations.
   
    __author__ = "Daryl Close dclose@heidelberg.edu"              
    __version__ = "17-Jan-2021"
"""

import locale  # For currency formatting
import re      # For regular expression functions compile() and match()

def obtain_valid_deposit_amount() -> int:
    """Prompt the user to enter the CD deposit amount.

    Keyboard entry is fully bullet-proofed to allow only positive integers.
    """

    deposit_string: str = input("\nEnter the initial deposit amount"
                               + " (whole number):  ")
    while (not is_valid_number(deposit_string)
           or (type(eval(deposit_string)) != int)
           or (eval(deposit_string) < 1)):
        deposit_string = input("Enter the initial deposit amount"
                               + " (whole number):  ")

    return eval(deposit_string)

def obtain_valid_annual_percent_yield() -> float:
    """Prompt the user to enter the CD annual percentage yield.

    Keyboard entry is fully bullet-proofed to allow only positive doubles.
    """

    annual_percent_yield_string: str = input("Enter annual"
                                          + " yield as percent:\t\t\t  ")
    while (not is_valid_number(annual_percent_yield_string)
           or (eval(annual_percent_yield_string) < 0.0)):
        annual_percent_yield_string = input("Enter annual"
                                         + " yield as percent:\t\t\t  ")
        
    return eval(annual_percent_yield_string)

def obtain_valid_number_of_months() -> int:
    """Prompt the user to enter the number of months in the CD maturity
    period.

    Keyboard entry is fully bullet-proofed to allow only positive integers.
    """

    number_of_months_string: str = input("Enter maturity period (number"
                                      + " of months):\t  ")
    while (not is_valid_number(number_of_months_string)
           or (type(eval(number_of_months_string)) != int)
           or (eval(number_of_months_string) < 1)):
        number_of_months_string = input("Enter maturity period (number"
                                     + " of months):\t  ")
        
    return eval(number_of_months_string)    

def is_valid_number(number_string: str) -> bool:
    """Use regular expression pattern matching to validate numeric string.

    Allow scientific notation.
    """
        
    regex: str = ("^[+\-]?"                  # Match optional sign in the set
                  + "(?:0|[1-9]\d*)"         # Match digits
                  + "(?:\.\d*)?"             # Match dot and more digits
                  + "(?:[eE][+\-]?\d+)?$")   # Match scientific    
    
    number_format: str = re.compile(regex)
    is_number: bool = re.match(number_format, number_string)
    
    return is_number

def main() -> None:
    """Main function to compute and display a table of CD values.

    Validate user inputs of CD deposit amount, annual percentage rate
    of return, and number of months to maturity.  Display a table of
    CD values formatted as U.S. dollars by month for each month of
    the CD.  Use either the locale module and/or the format function
    for table layout and currency formatting.
    """

    # Set locale for currency formatting
    locale.setlocale(locale.LC_ALL, "")
    
    # Print program header
    print("\n\t\tCOMPUTE CD VALUE")

    # Prompt user for inputs
    deposit: int = obtain_valid_deposit_amount()
    annual_percent_yield: float = obtain_valid_annual_percent_yield()
    number_of_months: int = obtain_valid_number_of_months()

    # Print table header
    print("\n" + "Month" + format("CD Value", ">18s") + "\n")

    monthly_interest_rate: float = annual_percent_yield / 1200
    current_value: float = float(deposit)

    # Calculate and print table rows
    for i in range(1, number_of_months + 1, 1):
        # Calculate current value of CD
        current_value = current_value * (1 + monthly_interest_rate)

        # Print table row for current month i
        print(format(i, "<15d") + "$" + format(current_value, ",.2f"))

if __name__ == "__main__":
    main()

# End module ComputeCDValue.py
