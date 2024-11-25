// Package Dec
package cscd210methods;

// Import Statements
import java.util.Scanner;


// MAIN CLASS
public class CSCD210Methods {

// Global Variables
static Scanner kb;

    static {
        kb = new Scanner(System.in);
    }

    static int usrChoice;
static int theNum; //The One to Rule Them All?!



    public static int readPosNum(Scanner kb) throws IllegalArgumentException {

        boolean valid = false;

        // Null Scanner Throw
        if (kb == null) {
            throw new IllegalArgumentException("The scanner can't be null");
        }

        while (!valid){
            System.out.println("Please enter a positive integer: ");

            if (kb.hasNextInt()) {
                theNum = kb.nextInt();

                if (theNum > 0){
                    valid = true;
                }
                else{
                    System.out.println("The number must be greater than 0: ");
                    System.out.println('\n');
                }

            } else {
                System.out.println("Invalid input. Please enter a positive integer: ");
                kb.next(); // Nom-Nom Invalid in
            }
        }
        return theNum;
    }// EoPos   //DONE


    public static int menu(Scanner kb) throws IllegalArgumentException {

        if (kb == null) {
            throw new IllegalArgumentException("The scanner can't be null");
        }

        else {
            // MENU SELECTION
            System.out.println("1) Enter a new number");
            System.out.println("2) Print the number off even/odds/zeros");
            System.out.println("3) Print if the number is light or heavy");
            System.out.println("4) Print the value of E");
            System.out.println("5) Print number in reverse order");
            System.out.println("6) Exit");

            // USER PROMPT
            System.out.print('\n');
            System.out.println("Please Select an Operation: ");
            usrChoice = kb.nextInt();

            switch (usrChoice) {

                case 1:
                    readPosNum(kb);
                    System.out.println("Number: " + theNum);
                    menu(kb);
                    break;
                // Select new #
                // Print #

                case 2:
                    oddEvenZero(theNum);
                    menu(kb);
                    break;
                // Print number of odds/evens/zeros
                // Reuse old code to save time

                case 3:
                    lightOrHeavy(theNum,kb);
                    menu(kb);
                    break;
                    // Print if num is light or heavy

                case 4:
                    printE(theNum);
                    menu(kb);
                    break;
                    // Print Val of E

                case 5:
                    printReverse(theNum);
                    menu(kb);
                    break;
                    // Print num in reverse order

                case 6:
                    System.out.println("Bye-Bye!");
                    break;

                default:
                    System.out.println("Please Make a Valid Menu Entry: ");
                    menu(kb);
            }

        }
        //Switch for Menu
        return 0;

    }//EoMain    //CHECK


    public static void oddEvenZero(int theNum) throws IllegalArgumentException {

        // Exception for neg num && 0
        if (theNum <= 0) {
            throw new IllegalArgumentException("The number must be positive & non-zero");
        }

        else {
            // Convert num to string just for odds, evens, zeros op
            String numStr = Integer.toString(theNum);

            // O,E,Z Runtime Variables
            int evenCount = 0;
            int oddCount = 0;
            int zeroCount = 0;

            // Number sorting runtime
            for (int i = 0; i < numStr.length(); i++) {

                char digitChar = numStr.charAt(i);
                int digit = Character.getNumericValue(digitChar);

                if (digit == 0) {
                    zeroCount++;
                } else if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }


            // Even & Odds Routine Output
            System.out.println("The number of even digits is: " + evenCount);
            System.out.println("The number of odd digits is: " + oddCount);
            System.out.println("The number of zeros is: " + zeroCount);
            System.out.println('\n');

        }
    }//EoZero  //DONE


    public static void lightOrHeavy(int theNum, Scanner kb) throws IllegalArgumentException {
        // Throw for null scanner or num <1
        if (theNum <= 0 ) {
            throw new IllegalArgumentException("The number must be positive & non-zero");
        }
        if (kb == null) {
            throw new IllegalArgumentException("The scanner can't be null");
        }
        else {
            // Nums must be in string to check # of digits

            String num1Str = Integer.toString(theNum);
            int sum1 = 0;

            for (int i = 0; i < num1Str.length(); i++) {
                sum1 += Character.getNumericValue(num1Str.charAt(i));
            }
            int avg1 = sum1 / num1Str.length();

            System.out.println('\n');
            System.out.println("Please Insert a 2nd number: ");
            int num2 = kb.nextInt();

            String num2Str = Integer.toString(num2);
            int sum2 = 0;

            for (int i = 0; i < num2Str.length(); i++) {
                sum2 += Character.getNumericValue(num2Str.charAt(i));
            }

            int avg2 = sum2 / num2Str.length();

            if (avg1 > avg2){
                System.out.println('\n');
                System.out.println("The number is heavy");
                System.out.println('\n');
            }
            else{
                System.out.println('\n');
                System.out.println("The number is light");
                System.out.println('\n');
            }

            //Debug:
            //System.out.println(avg1 + " and " + avg2);






            // Count # of digits of pos#
            // Perform Sum of digits
            // Perform Sum/# of digits = avg1

            // Ask for Second #
            // Count # of digits
            // Perform Sum of digits
            // Perform Sum/# of digits = avg2

            // if avg1 > avg2, num is heavy
            // if avg1 < avg2 || avg1 == avg2, num is light


        }
    }//EoLight  //DONE


    public static void printE(int theNum) throws IllegalArgumentException {

        // Throw if num < 1
        if (theNum <= 0) {throw new IllegalArgumentException("The number must be positive & non-zero");}

        else {

         double eValue = Math.pow(1 + 1.0 / theNum, theNum);
         int eIntValue = (int) Math.round(eValue);

         System.out.println(eIntValue);
         System.out.println('\n');

        }
    }//EoPrint   //DONE


    public static void printReverse(int theNum) throws IllegalArgumentException {
        // Throw if num < 1
        if (theNum <= 0) {
            throw new IllegalArgumentException("The number must be positive & non-zero");
        }
        StringBuilder reversed = new StringBuilder();

        while (theNum > 0){
           reversed.append(theNum % 10);
           theNum /= 10;
        }
        System.out.println(reversed);
        System.out.println('\n');
    }//EoRev   //DONE


} // EoClass