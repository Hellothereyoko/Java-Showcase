
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.Scanner;
import cscd210methods.CSCD210Methods;

public class CSCD210MethodsTests {

    @Test
    public void testReadPosNumSignature() throws NoSuchMethodException {
        Method readPosNum = CSCD210Methods.class.getMethod("readPosNum", Scanner.class);
        assertEquals(int.class, readPosNum.getReturnType(), "readPosNum should return an int");
    }

    @Test
    public void testMenuSignature() throws NoSuchMethodException {
        Method menu = CSCD210Methods.class.getMethod("menu", Scanner.class);
        assertEquals(int.class, menu.getReturnType(), "menu should return an int");
    }

    @Test
    public void testLightOrHeavySignature() throws NoSuchMethodException {
        Method lightOrHeavy = CSCD210Methods.class.getMethod("lightOrHeavy", int.class, Scanner.class);
        assertEquals(void.class, lightOrHeavy.getReturnType(), "lightOrHeavy should return void");
    }

    @Test
    public void testPrintESignature() throws NoSuchMethodException {
        Method printE = CSCD210Methods.class.getMethod("printE", int.class);
        assertEquals(void.class, printE.getReturnType(), "printE should return void");
    }

    @Test
    public void testPrintReverseSignature() throws NoSuchMethodException {
        Method printReverse = CSCD210Methods.class.getMethod("printReverse", int.class);
        assertEquals(void.class, printReverse.getReturnType(), "printReverse should return void");
    }

    @Test
    public void testOddEvenZeroSignature() throws NoSuchMethodException {
        Method oddEvenZero = CSCD210Methods.class.getMethod("oddEvenZero", int.class);
        assertEquals(void.class, oddEvenZero.getReturnType(), "oddEvenZero should return void");
    }

    @Test
    public void testReadPosNumThrowsExceptionForNullScanner() {
        Scanner nullScanner = null;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.readPosNum(nullScanner), "readPosNum should throw IllegalArgumentException for null scanner");
    }

    @Test
    public void testMenuThrowsExceptionForNullScanner() {
        Scanner nullScanner = null;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.menu(nullScanner), "menu should throw IllegalArgumentException for null scanner");
    }

    @Test
    public void testLightOrHeavyThrowsExceptionForInvalidNumber() {
        int invalidNumber = -5;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.lightOrHeavy(invalidNumber, new Scanner(System.in)), "lightOrHeavy should throw IllegalArgumentException for invalid number");
    }

    @Test
    public void testLightOrHeavyThrowsExceptionForNullScanner() {
        Scanner nullScanner = null;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.lightOrHeavy(10, nullScanner), "lightOrHeavy should throw IllegalArgumentException for null scanner");
    }

    @Test
    public void testPrintEThrowsExceptionForInvalidNumber() {
        int invalidNumber = -5;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.printE(invalidNumber), "printE should throw IllegalArgumentException for invalid number");
    }

    @Test
    public void testPrintReverseThrowsExceptionForInvalidNumber() {
        int invalidNumber = -5;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.printReverse(invalidNumber), "printReverse should throw IllegalArgumentException for invalid number");
    }

    @Test
    public void testOddEvenZeroThrowsExceptionForInvalidNumber() {
        int invalidNumber = -5;
        assertThrows(IllegalArgumentException.class, () -> CSCD210Methods.oddEvenZero(invalidNumber), "oddEvenZero should throw IllegalArgumentException for invalid number");
    }
}
