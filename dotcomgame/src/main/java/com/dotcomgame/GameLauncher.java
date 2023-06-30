package com.dotcomgame;

import java.util.Scanner;

public class GameLauncher {

    int destroyedDotComs = 0;

    SimpleDotCom[] simpleDotComs;

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
                            DotcomGame.maxChar + Integer.toString(DotcomGame.maxNumOfCells)));

            String playerGuess = input.nextLine();
            this.processPlayerGuess(playerGuess);
        }

        input.close();
    }

    public void run() {
        System.out.println("Initializing game with one SimpleDotCom.");

        System.out.println(String.format(
                "Guess where the SimpleDotCom has been placed on a row from A1 to %s. The SimpleDotCom occupies three cells.",
                DotcomGame.maxChar + Integer.toString(DotcomGame.maxNumOfCells)));

        this.requestInputFromPlayer();

        System.out.println("All SimpleDotComs destroyed. Game Over!");
    }

}
