// Package Declaration
package cscd210methodsmain;

// Import Statements
import cscd210methods.CSCD210Methods;
import java.util.Scanner;

public class CSCD210MethodsMain {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // Step 1: Get Positive Number
        int theNum = CSCD210Methods.readPosNum(kb);

        // Step 2: Run Menu Loop
        int usrChoice;
        do {
            usrChoice = CSCD210Methods.menu(kb); // Display Menu and Get Choice
            switch (usrChoice) {
                case 1 -> theNum = CSCD210Methods.readPosNum(kb); // Enter New Number
                case 2 -> CSCD210Methods.oddEvenZero(theNum); // Count Even, Odd, Zero
                case 3 -> CSCD210Methods.lightOrHeavy(theNum, kb); // Light or Heavy Check
                case 4 -> CSCD210Methods.printE(theNum); // Print Approximation of E
                case 5 -> CSCD210Methods.printReverse(theNum); // Print Reverse
                case 6 -> System.out.println("Bye-Bye!"); // Exit
                default -> System.out.println("Invalid selection. Try again.");
            }
        } while (usrChoice != 6); // Loop until Exit
    }
}
