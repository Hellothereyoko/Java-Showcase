import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CSCD210MathLabTester {
    public static void main(String[] args) {
        // Test case: Known input and expected output
        String simulatedInput = "David\n100\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        System.out.println("Running Test Case...");
        System.out.println("Input: Skier's name = David, Winning time = 100");
        System.out.println("Expected Results:");
        System.out.print("25.00 meters per second,\n");
        System.out.print("82.02 feet per second,\n");
        System.out.print("90 kilometers per hour,\n");
        System.out.print("55.92 miles per hour,\n");
        System.out.print("It would take 1 minutes and 4.37 seconds to ski one mile.\n");
        System.out.print("It would take 3.66 seconds to ski 100 yards.\n");
        System.out.println();
        System.out.println("Actual Results:");;
        // Run the main method of CSCD210MathLab to get actual results
        CSCD210MathLab.main(new String[]{});

        // Restore original System.in
        System.setIn(originalIn);
    }
}