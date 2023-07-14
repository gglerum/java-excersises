package battleship.models;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShipTest {
    static Ship ship;

    @BeforeAll
    static void setUp() {
        ship = new Ship();
    }

    @Test
    void testCheckYourself() {
        List<String> cells = new ArrayList<>();
        cells.add("A1");
        cells.add("A2");
        cells.add("A3");
        ship.setLocationCells(cells);

        String result = ship.checkYourself("B4");
        Assertions.assertThat(result).isEqualTo("miss");

        result = ship.checkYourself("A1");
        Assertions.assertThat(result).isEqualTo("hit");
        result = ship.checkYourself("A2");
        Assertions.assertThat(result).isEqualTo("hit");

        result = ship.checkYourself("A3");
        Assertions.assertThat(result).isEqualTo("kill");
    }
}
