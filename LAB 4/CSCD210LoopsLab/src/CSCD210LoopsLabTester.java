import java.io.*;
import java.util.*;

public class CSCD210LoopsLabTester {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Define input scenarios to test
        String[] testInputs = {
                "1020304\n2\n4\n",  // Test for entering a number, counting evens/odds/zeros, quitting
                "-1\n0\n10\n3\n4\n",  // Test error checking for initial negative and zero, prime calculation
                "15\n0\n5\n4\n",  // Test menu choice input validation and counting evens/odds/zeros
                "1\n3\n4\n"  // Test entering the smallest positive number and counting evens/odds/zeros
        };

        // Define the expected outputs for each scenario
        String[] expectedOutputs = {
                "For int == 1020304, choice == 2: \nThe number of even digits is: 2\nThe number of odd digits is: 2\nThe number of zeros is: 3\n",
                "For int == -1, then int == 0, then int == 10 choice ==3: \nShould reprompt twice for a new number then: \nPrime numbers between 2 and 10 are: [2, 3, 5, 7] \n",
                "For int == 15, and choice == 0, then choice == 5 then choice == 4:  \nInvalid choice message and reprompt twice, then: \nGood Bye\n",
                "For int == 1, and choice == 3 \nPrimer numbers between 2 and 0 are: \n"
        };

        // Redirect System.in and System.out for testing
        for (int i = 0; i < testInputs.length; i++) {
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;

            try (ByteArrayInputStream testIn = new ByteArrayInputStream(testInputs[i].getBytes());
                 ByteArrayOutputStream testOut = new ByteArrayOutputStream()) {
                System.setIn(testIn);
                System.setOut(new PrintStream(testOut));

                // Run the student's code
                CSCD210LoopsLab.main(null);

                // Get the actual output
                String actualOutput = testOut.toString().trim();

                // Print expected and actual results
                System.setOut(originalOut);
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println("Expected Output:");
                System.out.println(expectedOutputs[i]);
                System.out.println();
                System.out.println("Actual Output:");
                System.out.println(actualOutput);
                System.out.println("-----------------------------------\n");
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
}
