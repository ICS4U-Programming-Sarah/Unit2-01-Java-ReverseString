import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* This program uses recursion to reverse,
* a set of strings.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since 2023-13-04.
*/

public final class ReverseString {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String newLine = sc.nextLine();

                // Declare variable.
                final String aStr = newLine;

                // Call function.
                final String reverseStr = reverse(aStr);

                // Display results.
                System.out.println("The original string is: " + aStr);
                System.out.println("The reversed string using recursion is: "
                        + reverseStr);

                // Write to console.
                write.println("The original string is: " + aStr);
                write.println("The reversed string using recursion is: "
                    + reverseStr);
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * reverse a string.
    *
    * @param someStr passed
    * @return someStr.
    */

    public static String reverse(String someStr) {
        // Checking to see if line is empty.
        if (someStr.length() == 0) {
            // Returns value to main.
            return someStr;

        } else {
            // Return the 1st character to the end,
            // & return the 0th character.
            // It then calls the function
            // recursively.
            return reverse(someStr.substring(1))
                + someStr.charAt(0);
        }
    }
}
