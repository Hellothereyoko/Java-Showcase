// Import Packages
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileWriter;

public class CSCD210MathLab {

    // Global Variables
    public static double metersPerSecond;
    public static double feetPerSecond;
    public static double kilometerPerHour;
    public static double milesPerHour;
    public static double timeToSkiOneMileMinutes;
    public static double timeToSkiOneMileSeconds;
    public static double timeToSki100YardsSeconds;
    public static final double SLOPE_DIST = 2.5; //In km
    public static double win_time;


    public static void main(String[] args) {

        // Input method called
        Scanner input = new Scanner(System.in);

        // Global Variable Declaration
        boolean cont_state = true;


        while (cont_state) {

            // System Input from User
            System.out.println("What's the champion's name:");
            String skier_name = input.nextLine();

            System.out.println("What's the win time in seconds?:");
            win_time = input.nextDouble();

            // Nom-Nom! Eat the leftover line
            input.nextLine();

            // Formula Storage & Decimal Formatting
            DecimalFormat fmt = new DecimalFormat("0.00");

            metersPerSecond = ((SLOPE_DIST * 1000) / win_time);
            feetPerSecond = ((SLOPE_DIST * 3280.839895) / win_time);
            kilometerPerHour = (metersPerSecond * 3.60);
            milesPerHour = (feetPerSecond * .681818);

            // Calculate time to ski one mile (1609.34 m)
            double oneMileMeters = 1609.34;
            timeToSkiOneMileSeconds = oneMileMeters / metersPerSecond;
            timeToSkiOneMileMinutes = timeToSkiOneMileSeconds / 60;
            timeToSkiOneMileSeconds = timeToSkiOneMileSeconds % 60;

            // Calculate time to ski 100 yards (91.44 m)
            double oneHundredYardsMeters = 91.44;
            timeToSki100YardsSeconds = oneHundredYardsMeters / metersPerSecond;

            // Post Arithmetic Processing
            String mt_sf = fmt.format(metersPerSecond);
            String ft_sf = fmt.format(feetPerSecond);
            String km_hf = fmt.format(kilometerPerHour);
            String mi_hf = fmt.format(milesPerHour);
            String formattedTimeToSki100Yards = fmt.format(timeToSki100YardsSeconds) + " seconds";

            // Done this way because of fractional minutes & seconds >:(
            String formattedTimeToSkiOneMile = (int) timeToSkiOneMileMinutes + " minute" +
                    ((int) timeToSkiOneMileMinutes == 1 ? "" : "s") +
                    " and " + fmt.format(timeToSkiOneMileSeconds) + " second" + ((int) timeToSkiOneMileSeconds == 1 ? "" : "s");


            // System Out to User
            System.out.println((skier_name) + ("'s ") + ("rate of travel was:"));
            System.out.println("");

            System.out.println((mt_sf) + (" m/s"));
            System.out.println((ft_sf) + (" ft/s"));
            System.out.println((km_hf) + (" km/h"));
            System.out.println((mi_hf) + (" mi/h"));
            System.out.println('\n');

            System.out.println("It would take " + formattedTimeToSkiOneMile + " for " + skier_name + " to ski one mile.");
            System.out.println("It would take " + formattedTimeToSki100Yards + " for " + skier_name + " to ski 100 yards.");
            System.out.println("");

            // File Auto-Write Routine
            try (FileWriter writer = new FileWriter("cscd210mathlabout.txt", true)) {

                writer.write('\n');
                writer.write("Program: ");
                writer.write(" What's the champion's name?:");
                writer.write(System.lineSeparator());

                writer.write("User: ");
                writer.write(String.valueOf(skier_name));
                writer.write(System.lineSeparator());

                writer.write("Program:");
                writer.write(" What's the win time in seconds?:");
                writer.write(System.lineSeparator());

                writer.write("User: ");
                writer.write(String.valueOf(win_time));
                writer.write(System.lineSeparator());


                writer.write(System.lineSeparator());
                writer.write((skier_name) + ("'s ") + ("rate of travel was:"));
                writer.write('\n');
                writer.write(System.lineSeparator());

                writer.write((mt_sf) + (" m/s"));
                writer.write(System.lineSeparator());
                writer.write((ft_sf) + (" ft/s"));
                writer.write(System.lineSeparator());
                writer.write((km_hf) + (" km/h"));
                writer.write(System.lineSeparator());
                writer.write((mi_hf) + (" mi/h"));
                writer.write('\n');
                writer.write(System.lineSeparator());

                writer.write("It would take " + formattedTimeToSkiOneMile + " for " + skier_name + " to ski one mile.");
                writer.write(System.lineSeparator());
                writer.write( "It would take " + formattedTimeToSki100Yards + " for " + skier_name + " to ski 100 yards.");
                writer.write('\n');

                System.out.println("\n");
                System.out.println("Writing to File...");
                System.out.println("Exported to File!");
                System.out.println('\n');


            }

            // Ruh Roh Raggy
            catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
                System.out.println("There appears to be an issue writing to the file!");
            }

            // Continue? Prompt
            System.out.println("Do you want to continue? (yes/no):");
            String response = input.nextLine();


            // Exit the loop if the user doesn't want to continue
            if (!response.equalsIgnoreCase("yes")) {

                cont_state = false;
                System.out.println("Bye-Bye!");
                input.close();
            }

            else {

            // From the top now!
                System.out.println("Restarting...");
            }

        }// End Loop
    } //Method has left the chat
}
//END OF SCRIPT


