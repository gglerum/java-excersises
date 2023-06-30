package com.dotcomgame;

public class DotcomGame {

    public static final int maxNumOfCells = 7;

    public static final char maxChar = 'G';

    public static final int size = 3;

    public static void main(String[] args) {

        GameLauncher game = new GameLauncher(3);
        game.run();

    }
}
