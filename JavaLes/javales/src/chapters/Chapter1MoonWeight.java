package javales.src.chapters;

import javales.src.Utils;

public class Chapter1MoonWeight {

    private static final double MOON_WEIGHT_FRACTION = 0.17;

    private static final double LBS_TO_KG = 0.45359237;

    private static final double KG_TO_LBS = 2.20462262;

    public static void main(String[] args) {
        String unit = Utils.getFromInput("Weight in lbs or kg?", "lbs|kg");
        double weight = Double
                .parseDouble(Utils.getFromInput(String.format("What's your weight in %s?", unit), "\\d+(\\.\\d+)?"));

        double lbs = (unit.equals("lbs") ? weight : weight * KG_TO_LBS) * MOON_WEIGHT_FRACTION;

        double kg = (unit.equals("kg") ? weight : weight * LBS_TO_KG) * MOON_WEIGHT_FRACTION;

        System.out.println(String.format("Your moon weight is in lbs %.1f and in kg %.1f", lbs, kg));
    }
}
