package battleship.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import battleship.GenerateShips;

class ComputerTest {

    private static int numOfGuesses = 0;

    @Disabled("Use Computer vs Computer instead")
    @Test
    void computerGuessesWhereShipsArePlaced() {
        Player player = new Player();
        Computer computer = new Computer();

        player.setShips(GenerateShips.generateShips(1));

        Assertions.assertThat(player.isDefeated()).isFalse();

        int numGuesses = 0;
        while (!player.isDefeated()) {
            String result = player.checkIfShipHasBeenHit(computer.guess());
            computer.processResult(result);
            numGuesses++;
        }

        Assertions.assertThat(player.isDefeated()).isTrue();
        System.out.println(String.format("Computer needed %2d guesses.", numGuesses));
    }

    @Test
    void computerVsComputer() {
        Computer cp1 = new Computer("cp1");
        Computer cp2 = new Computer("cp2");

        cp1.setShips(GenerateShips.generateShips(1));
        cp2.setShips(GenerateShips.generateShips(1));

        Assertions.assertThat(cp1.isDefeated()).isFalse();
        Assertions.assertThat(cp2.isDefeated()).isFalse();

        // int numGuesses = 0;
        TakeTurns(cp2, cp1);
        // numGuesses++;

        Assertions.assertThat(cp1.isDefeated() || cp2.isDefeated()).isTrue();
        // System.out.println(String.format("Game needed %2d guesses.", numGuesses));
        String winner = cp1.isDefeated() ? cp2.getName() : cp1.getName();
        System.out.println(String.format("%s has won.", winner));
        System.out.println("Game Over");

        System.out.println(String.format("Game needed %2d turns", numOfGuesses));
    }

    private void TakeTurns(Computer cp2, Computer cp1) {
        if (cp1.isDefeated() || cp2.isDefeated()) {
            return;
        }
        String guess = cp1.guess();
        System.out.println(String.format("%s guessed %s", cp1.getName(), guess));

        String result = cp2.checkIfShipHasBeenHit(guess);
        System.out.println(String.format("%s had a %s", cp1.getName(), result));
        cp1.processResult(result);

        numOfGuesses++;

        TakeTurns(cp1, cp2);
    }

}
