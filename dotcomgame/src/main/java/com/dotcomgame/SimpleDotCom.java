package com.dotcomgame;

public class SimpleDotCom {

    private int[] locationCells;

    private int numOfHits = 0;

    /**
     * Setter for locationCells
     * 
     * @param locationCells
     */
    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    /**
     * Check if the usersGuess has hit a dotCom
     * 
     * @param userGuess
     * @return String "kill"|"hit"|"miss"
     */
    public String checkYourself(int userGuess) {
        for (int locationCell : this.locationCells) {
            if (userGuess == locationCell) {
                numOfHits++;
                if (numOfHits == locationCells.length) {
                    return "kill";
                }
                return "hit";
            }
        }
        return "miss";
    }

}
