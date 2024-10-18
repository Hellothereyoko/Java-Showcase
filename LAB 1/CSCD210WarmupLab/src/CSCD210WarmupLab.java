// Data from kybd
import java.util.Scanner;

// REQUIRED PACKAGE
import java.text.DecimalFormat;

// Used to output to a txt file
import java.io.FileWriter;

// If God forbid something breaks
import java.io.IOException;


public class CSCD210WarmupLab {
    public static void main(String[] args) {

        // Input method called
        Scanner input = new Scanner(System.in);

        // Global Variable Declaration
        boolean cont_state = true;


        // Continue loop
        while (cont_state) {

            // User Input Collection
            System.out.println("Please input your shoe size:");
            int shoeSize = input.nextInt();


            System.out.println("What year were you born? (YYYY):");
            int bYear = input.nextInt();


            // Format for output
            DecimalFormat fmt = new DecimalFormat("00,00");
            String result = fmt.format((shoeSize * 5 + 50) * 20 + 1024 - bYear);


            // Program Output to User
            System.out.println("Your shoe size are the numbers before the comma, and your age (assuming you've had your bday this year) are the numbers after the comma:");// Reformatting the result due to padding
            System.out.println(result);


            // File Output Routine (Does not output pgrm errors)
            // Dialog between user & prgm output to file

            String output2File = result;
            try (FileWriter writer = new FileWriter("cscd210warmuplabout.txt", true)) {       // enable appending to file instead of rewrite

                writer.write("Program:");
                writer.write("Please input your shoe size:");
                writer.write(System.lineSeparator());

                writer.write("User:");
                writer.write(String.valueOf(shoeSize));
                writer.write(System.lineSeparator());


                writer.write("Program:");
                writer.write("What year were you born?:");
                writer.write(System.lineSeparator());
                writer.write("User:");
                writer.write(String.valueOf(bYear));
                writer.write(System.lineSeparator());

                writer.write("Program:");
                writer.write("Your shoe size are the numbers before the comma, and your age (assuming you've had your bday this year) are the numbers after the comma:");
                writer.write("");
                writer.write(output2File);
                writer.write(System.lineSeparator());
                writer.write(System.lineSeparator());

                System.out.println("\n");
                System.out.println("Exporting...");
                System.out.println("Exported to File!");
            }

            // Only if for some reason file can't be created
            catch (IOException e) {
                System.err.println("There was an issue writing to the file");
            }


            // Re-execute prompt
            System.out.println("Do you want to continue? (yes/no):");
            String response = input.nextLine();


            // Exit the loop if the user doesn't want to continue
            if (!response.equalsIgnoreCase("yes")) {
                cont_state = false;
                System.out.println("Bye-Bye!");
                input.close();
            }
        }
    }
}



/*

Yoko S Parks
CSCD 210
7 Oct 2024

 */
