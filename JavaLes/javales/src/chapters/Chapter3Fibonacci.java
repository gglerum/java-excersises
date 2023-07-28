package javales.src.chapters;

import javales.src.Utils;

public class Chapter3Fibonacci {

    public static void main(String[] args) {
        fibonacci();
    }

    private static void fibonacci() {
        int upTo = Integer.parseInt(
                Utils.getFromInput("Up to what number do you want to display the fibonacci sequence?:", "\\d+"));

        System.out.print(String.format("The fibonacci sequence up to %2d: ", upTo));

        for (int i = 1; i < upTo; i += i) {
            System.out.print(i + " ");
        }

        Utils.closeInputStream();
    }

}
