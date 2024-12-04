import cscd210utils.ArrayUtils;
import cscd210utils.IntStatisticsUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArrayLabsTester.MyTestWatcher.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayLabsTester {
    private final PrintStream ORIGINAL_OUT = System.out;
    private final InputStream ORIGINAL_IN = System.in;

    private ByteArrayOutputStream testOut;
    private ByteArrayInputStream testIn;
    private static PrintStream fout;
    private static int passed = 0;
    private static int count = 0;

    static {
        try {
            fout = new PrintStream("results.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class MyTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(ExtensionContext context) {
            String testName = context.getDisplayName();
            fout.println(testName + " : PASSED");
            passed++;
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            String testName = context.getDisplayName();
            fout.println(testName + " : FAILED");
            fout.println("Reason: " + cause.getMessage());
        }
    }

    @BeforeAll
    public static void setUp() {
        fout.println("Beginning of Tests");
    }

    @AfterAll
    public static void wrapUp() {
        fout.println("End of Tests");
        fout.println("Passed: " + passed);
        fout.println("Failed: " + (count - passed));
        fout.close();
    }

    @BeforeEach
    public void init() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        count++;
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(ORIGINAL_OUT);
        System.setIn(ORIGINAL_IN);
    }

    private void injectInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    // =======================
    // Array Utilities Tests
    // =======================

    @Test
    @Order(1)
    public void testCreateAndFillArray_ValidInput() {
        injectInput("10\n20\n30\n40\n50\n");
        Scanner kb = new Scanner(System.in);
        int[] array = ArrayUtils.createAndFillArray(5, kb);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, array);
    }

    @Test
    @Order(2)
    public void testAddNum_ValidInput() {
        injectInput("60\n");
        Scanner kb = new Scanner(System.in);
        int[] original = {10, 20, 30, 40, 50};
        int[] newArray = ArrayUtils.addNum(original, kb);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50, 60}, newArray);
    }

    @Test
    @Order(3)
    public void testDeleteSingleValue_ValueExists() {
        injectInput("30\n");
        Scanner kb = new Scanner(System.in);
        int[] original = {10, 20, 30, 40, 50};
        int[] newArray = ArrayUtils.deleteSingleValue(original, kb);
        assertArrayEquals(new int[]{10, 20, 40, 50}, newArray);
    }

    @Test
    @Order(4)
    public void testDeleteSingleValue_ValueNotFound() {
        injectInput("60\n");
        Scanner kb = new Scanner(System.in);
        int[] original = {10, 20, 30, 40, 50};
        int[] newArray = ArrayUtils.deleteSingleValue(original, kb);
        assertArrayEquals(original, newArray); // Should return the original array
    }

    @Test
    @Order(5)
    public void testPrintArray_ValidArray() {
        int[] array = {10, 20, 30, 40, 50};
        ArrayUtils.printArray(array);
        String result = testOut.toString().trim();
        assertEquals("[10, 20, 30, 40, 50]", result);
    }

    // =========================
    // Statistic Utilities Tests
    // =========================

    @Test
    @Order(6)
    public void testComputeMean_ValidInput() {
        int[] array = {1, 2, 3, 4, 5};
        double mean = IntStatisticsUtils.computeMean(array);
        assertEquals(3.0, mean);
    }

    @Test
    @Order(7)
    public void testComputeMedian_OddLength() {
        int[] array = {3, 1, 5, 7, 9};
        double median = IntStatisticsUtils.computeMedian(array);
        assertEquals(5.0, median);
    }

    @Test
    @Order(8)
    public void testComputeMedian_EvenLength() {
        int[] array = {3, 1, 5, 7};
        double median = IntStatisticsUtils.computeMedian(array);
        assertEquals(4.0, median);
    }

    @Test
    @Order(9)
    public void testComputeStdDev_ValidInput() {
        int[] array = {2, 4, 4, 4, 5, 5, 7, 9};
        double stdDev = IntStatisticsUtils.computeStdDev(array);
        assertEquals(2.138, stdDev, 0.001); // Allowing for some margin of error
    }

    @Test
    @Order(10)
    public void testComputeMidpoint_ValidInput() {
        int[] array = {2, 4, 4, 4, 5, 5, 7, 9};
        double midpoint = IntStatisticsUtils.computeMidpoint(array);
        assertEquals(5.5, midpoint);
    }
}
