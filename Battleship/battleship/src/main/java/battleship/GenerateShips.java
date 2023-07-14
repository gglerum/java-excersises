package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import battleship.models.Ship;

public class GenerateShips {

    private GenerateShips() {
    }

    private static ArrayList<String> grid;

    private static Random random;

    /**
     * Generate a grid to place the ships on
     */
    static {
        random = new Random();
        // we can put it in an ArrayList. No need for a multi dimensional array
        grid = new ArrayList<>();

        // x axis is alphabetical
        for (char l = 'A'; l <= GameConstants.MAX_CHAR; l++) {
            // y axis is numeric
            for (int i = 1; i <= GameConstants.MAX_NUM_OF_CELLS; i++) {
                grid.add(l + Integer.toString(i));
            }
        }
    }

    /**
     * Generate simpleDotComs
     * 
     * @param numOfDotComs
     * @return SimpleDotCom[]
     */
    public static Ship[] generateShips(int numOfShips) {
        int shipSize = GameConstants.SHIP_SIZE;
        Ship[] ships = new Ship[numOfShips];

        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship(generateLocation(shipSize));
        }
        return ships;
    }

    /**
     * Generate a new location with cells the simpleDotCom has been placed on
     * 
     * @return ArrayList<String>
     */
    private static List<String> generateLocation(int shipSize) {
        List<String> locationCells = new ArrayList<>();

        // 0 vertical and 1 is horizontal
        int direction = random.nextInt(2);

        // loop untill a cell is found with surrounding cells the ship can
        // be placed on
        while (locationCells.isEmpty()) {
            checkIfShipFits(locationCells, shipSize, direction);
        }
        return locationCells;
    }

    private static void checkIfShipFits(List<String> locationCells, int shipSize, int direction) {
        String[] coords = new String[shipSize];

        // get coordinate from the index
        String coordinate = grid.get(random.nextInt(grid.size()));

        // get the alphabetical character from the coordinate
        char a = coordinate.charAt(0);
        // get the numerical character from the coordinate
        int n = Character.getNumericValue(coordinate.charAt(1));

        // calculate coords and check each coord if available on grid
        for (int i = 0; i < coords.length; i++) {
            // vertical ship, increment across Y axis
            if (direction == 0) {
                coords[i] = a + Integer.toString(n + i);
            } else {
                // horizonal ship increment acros X axis
                coords[i] = (++a) + Integer.toString(n);
            }
            // if coord is not available on grid, return early
            if (grid.indexOf(coords[i]) == -1) {
                return;
            }
        }

        // method has not terminated early, coords for ship were found
        // add coords to locationCells and remove from grid so no other ship can occopy
        // the same coord
        for (String coord : coords) {
            locationCells.add(coord);
            grid.remove(coord);
        }
    }

}
