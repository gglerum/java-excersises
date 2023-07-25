import java.util.Scanner;

public class GameLauncher {

    public static final Scanner input = new Scanner(System.in);

    /**
     * Get input from scanner stream and make sure if is an int
     * If not an int: prompt for input again
     *
     * @return int
     */
    public static int getIntFromInput(String label) {
        // get input from player
        while (true) {
            System.out.println(label);
            if (!input.hasNextInt()) {
                input.next();
                continue;
            }
            return input.nextInt();
        }
    }

    public static void main(String[] args) {
        System.out.println("What's your name?:");
        String name = input.nextLine();
        int numPlayers = getIntFromInput("Input amount of players:");

        System.out.println(String.format("Starting game for %s with %2d players.", name, numPlayers));

        GuessGame game = new GuessGame(numPlayers, name);
        game.startGame();
        input.close();
    }

}
