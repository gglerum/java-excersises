package javales.src.lessons;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import javales.src.Utils;

class Lesson1 {

    private static void calculateGoingDutchWithTip() {
        int numOfPeople = 7;
        double totalWithoutTip = 669.0;
        double tipPercentage = 0.05;

        double tip = totalWithoutTip * tipPercentage;
        double totalWithTip = totalWithoutTip + tip;
        double totalPP = totalWithTip / numOfPeople;

        System.out.println(String.format("Aantal personen: %2d", numOfPeople));
        System.out.println(String.format("Totaal zonder fooi: %.2f", totalWithoutTip));
        System.out.println(String.format("Fooi (%2d): %.2f:", (int) tipPercentage * 100, tip));
        System.out.println(String.format("Totaal met fooi: %.2f", totalWithTip));
        System.out.println(String.format("Bedrag per persoon (%2d): %.2f", numOfPeople, totalPP));
    }

    private static void excersise1() {
        String kabinet = "we krijgen een Rutte kabinet.";
        System.out.println(String.format("1. Een string bevat de tekst: %s", kabinet));
        System.out.println(String.format("Wat is de lengte van deze string?: %2d", kabinet.length()));

        String regering = kabinet.replace("kabinet", "regering");
        System.out.println(String.format("Vervang kabinet door regering: %s", regering));
        System.out.println(String.format("Op welke positie staat 'Rutte'?: %2d", regering.indexOf("Rutte")));
    }

    private static void excersise2() {
        int number = 4589;
        System.out.println(String.format("2. Een getal is %2d", number));
        int newNumber = Integer.parseInt(Integer.toString(number).replace('8', '7'));
        System.out.println(String.format("Vervang 8 Door 7: %2d", newNumber));
        // vals spelen
        System.out.println(
                String.format("Deel dit getal Door 1000 en rond het af (string format): %2d", newNumber / 1000));
        int numberRounded = Math.round((float) newNumber / 1000);
        System.out.println(String.format("Deel dit getal Door 1000 en rond het af (Math.round): %2d", numberRounded));
    }

    private static void excersise3() {
        int number1 = 12;
        System.out.println(String.format("3. Een variabele krijgt de waarde %2d", number1));
        int number2 = 13;
        System.out.println(String.format("Een andere de waarde %2d", number2));
        System.out.println(String.format("Vermenigvuldig deze getallen met elkaar: %2d", number1 * number2));
    }

    private static void excersise4() {
        int index = 0;
        System.out.println("4. Een getal in een variabele wordt met 1  opgehoogd. Doe dit op twee manieren");
        index++;
        System.out.println(index);
        index += 1;
        System.out.println(index);
    }

    private static void excersise5() {
        String string = "45,7896";
        System.out.println(String.format("5. Een variabele heeft als waarde '%s'", string));
        System.out.println(String.format("Welk type variabele is dit?: %s", string.getClass()));

        double doubleString = Double.parseDouble(string.replace(",", "."));
        System.out.println(
                String.format("Maak er een numeriek gegeven van en rond deze af op 1 cijfer: %.1f", doubleString));
    }

    private static void excersise6() {
        int randomInt = Utils.randomNextInt();

        System.out.println(String.format("6. Genereer een willekeurig getal: %2d", randomInt));
    }

    private static void excersise7() {
        int lowerBound = 88;
        int upperBound = 98;
        int randomNumber = Utils.getRandomBetweenInts(lowerBound, upperBound);
        System.out
                .println(String.format("7. Nu een getal tussen %2d en %2d: %2d", lowerBound, upperBound, randomNumber));
    }

    private static void excersise8() {
        System.out.println(
                "8. Maak array van de deelnemers van onze training. Sorteer deze op alfabet. Geef deze waarden omgekeerd weer (van achter naar voren):");
        // our participants to sort
        String[] participants = new String[] { "Melle", "Glenn", "Rowan", "Peter", "Martin", "Jasmijn", "Sebastiaan",
                "Sybren", "Cornee" };

        // sort participants
        Arrays.sort(participants);
        System.out.println(String.join(", ", participants));

        // reverse participants
        Collections.reverse(Arrays.asList(participants));
        System.out.println(String.join(", ", participants));
    }

    private static void excersise9() {
        System.out.println("9. Zet getallen 1 tot 10 onder elkaar met een for-loop:");
        loopAndPrintBetween(1, 10);
        System.out.println("Doe hetzelfde voor 91 tot 100:");
        loopAndPrintBetween(91, 100);
    }

    private static void loopAndPrintBetween(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    private static void excersise10() {
        String[] carBrands = new String[] { "Ford", "Opel", "Fiat", "Toyota" };
        System.out.println(String.format("10. Zet in een array de automerken %s.", String.join(", ", carBrands)));
        System.out.println("Print deze array-waarden genummerd onder elkaar:");
        for (int i = 1; i < carBrands.length; i++) {
            System.out.println(String.format("%2d %s", i, carBrands[i]));
        }
        System.out.println(
                String.format("Zoek de waarde Opel eruit en print de plaats in de array af van Opel: Index:%2d",
                        Arrays.asList(carBrands).indexOf("Opel")));

    }

    private static void excersise11() {
        System.out.println(
                "Een bar is open vanaf 9 uur tot 3's snachts. Tot 12 uur komen er elke kwartier willekeurig tussen 5 en 10 mensen in de kroeg aan. Na 11 uur verlaten elk kwartier tussen 2 en 8 mensen de kroeg weer. Hoeveel mensen zijn om 3 uur aanwezig?");

        int numOfPeople = 0;
        double interval = 0.25;
        int lateHours = 11;
        String startTime = "21:00";
        String endTime = "03:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime openingTime = LocalDateTime.parse("2023-07-21 " + startTime, formatter);
        LocalDateTime closingTime = LocalDateTime.parse("2023-07-21 " + endTime, formatter);

        // If the closing time is on the second day we need to add 24 hours, or we will
        // get a negative number
        if (closingTime.isBefore(openingTime)) {
            closingTime = closingTime.plusHours(24);
        }

        Duration duration = Duration.between(openingTime, closingTime);

        for (double i = 0; i <= duration.toHours(); i += interval) {
            numOfPeople += Utils.getRandomBetweenInts(5, 10);

            if (i >= lateHours) {
                numOfPeople -= Utils.getRandomBetweenInts(2, 8);
            }
        }

        System.out.println(String.format("Hoeveel mensen zijn er na 03:00 nog aanwezig?: %2d", numOfPeople));
    }

    public static void main(String[] args) {
        calculateGoingDutchWithTip();
        excersise1();
        excersise2();
        excersise3();
        excersise4();
        excersise5();
        excersise6();
        excersise7();
        excersise8();
        excersise9();
        excersise10();
        excersise11();
    }

}