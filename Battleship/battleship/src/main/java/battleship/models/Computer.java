package battleship.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import battleship.GenerateShips;

public class Computer extends Player {

    private List<String> grid;

    private String nextTarget = "";

    private ArrayList<String> hitMemory = new ArrayList<>();

    private String lastGuess = "";

    private Random random = new Random();

    public Computer() {
        grid = GenerateShips.generateGrid();
    }

    public String guess() {
        if (hitMemory.isEmpty()) {
            lastGuess = grid.get(random.nextInt(grid.size()));
        } else {
            lastGuess = nextTarget;
            nextTarget = "";
        }
        grid.remove(lastGuess);

        return lastGuess;
    }

    private void addNextCell(String cell, int aI, int nI) {
        // get the alphabetical character from the coordinate
        char a = cell.charAt(0);
        // get the numerical character from the coordinate
        int n = Character.getNumericValue(cell.charAt(1));

        cell = (a + aI) + Integer.toString(n + nI);

        if (grid.indexOf(cell) > -1) {
            hitMemory.add(cell);
        }
    }

    private void processHit() {
        if (hitMemory.isEmpty()) {
            // vertical cells
            addNextCell(lastGuess, 0, -1);
            addNextCell(lastGuess, 0, 1);
            // horizontal cells
            addNextCell(lastGuess, -1, 0);
            addNextCell(lastGuess, 1, 0);
        }
        setNextTarget();
    }

    private void setNextTarget() {
        if (!hitMemory.isEmpty()) {
            nextTarget = hitMemory.get(random.nextInt(hitMemory.size()));
        }
    }

    public void processResult(String result) {
        // remember that there was a hit
        if (result.equals("hit")) {
            processHit();
        }
        if (result.equals("miss")) {
            setNextTarget();
        }
        if (result.equals("kill")) {
            hitMemory.clear();
        }
    }

}
