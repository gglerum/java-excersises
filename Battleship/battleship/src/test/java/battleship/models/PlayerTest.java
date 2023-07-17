package battleship.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void testCheckIfShipHasBeenHit() {
        Player player = new Player();

        List<Ship> ships = new ArrayList<Ship>();
        ships.add(new Ship(new ArrayList<>(Arrays.asList("A1", "A2", "A3"))));

        player.setShips(ships);

        Assertions.assertThat(player.isDefeated()).isFalse();

        String result = player.checkIfShipHasBeenHit("B3");
        Assertions.assertThat(result).isEqualTo("miss");

        Assertions.assertThat(player.isDefeated()).isFalse();

        result = player.checkIfShipHasBeenHit("A1");
        Assertions.assertThat(result).isEqualTo("hit");

        Assertions.assertThat(player.isDefeated()).isFalse();

        result = player.checkIfShipHasBeenHit("A2");
        Assertions.assertThat(result).isEqualTo("hit");

        Assertions.assertThat(player.isDefeated()).isFalse();

        result = player.checkIfShipHasBeenHit("A3");
        Assertions.assertThat(result).isEqualTo("kill");

        Assertions.assertThat(player.isDefeated()).isTrue();

        result = player.checkIfShipHasBeenHit("A3");
        Assertions.assertThat(result).isEqualTo("miss");
    }
}
