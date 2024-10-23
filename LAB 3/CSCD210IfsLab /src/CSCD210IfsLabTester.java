/* All statements that start with !! indicate a change made by me
   Original comments are left intact with '//' notation and additional deadspace
   Dependancies needed in CSCD210IfsLab is at the bottom of this program */

import java.io.*;

public class CSCD210IfsLabTester {
    public static void main(String[] args) throws IOException {

        // Prepare test cases

        String[] testInputs = {

                /* !!Change Syntax here!!
                   !!Reformat Array!!
                   !!Inject response to loop!!    */

                "444400003\n444401350\nr\nn\n", // Residential customer, simple case
                "999999997\n5\nr\nn\n",        // Residential customer, meter rollover
                "444400003\n444409003\nb\nn\n",  // Business customer, usage under 999.9 gallons
                "999999997\n5\nb\nn\n",        // Business customer, meter rollover, usage under 999.9 gallons
                "444400000\n444500000\nb\nn\n"   // Business customer, usage above 999.9 gallons
        };

        /* !!Force Gen of new string!! */
        String[] expectedOutputs = new String[]{

                /* !!Rm quotes around new line to fix expression!!
                   !!Deconstruct Compound Statements!!
                   !!Rm comma on last statement!! */

                "Customer Code: r\nBeginning Meter Reading: 444400003\nEnding Meter Reading: 444401350\nGallons of Water Used: 134.7 gallons\nAmount Billed: $ 25.04",
                "Customer Code: r\nBeginning Meter Reading: 999999997\nEnding Meter Reading: 000000005\nGallons of Water Used: 0.8 gallons\nAmount Billed: $ 25.00",
                "Customer Code: b\nBeginning Meter Reading: 444400003\nEnding Meter Reading: 444409003\nGallons of Water Used: 900.0 gallons\nAmount Billed: $ 1500.02",
                "Customer Code: b\nBeginning Meter Reading: 999999997\nEnding Meter Reading: 000000005\nGallons of Water Used: 0.8 gallons\nAmount Billed: $ 1500.00",
                "Customer Code: b\nBeginning Meter Reading: 444400000\nEnding Meter Reading: 444500000\nGallons of Water Used: 10000.0 gallons\nAmount Billed: $ 1500.11"
        };

        // Redirect System.in and System.out for testing

        for (int i = 0; i < testInputs.length; i++) {
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;

            try (ByteArrayInputStream testIn = new ByteArrayInputStream(testInputs[i].getBytes());
                 ByteArrayOutputStream testOut = new ByteArrayOutputStream()) {
                System.setIn(testIn);
                System.setOut(new PrintStream(testOut));

                // Run the student's code no arg
                CSCD210IfsLab.main(null);

                // Get the actual output
                String actualOutput = testOut.toString().trim();

                // Print expected and actual results

                /* !!Add Deadspace for formatting issues!! */
                /* !!Inject new line!! */
                System.setOut(originalOut);
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println("Expected Output:");
                System.out.println();
                System.out.println(expectedOutputs[i]);
                System.out.println('\n');
                System.out.println("Actual Output:");
                System.out.println();
                System.out.println(actualOutput);
                System.out.println("-----------------------------------\n");

            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
}

/*Dependancies Resolved in CSCD210IfsLab.java:

!!input 'nextLine()' after each collection in CSCD210IfsLab to manually flush Scanner module!!
!!physical declaration when input is no longer collected (helps scanner class to not read blank values)!!

*/