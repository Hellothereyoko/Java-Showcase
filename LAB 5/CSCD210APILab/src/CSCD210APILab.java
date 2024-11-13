// Import Statement(s)
import java.util.Scanner;
import java.util.regex.Pattern;

// Class Declaration
public class CSCD210APILab {
    public static final int YEAR = 2024;

    //Begin Method
    public static void main(String[] args) {

        // Scanner KB Declaration
        Scanner kb = new Scanner(System.in);


        // Global Runtime Variable Declaration
        char ltr;
        String name = null;
        int birthyear;


        // CHAR INPUT PROMPT
        System.out.print("Please enter a single alphabetic character: ");
        ltr = kb.next().charAt(0); // Casing doesn't matter as it is handled later by the replace function


        // Nom-Nom extra line
        kb.nextLine();


        // FULL NAME INPUT PROMPT
        System.out.print("Please enter your full name: ");
        name = kb.nextLine().trim(); // Kill the whitespace that keeps crashing my program >:(


        // BIRTH YEAR INPUT
        System.out.print("Please enter your birth year: ");
        birthyear = kb.nextInt();


        // Spacing Splice (SS)
        // Using The Spaces for Splicing instead of split function
        int firstSpace = name.indexOf(" ");
        int lastSpace = name.lastIndexOf(" ");


        // Non-Splice Name Parsing
        // if fstSpace is not lstSpace AND fstSpace is valid...
        if (firstSpace != lastSpace && firstSpace != -1) {

            // Stores Each SS as Local Variable
            String firstName = name.substring(0, firstSpace);
            String middleName = name.substring(firstSpace + 1, lastSpace);
            String lastName = name.substring(lastSpace + 1);


            // NAME VAL OUTPUT
            System.out.println("The first letter of your name is: " + firstName.charAt(0));
            System.out.println("The last letter of your name is: " + lastName.charAt(lastName.length() - 1));
            System.out.println("Your middle name is: " + middleName);


            // Hash Code Generation
            // Hash is a 32bit set, any overflow will be negative!!
            String hashinfo = lastName + YEAR + birthyear;
            int hash = hashinfo.hashCode();

            //HASH OUTPUT
            System.out.println("The hash of last name + YEAR + birth year: " + hash);


            // Replace Instance of '?' with chosen char
            String letterPattern = "(?i)" + Pattern.quote(String.valueOf(ltr));  //Force Read 'ltr' as Lowercase
            String replacedName = name.replaceAll(letterPattern, "?");

            // REPLACEMENT OUTPUT
            System.out.println("Name with all '" + ltr + "' replaced with ?: " + replacedName);

        }//EoSS


        // Logic Fork For Incomplete Name
        else {
            System.out.println("Incomplete provided.");
        } //EoElse
    } //EoM
} //EoC


