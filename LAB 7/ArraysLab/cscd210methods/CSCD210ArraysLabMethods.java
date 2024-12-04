package cscd210methods;

import java.util.Scanner;

/**
 * All parameters will be passed as final. <br>
 * All pre and post conditions will be enforced<br>
 * Methods bodies are provided you don't need to do anything in this class
 */
public class CSCD210ArraysLabMethods
{
   /**
    * The readNum method asks the user to enter a positive integer and ensures the number entered is positive.
    * Positive number is defined as an integer that is greater than 0 
    *
    * <br><br>POSTCONDITION: Clean input buffer <br> <br>
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing a positive number
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int readNum(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params readNum");
         
      int num;
      do
      {
         System.out.print("Please enter an integer greater than 0 for array size: ");
         num = kb.nextInt();
         kb.nextLine();
      }while(num < 1);
      
      return num;
      
   }// end method

   /**
    * The menu method display the following menu and ensures the choice entered is between
    * 1 and 8 inclusive. <br>
    * <br>
    * Menu choices are: <br>
    * 1)	Add a value to the array<br>
    * 2)	Delete a value from the array (by value)<br>
    * 3)	Display the array<br>
    * 4)	Compute the mean of the array<br>
    * 5)	Compute the median of the array<br>
    * 6)	Compute the midpoint of the array<br>
    * 7)	Compute the standard deviation of the array<br>
    * 8)	Quit<br>
    *
    * <br><br>POSTCONDITION: Clean input buffer <br> <br>
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing the menu choice guaranteed to be between 1 and 8 inclusive.
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params menu");
         
      int choice;
      
      do
      {
         System.out.println("1) Add a value to the array");
         System.out.println("2) Delete a value from the array (by value)");
         System.out.println("3) Display the array");
         System.out.println("4) Compute the mean of the array");
         System.out.println("5) Compute the median of the array");
         System.out.println("6) Compute the midpoint of the array");
         System.out.println("7) Compute the standard deviation of the array");
         System.out.println("8) Quit");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         
      }while(choice < 1 || choice > 8);
      
      kb.nextLine();
      
      return choice;
   }// end method
}// end class