package javales.src;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {

    private Utils() {
    }

    private static Random random = new Random();

    private static final Scanner INPUT = new Scanner(System.in);

    public static int randomNextInt() {
        return random.nextInt();
    }

    public static int randomNextInt(int bound) {
        return random.nextInt(bound);
    }

    public static int getRandomBetweenInts(int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }

    /**
     * Get input from input stream
     * 
     * @param label    text to display for requesting input
     * @param isString check for string or for int
     * @param options  options to check input against, if string
     * @return String
     */
    public static String getFromInput(String label, String regex) {
        String strInput;
        // get input from player
        while (true) {
            System.out.println(label);

            strInput = INPUT.nextLine();
            // if match found, return
            if (Pattern.matches(regex, strInput)) {
                return strInput;
            }
            // no match found, ask for new input
            System.out.print("Supply a correct input. ");
        }
    }

    /**
     * Call method just for int values
     * 
     * @param label text to display to request input
     */
    public static String getFromInput(String label) {
        return getFromInput(label, "(.*)");
    }

}
