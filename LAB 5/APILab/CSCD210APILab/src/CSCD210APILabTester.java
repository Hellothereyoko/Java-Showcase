
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CSCD210APILabTester {
    public static void main(String[] args) {
        // Prepare input data
        String input = "a\nDavid James Leap\n1988\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        // Capture output
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(testOutput));

        // Run the main method of CSCD210APILab
        CSCD210APILab.main(args);

        // Restore original System.out
        System.setOut(originalOut);

        // Expected outputs
        String expectedOutput = "Please enter a single alphabetic character (lowercase): " +
                "Please enter your full name (first middle last): " +
                "Please enter your birth year: " +
                "The first letter of your name is: D\n" +
                "The last letter of your name is: p\n" +
                "Your middle name is: James\n" +
                "Hash code of last name + YEAR + birth year: 36185008 \n" +
                "Name with character 'a' replaced: D?vid J?mes Le?p\n";

        // Print expected and actual outputs
        System.out.println("--- Expected Results ---");
        System.out.println(expectedOutput);

        System.out.println("\n--- Actual Results ---");
        System.out.println(testOutput);
    }
}