package cscd210arrayslab;

import java.util.Scanner;

import cscd210utils.ArrayUtils;

import cscd210utils.IntStatisticsUtils;

import cscd210methods.CSCD210ArraysLabMethods;

/**
 * The class that contains the main method
 */
public class CSCD210ArraysLab
{
   /**
    * The main method you can't change.<br>
    *<br>
    * Note: main exits normally not with a System.exit(0);
    *
    * @param args Representing the array of command line parameters
    */
   public static void main(String [] args)
   {
      int num, choice;
      int [] myArray = null;
      Scanner kb = new Scanner(System.in);
      double mean, median, midpoint, stdDev;

      num = CSCD210ArraysLabMethods.readNum(kb);

      myArray = ArrayUtils.createAndFillArray(num, kb);

      do
      {
         choice = CSCD210ArraysLabMethods.menu(kb);

         switch(choice)
         {
            case 1:  myArray = ArrayUtils.addNum(myArray, kb);
                     break;

            case 2:  myArray = ArrayUtils.deleteSingleValue(myArray, kb);
                     break;

            case 3:  ArrayUtils.printArray(myArray);
                     break;

            case 4:  mean = IntStatisticsUtils.computeMean(myArray);
                     IntStatisticsUtils.printResults("Mean", mean);
                     break;

            case 5:  median = IntStatisticsUtils.computeMedian(myArray);
                     IntStatisticsUtils.printResults("Median", median);
                     break;

            case 6:  midpoint = IntStatisticsUtils.computeMidpoint(myArray);
                     IntStatisticsUtils.printResults("Midpoint", midpoint);
                     break;

            case 7:  stdDev = IntStatisticsUtils.computeStdDev(myArray);
                     IntStatisticsUtils.printResults("Standard Deviation", stdDev);
                     break;
            
            case 8:  System.out.println("All Done");

         }// end switch

      }while(choice != 8);

      System.out.println("Good Bye");

   }// end main

}// end class