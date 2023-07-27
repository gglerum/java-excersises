package javales.src.chapters;

/*
 Try This 1-2
 This program displays a conversion
 table of gallons to liters.
 Call this program "GalToLitTable.java".
*/
class Chapter1InchToMeters {
    private static final int TWELVE_FEET = 12 * 12;

    public static void main(String[] args) {
        int inches;
        double meters;
        int counter = 0;
        // 12 feet consists of 12 times 12 inches
        for (inches = 1; inches <= TWELVE_FEET; inches++) {
            meters = inches * 39.37; // convert to liters
            System.out.println(String.format("%2d inches is %.2f meters.", inches, meters));
            counter++;
            // every 10th line, print a blank line
            if (counter == 12) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}