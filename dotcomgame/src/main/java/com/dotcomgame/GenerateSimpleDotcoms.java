package com.dotcomgame;

public class GenerateSimpleDotcoms {

    /**
     * Generate a new location with cells the simpleDotCom has been placed on
     * 
     * @return int[]
     */
    private static int[] generateLocation() {
        int[] locationCells = new int[DotcomGame.size];
        // determine the cell the location will start from. Must be smaller than the
        // size of the SimpleDotCom. Adding a 1 to make sure the cell can't be zero
        int cell = (int) (Math.random() * (DotcomGame.maxNumOfCells - DotcomGame.size) + 1);

        for (int i = 0; i < locationCells.length; i++) {
            locationCells[i] = cell;
            cell++;
        }

        return locationCells;
    }

    /**
     * Generate simpleDotComs
     * 
     * @param numOfDotComs
     * @return SimpleDotCom[]
     */
    public static SimpleDotCom[] generateDotComs(int numOfDotComs) {
        SimpleDotCom[] simpleDotComs = new SimpleDotCom[numOfDotComs];
        for (int i = 0; i < simpleDotComs.length; i++) {
            simpleDotComs[i] = new SimpleDotCom();
            simpleDotComs[i].setLocationCells(generateLocation());
        }
        return simpleDotComs;
    }

}
