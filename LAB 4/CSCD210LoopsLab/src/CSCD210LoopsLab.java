// Module Imports
import java.util.Scanner;
import java.util.ArrayList;


public class CSCD210LoopsLab {

    public static void main(String[] args) {

        // Scanner Init
        Scanner input = new Scanner(System.in);

        // Bool to control when to jump to program beginning
        boolean start = true;


        // Function that acts more like a label jump
        while (start) {

            // Initialize usrnum to an invalid state (e.g., -1) to keep menu until valid
            int usrnum = -1;

            // Using a do-while loop for user input validation
            do {
                System.out.println("Please pick a non-negative integer to start: ");
                System.out.print('\n');

                // Check if the input is an integer or a float
                if (!input.hasNextInt()) {

                    // Non int input error
                    System.out.println("Invalid input. Please enter a non-negative integer.");
                    input.next(); // Clear the invalid input
                }

                else {

                    // Read the valid input
                    usrnum = input.nextInt();

                    // Validate the input
                    if (usrnum <= 0) {

                        // If the input integer isn't above 0
                        System.out.println("Input must be greater than 0.");
                        System.out.println("\n");
                    }
                }
            }

            // Repeat until a valid number is entered
            while (usrnum <= 0);

            // Bool is set after valid int to move on
            boolean menu = true;

                    while (menu) {

                    // Main Menu Selection Screen

                    System.out.println("Please select a menu option: ");
                    System.out.println('\n');
                    System.out.println("1) Pick a new Integer");
                    System.out.println("2) Print number of odds,evens,and zeros in Integer");
                    System.out.println("3) Print prime numbers 2-Integer");
                    System.out.println("4) Quit Program");
                    System.out.println('\n');


                    // User choice for operation menu
                    int choice = input.nextInt();


                        // Choice logic tree
                        switch (choice) {

                            // Choose another integer
                            case 1:
                                System.out.println("Okay. On it!");
                                menu = false;
                                break;

                            // # of odd,even, & zeros in integer (O,E,Z)
                            case 2:

                                // Convert num to string just for odds, evens, zeros op
                                String numStr = Integer.toString(usrnum);

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

                                menu = true;
                                break;

                                // Prime # 2-integer
                                case 3:

                                // Array List for Primes
                                ArrayList<Integer> primenums = new ArrayList<>();

                                // Prime # Routine
                                for (int i = 2; i <= usrnum; i++) {
                                    boolean isPrime = true; // Assume i is prime

                                    // Check for factors from 2 to the square root of i
                                    for (int j = 2; j * j <= i; j++) {
                                        if (i % j == 0) { // Found a divisor, not prime
                                            isPrime = false;// ID to store prime staus of num
                                            break; // No need to check further
                                        }
                                    }
                                    // If the num has prime status add it to list
                                    if (isPrime) {
                                        primenums.add(i);
                                    }
                                    // Else do nothing
                                }

                                // Prime Routine Output
                                if (usrnum > 1) {
                                    System.out.println("Prime numbers between " + 2 + " and " + usrnum + " are: " + primenums);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Prime numbers between " + 2 + " and " + 0 + " are: \n");
                                    System.out.println("\n");
                                }

                                menu = true;
                                break;


                            case 4: // Program quits by change bool to false
                                System.out.println("Bye-Bye!");
                                return;

                            default: // If menu option isn't valid or default state for non valid input
                                System.out.println("Invalid menu input. Try again:");
                                System.out.println('\n');
                                break;
                        } // EoChoice

                    } // EoMenu

                } // EoStart

            } // EoMethod

        } // EoClass



