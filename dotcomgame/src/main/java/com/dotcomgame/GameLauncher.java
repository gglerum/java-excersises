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
    private void processPlayerGuess(int playerGuess) {
        for (SimpleDotCom simple : simpleDotComs) {
            String result = simple.checkYourself(playerGuess);
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
    }

    /**
     * have the player keep guessing until all cells of the SimpleDotCom have been
     */
    private void requestInputFromPlayer() {
        Scanner input = new Scanner(System.in);

        // keep the player guessing untill all SimpleDotComs have been destroyed
        while (this.destroyedDotComs != this.simpleDotComs.length) {
            System.out.println(String.format("Take a guess (1 to %2d):", DotcomGame.maxNumOfCells));
            // check if the player has input a number, else request that he does
            if (!input.hasNextInt()) {
                System.out.println("You have to guess a number!");
                input.next();
                continue;
            }
            int playerGuess = input.nextInt();
            this.processPlayerGuess(playerGuess);
        }

        input.close();
    }

    public void run() {
        System.out.println("Initializing game with one SimpleDotCom.");

        System.out.println(
                "Geuss where the SimpleDotCom has been placed on a row from 1 to 7. The SimpleDotCom occupies three cells.");

        this.requestInputFromPlayer();

        System.out.println("All SimpleDotComs destroyed. Game Over!");
    }

}
