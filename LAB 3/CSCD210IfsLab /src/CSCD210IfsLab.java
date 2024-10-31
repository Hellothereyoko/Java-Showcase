/* Modules */
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileWriter;


public class CSCD210IfsLab {

    /* Pre-Initialized Variables */
    static double usage = 0; // main use variable
    static double usage2 = 0; // BUS use only
    static double bill = 0; // Bill cost

    /* Program Constants */
    public static final double RES_BASE = 25.00;
    public static final double BUS_BASE = 1500;
    public static final double BUS_1000 = .00001;


    public static void main(String[] args) {

        /* Initialize that scanner */
        Scanner input = new Scanner(System.in);
        boolean cont_state = true;

        DecimalFormat mtr = new DecimalFormat("000000000"); // Last digit is a dec
        DecimalFormat pay = new DecimalFormat("00.00"); // Dollars & Cents
        DecimalFormat use = new DecimalFormat("0.0"); // Usage to One Decimal


        while (cont_state) {

                /* User Input Started */
                System.out.println("Last Meter Reading: ");
                int lMeter = input.nextInt();
                input.nextLine(); //Clear Scanner Buffer

                System.out.println("Current Meter reading?: ");
                int cMeter = input.nextInt();
                input.nextLine(); //Clear Scanner Buffer

                System.out.println("What is your customer code?: ");
                char cust_code = input.next().charAt(0); //Additional Buffer Clear Not Required


                /* Math used for usage */
                if (cMeter < lMeter) {
                    usage = (((999999999 - lMeter + cMeter) / 10.0) + .1);    //Meter Overflow needs .1 to avoid rounding errors
                } else {
                    usage = ((cMeter - lMeter) / 10.0);    //Divide by 10 to standardize usage in dec notation
                }

            /* Billing Subroutine

             If usage > 999.9 split usage by taking 999.9 - usage = usage2
             use max value for BUS_BASE and carry over to BUS_1000 */

                /* Resident Billing */
                if (cust_code == 'r' || cust_code == 'R') {
                    bill = (RES_BASE + (.0003 * usage));
                }

                /*Business Billing */
                if (cust_code == 'b' || cust_code == 'B') {
                    //Normal BUS usage
                    if (usage < 999.9) {
                        bill = (BUS_BASE + (.00002 * usage));
                    }
                    else {
                        //Extra BUS usage
                        if (usage > 999.9) {
                            usage2 = (usage - 999.9);
                            bill = (BUS_BASE + (.00002 * 999.9) + (BUS_1000 * usage2));
                        }
                    }
                }

                /* Program Output */
                System.out.println("Customer Code: " + cust_code);
                System.out.println("Beginning Meter Reading: " + (mtr.format(lMeter)));
                System.out.println("Ending Meter Reading: " + (mtr.format(cMeter)));
                System.out.println("Gallons of Water Used: " + use.format(usage) + " gallons");
                System.out.println("Amount Billed: " + "$ " + (pay.format(bill)));


            /* File Writer Routine */
            try (FileWriter writer = new FileWriter("cscd210mathlabout.txt", true)) {

                writer.write("Program: ");
                writer.write("What was your last meter reading?: ");
                writer.write(System.lineSeparator());
                writer.write("User: ");
                writer.write((mtr.format(cMeter)));
                writer.write(System.lineSeparator());

                writer.write("Program: ");
                writer.write("What is your current meter reading?: ");
                writer.write(System.lineSeparator());

                writer.write("User: ");
                writer.write((mtr.format(lMeter)));
                writer.write(System.lineSeparator());

                writer.write("Program: ");
                writer.write("What is your customer code?: ");
                writer.write(System.lineSeparator());
                writer.write("User: ");
                writer.write((cust_code));
                writer.write(System.lineSeparator());

                writer.write('\n');
                writer.write("Program Output: ");
                writer.write(System.lineSeparator());

                writer.write("Customer Code: " + cust_code);
                writer.write(System.lineSeparator());

                writer.write("Last Meter Reading: ");
                writer.write(mtr.format(lMeter));
                writer.write(System.lineSeparator());

                writer.write("Current Meter Reading: ");
                writer.write(mtr.format(cMeter));
                writer.write(System.lineSeparator());

                writer.write("Usage: ");
                writer.write(use.format(usage) + " gallons");
                writer.write(System.lineSeparator());

                writer.write(("Amount Billed: ") + "$ " + (pay.format(bill)));
                writer.write('\n');
                writer.write('\n');
            }

            catch (IOException e) {

                System.out.println("There was a problem writer the file.");
                System.out.println("Error: " + e.getMessage());
            }

                /* Continue? Prompt */
                System.out.println("Do you want to continue? (y/n): ");
                String response = input.next();
                input.nextLine();

                if (response.equals("n") || response.equals("no")) {
                    System.out.println();
                    System.out.println("Bye-Bye! ");
                    cont_state = false;
                }
        } // Loop End
        input.close();
    } // Method End

} //Class End


/*
   Yoko S Parks
   Oct 18 2024
   CSC210
   Eastern Washington University
 */


