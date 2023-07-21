package battleship;

import battleship.models.Computer;
import battleship.models.Player;

public class Game {

    private Computer computer;

    private Player player;

    public Game() {
        this.computer = new Computer("cp1");
        this.player = new Player();

        this.player.setShips(GenerateShips.generateShips(5));
        this.computer.setShips(GenerateShips.generateShips(5));
    }

    public String handleInput(String guess) {
        return computer.checkIfShipHasBeenHit(guess);
    }

    public String[] playComputer() {
        String guess = computer.guess();
        String result = player.checkIfShipHasBeenHit(guess);
        computer.processResult(result);
        return new String[] { guess, result };
    }

    public Boolean isGameOver() {
        return player.isDefeated() || computer.isDefeated();
    }

}
