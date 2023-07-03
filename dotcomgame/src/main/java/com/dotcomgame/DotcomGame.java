package com.dotcomgame;

public class DotcomGame {

    public static final int MAX_NUM_OF_CELLS = 7;

    public static final char MAX_CHAR = 'G';

    public static final int DOTCOM_SIZE = 3;

    public static void main(String[] args) {

        GameLauncher game = new GameLauncher(3);
        game.run();

    }
}
