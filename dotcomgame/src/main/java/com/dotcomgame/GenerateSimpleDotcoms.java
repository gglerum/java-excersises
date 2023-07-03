package com.dotcomgame;

import java.util.ArrayList;

public class GenerateSimpleDotcoms {

    private static ArrayList<String> grid;

    /**
     * Generate a grid to place the DotComs on
     */
    public static void generateGrid() {
        // we can put it in an ArrayList. No need for a multi dimensional array
        grid = new ArrayList<String>();

        // x axis is alphabetical
        for (char l = 'A'; l <= DotcomGame.MAX_CHAR; l++) {
            // y axis is numeric
            for (int i = 1; i <= DotcomGame.MAX_NUM_OF_CELLS; i++) {
                grid.add(l + Integer.toString(i));
            }
        }
    }

    /**
     * Generate a new location with cells the simpleDotCom has been placed on
     * 
     * @return ArrayList<String>
     */
    private static ArrayList<String> generateLocation() {
        ArrayList<String> locationCells = new ArrayList<String>();

        // 0 vertical and 1 is horizontal
        int direction = (int) (Math.random() * 2);

        boolean found = false;
        // loop untill a location is found with surrounding cells the SimpleDotCom can
        // be placed on
        while (found == false) {
            // get random index of grid
            int start = (int) (Math.random() * grid.size());
            // get coordinate from the index
            String coordinate = grid.get(start);

            // get the alphabetical character from the coordinate
            char l = coordinate.charAt(0);
            // get the numerical character from the coordinate
            int i = Character.getNumericValue(coordinate.charAt(1));

            // vertical coords
            String[] coords = { coordinate, l + Integer.toString(i + 1), l + Integer.toString(i + 2) };
            // horizontal coords
            if (direction == 1) {
                coords = new String[] { coordinate, (++l) + Integer.toString(i), (++l) + Integer.toString(i) };
            }

            // check if the adjanct cells are still available on the grid
            if (grid.indexOf(coords[1]) > -1 && grid.indexOf(coords[2]) > -1) {
                // if the adjanct cells are available add the cells to SimpleDotCom and remove
                // from the grid so it can not be occupied by a different simpleDotCom
                for (String coord : coords) {
                    locationCells.add(coord);
                    grid.remove(coord);
                }
                found = true;
            }
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
        generateGrid();

        SimpleDotCom[] simpleDotComs = new SimpleDotCom[numOfDotComs];
        for (int i = 0; i < simpleDotComs.length; i++) {
            simpleDotComs[i] = new SimpleDotCom();
            simpleDotComs[i].setLocationCells(generateLocation());
        }
        return simpleDotComs;
    }

}
