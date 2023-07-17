package battleship.models;

import java.util.List;

public class Player {

    private List<Ship> ships;

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public Boolean isDefeated() {
        return this.ships.isEmpty();
    }

    public String checkIfShipHasBeenHit(String cell) {
        String result = "miss";
        for (Ship ship : ships) {
            result = ship.checkYourself(cell);
            // if ship has not been missed return result
            if (result.equals("miss")) {
                continue;
            }
            // remove ship if it has been killed
            if (result.equals("kill")) {
                this.ships.remove(ship);
            }
            return result;
        }
        return result;
    }

}
