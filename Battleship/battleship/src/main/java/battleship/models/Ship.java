package battleship.models;

import java.util.List;

public class Ship {

    private List<String> locationCells;

    // No-args; initialize without setting anything
    public Ship() {

    }

    // Initialize with location cells
    public Ship(List<String> locationCells) {
        this.locationCells = locationCells;
    }

    /**
     * Setter for locationCells
     * 
     * @param locationCells
     */
    public void setLocationCells(List<String> locationCells) {
        this.locationCells = locationCells;
    }

    /**
     * Check if the usersGuess has hit a dotCom
     * 
     * @param userGuess
     * @return String "kill"|"hit"|"miss"
     */
    public String checkYourself(String userGuess) {
        int index = this.locationCells.indexOf(userGuess);

        // if the guess is not in the locationCells return early with miss
        if (index == -1) {
            return "miss";
        }
        // remove the cell that was hit
        this.locationCells.remove(index);
        // if the ArrayList is empty all cells have been hit and the SimpleDotCome has
        // been destroyed
        if (this.locationCells.isEmpty()) {
            return "kill";
        }

        return "hit";
    }

}
