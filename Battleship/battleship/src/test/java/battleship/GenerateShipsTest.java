package battleship;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import battleship.models.Ship;

class GenerateShipsTest {
    @Test
    void testGenerateShips() {
        int numOfShips = 7;

        Ship[] ships = GenerateShips.generateShips(numOfShips);

        Assertions.assertThat(ships.length).isEqualTo(numOfShips);
    }
}
