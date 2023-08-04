package javales.src.lessons.lesson2.broodbeleg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise2 {

    /**
     * Keys to sort or group by
     */
    private static final String NAME = "name";
    private static final String SHELF = "shelf";
    private static final String CATEGORY = "category";

    /**
     * Divider
     */
    private static final String DIVIDER = "=".repeat(20) + "\n";

    /**
     * Spread categories
     */
    private static final String ZOETBELEG = "Zoetbeleg";
    private static final String KAAS = "Kaas";
    private static final String VLEESWAREN = "Vleeswaren";

    private static List<Beleg> beleg = new ArrayList<>();

    public static void main(String[] args) {
        setUp();

        printBelegGroupedByKey(CATEGORY);
        printBelegGroupedByKey(SHELF);

        printBelegSortedByKey(NAME);
        printBelegSortedByKey(CATEGORY);
        printBelegSortedByKey(SHELF);
    }

    /**
     * Print beleg grouped by given key
     * 
     * @param key to group print out by (name, category, shelf)
     */
    private static void printBelegGroupedByKey(String key) {
        Function<Beleg, String> fnField = getFunctionForKey(key);
        System.out.print(String.format("Grouped by %1$s:%n%2$s", key, listByFieldToString(fnField)));
    }

    /**
     * Print beleg sorted by given key
     * 
     * @param key to sort print out by (name, category, shelf)
     */
    private static void printBelegSortedByKey(String key) {
        Function<Beleg, String> fnField = getFunctionForKey(key);

        System.out.print(String.format("Sorted by %1$s:%n%2$s%n", key, getListAsStringSortedBy(fnField)));
    }

    /**
     * Determine Function, used for sorting and grouping, based on given key
     * 
     * @param key category, name or shelf. If a different key is specified, name
     *            will be used.
     * @return Function to sort or group List<Beleg> by
     */
    private static Function<Beleg, String> getFunctionForKey(String key) {
        return switch (key) {
            case CATEGORY:
                yield Beleg::getCategory;
            case SHELF:
                yield Beleg::getShelf;
            default:
                yield Beleg::getName;
        };
    }

    /**
     * Get a textual list of Beleg sorted by given Function
     * 
     * @param fieldFn function to use for sorting
     * @return list of beleg, each item on a new line
     */
    private static String getListAsStringSortedBy(Function<Beleg, String> fieldFn) {
        return belegListToString(beleg.stream().sorted(Comparator.comparing(fieldFn)).toList(),
                Beleg::toInventoryString);
    }

    /**
     * Return a textual string of the beleg List using the given Function to group
     * by
     * 
     * @param fieldFn Function to group by
     * @return all beleg grouped by given Function
     */
    private static String listByFieldToString(Function<Beleg, String> fieldFn) {
        var output = new Object() {
            String value = "";
        };

        // TreeMap naturally sorts the map by keys
        Map<String, List<Beleg>> grouped = new TreeMap<>(beleg.stream().collect(Collectors.groupingBy(fieldFn)));
        grouped.forEach((String label, List<Beleg> beleg) -> {
            output.value += String.format("%s:%n", label);
            output.value += DIVIDER;
            output.value += belegListToString(beleg, Beleg::getName);
            output.value += "\n";
        });

        return output.value;
    }

    /**
     * Textual list of given Beleg List using the given function for mapping
     *
     * @param beleg   list of beleg to transform to string
     * @param fieldFn Function to transform the Beleg object with
     * @return textual list of beleg
     */
    private static String belegListToString(List<Beleg> beleg, Function<Beleg, String> fieldFn) {
        return String.join("\n", beleg.stream().map(fieldFn).toArray(String[]::new)) + "\n";
    }

    /**
     * Populate Beleg list with beleg
     *
     * @return void
     */
    private static void setUp() {
        beleg.add(new Beleg("Ham", VLEESWAREN, "0001"));
        beleg.add(new Beleg("Old Amsterdam", KAAS, "0002"));
        beleg.add(new Beleg("Hagelslag", ZOETBELEG, "0003"));
        beleg.add(new Beleg("Kipfilet", VLEESWAREN, "0001"));
        beleg.add(new Beleg("Wagner Oud", KAAS, "0002"));
        beleg.add(new Beleg("Vruchtenhagel", ZOETBELEG, "0003"));
        beleg.add(new Beleg("Salami", VLEESWAREN, "0001"));
        beleg.add(new Beleg("Komijnenkaas", KAAS, "0002"));
        beleg.add(new Beleg("Jam", ZOETBELEG, "0003"));
    }

}
