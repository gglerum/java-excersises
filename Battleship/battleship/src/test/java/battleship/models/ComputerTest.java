package battleship.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import battleship.GenerateShips;

class ComputerTest {

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

}
