import java.util.Arrays;
import java.util.Scanner;

public class Chapter1MoonWeight {

    private static final Scanner INPUT = new Scanner(System.in);

    private static final double MOON_WEIGHT_FRACTION = 0.17;

    private static final double LBS_TO_KG = 0.45359237;

    private static final double KG_TO_LBS = 2.20462262;

    /**
     * Get input from input stream
     * 
     * @param label    text to display for requesting input
     * @param isString check for string or for int
     * @param options  options to check input against, if string
     * @return String
     */
    private static String getIntFromInput(String label, Boolean isString, String[] options) {
        // get input from player
        while (true) {
            System.out.println(label);

            if ((!isString && !INPUT.hasNextInt()) || !INPUT.hasNextLine()) {
                INPUT.next();
                continue;
            }

            String strInput = INPUT.nextLine();
            if (!isString || options.length == 0 || Arrays.asList(options).indexOf(strInput) > -1) {
                return strInput;
            }

            System.out.print("Supply a correct input. ");
        }
    }

    /**
     * Call method just for int values
     * 
     * @param label text to display to request input
     */
    private static String getIntFromInput(String label) {
        return getIntFromInput(label, false, new String[0]);
    }

    public static void main(String[] args) {
        String unit = getIntFromInput("Weight in lbs or kg?", true, new String[] { "lbs", "kg" });
        double weight = Double.parseDouble(getIntFromInput(String.format("What's your weight in %s?", unit)));

        double lbs = (unit.equals("lbs") ? weight : weight * KG_TO_LBS) * MOON_WEIGHT_FRACTION;

        double kg = (unit.equals("kg") ? weight : weight * LBS_TO_KG) * MOON_WEIGHT_FRACTION;

        System.out.println(String.format("Your moon weight is in lbs %.1f and in kg %.1f", lbs, kg));
    }
}
