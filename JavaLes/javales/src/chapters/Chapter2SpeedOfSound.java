package javales.src.chapters;

import javales.src.Utils;

public class Chapter2SpeedOfSound {

    private static final int SOUND_SPEED = 1100;

    public static void main(String[] args) {

        double roundTrip = Double.parseDouble(Utils.getFromInput("How many seconds until echo?:", "\\d+(\\.\\d+)?"));
        double oneWay = roundTrip / 2;
        double ftTraveled = oneWay * SOUND_SPEED;

        System.out.println(String.format("The distance to the object was: %.1f feet", ftTraveled));

    }

}
