package cscd210clocklab;

import cscd210classes.Clock;

/**
 * My main used to test. You can't change this file in any fashion
 */
public class CSCD210ClockLab
{
   /** 
    * The main method that can't be changed
    * @param args Representing command line arguments
    */

	public static void main(final String [] args)
	{
		Clock one = new Clock();
      Clock two = new Clock(10, 59, 0);
      Clock three = new Clock(12, 45, 15);
      
      System.out.println("Clock 3 " + three);
      System.out.println("Clock 3 Hour " + three.getHour());
      System.out.println("Clock 3 Minutes:Seconds " + three.getMinutes() + ":" + three.getSeconds());
      
      System.out.println();
      System.out.println("Clock 1 " + one);
      
      one.setHour(3);
      System.out.println("Clock 1 after setting hours by 3 hours " + one);
      
      one.setHour(25);
      System.out.println("Clock 1 after setting hours by 25 hours " + one);
      
      System.out.println();
      System.out.println("Clock 2 " + two);
      
      two.setMinutes(20);
      System.out.println("Clock 2 after setting minutes by 20 minutes " + two);
      
      two.setMinutes(170);
      System.out.println("Clock 2 after setting minutes by 170 minutes " + two);
          
   }// end main

}// end class



