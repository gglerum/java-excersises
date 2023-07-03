package com.dotcomgame;

import java.util.Scanner;

public class GameLauncher {

    private int destroyedDotComs = 0;

    private SimpleDotCom[] simpleDotComs;

    public GameLauncher(int numOfDotComs) {
        simpleDotComs = GenerateSimpleDotcoms.generateDotComs(numOfDotComs);
    }

    /**
     * Determine if the player has missed, hit or destroyed a SimpleDotCom
     * 
     * @param playerGuess
     */
    private void processPlayerGuess(String playerGuess) {
        String result = null;
        for (SimpleDotCom simple : simpleDotComs) {
            result = simple.checkYourself(playerGuess);
            if (!result.equals("miss")) {
                break;
            }
        }

        switch (result) {
            case "miss":
                System.out.println("You missed!");
                break;
            case "hit":
                System.out.println("You hit the SimpleDotCom!");
                break;
            case "kill":
                destroyedDotComs++;
                System.out.println("You destoyed the SimpleDotCom!");
                break;
        }
    }

    /**
     * have the player keep guessing until all cells of the SimpleDotCom have been
     */
    private void requestInputFromPlayer() {
        Scanner input = new Scanner(System.in);

        // keep the player guessing untill all SimpleDotComs have been destroyed
        while (this.destroyedDotComs != this.simpleDotComs.length) {
            System.out.println(
                    String.format("Take a guess (A1 to %s):",
                            DotcomGame.MAX_CHAR + Integer.toString(DotcomGame.MAX_NUM_OF_CELLS)));

            String playerGuess = input.nextLine();
            this.processPlayerGuess(playerGuess);
        }

        input.close();
    }

    public void run() {
        System.out.println("Initializing game with one SimpleDotCom.");

        System.out.println(String.format(
                "Guess where the SimpleDotCom has been placed on a row from A1 to %s. The SimpleDotCom occupies three cells.",
                DotcomGame.MAX_CHAR + Integer.toString(DotcomGame.MAX_NUM_OF_CELLS)));

        this.requestInputFromPlayer();

        System.out.println("All SimpleDotComs destroyed. Game Over!");
    }

}
