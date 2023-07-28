package javales.src.chapters;

import java.util.Scanner;

public class Chapter3ChangeCharacterCases {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input, change;
        String chars = "Characters cast: ";

        System.out.println(
                "Input characters, entering each character with the enter key. Input . followed by enter when done.");
        do {
            input = change = scanner.next().charAt(0);
            // change case if alphabetic
            if (Character.isAlphabetic(input)) {
                change += input >= 32 ? -32 : 32;
            }
            // add to string output
            chars += input + ">>" + change + " ";
            // when a period is entered, stop asking for input
        } while (input != '.');

        System.out.println(chars);

        scanner.close();
    }

}
