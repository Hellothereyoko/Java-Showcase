import java.io.*;

public class CSCD210WarmupLabTester {
    public static void main(String[] args) {
        // Test inputs
        String[] shoeSizes = {"8", "10", "-5", "12.5"};
        String[] birthYears = {"1983", "1990", "-1000", "2000"};
        String[] expectedOutputs = {"08,41", "10,34", "25,24", "InputMismatchException"};

        for (int i = 0; i < shoeSizes.length; i++) {
            String input = shoeSizes[i] + "\n" + birthYears[i] + "\n";

            // Backup original System.in and System.out
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;

            // Set up new input and output streams
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream testOut = new ByteArrayOutputStream();

            System.setIn(testIn);
            System.setOut(new PrintStream(testOut));

            try {
                // Run the student's main method
                CSCD210WarmupLab.main(new String[0]);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }

            // Restore original System.in and System.out
            System.setIn(originalIn);
            System.setOut(originalOut);

            // Display the test case results
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input:");
            System.out.println(input);
            System.out.println("Expected Output:");
            System.out.println(expectedOutputs[i]);
            System.out.println();
            System.out.println("Output:");
            System.out.println(testOut.toString());
            System.out.println("--------------------------------------------------");
        }
    }
}
