public class GuessGame {

    public static final int MAX_NUMBER = 10;

    public boolean guessed = false;

    private Player[] players = {};

    private int targetNumber = 0;

    public GuessGame(int numPlayers, String name) {
        this.players = new Player[numPlayers];

        // add player
        this.players[0] = new Player(name, false);

        // add bots
        for (int i = 1; i < numPlayers; i++) {
            this.players[i] = new Player(String.format("Player %2d", i), true);
        }
    }

    /**
     * Have the players take guessed. Use the input stream for the real player
     * and use the Player.Guess method for the bots
     *
     * @return void
     */
    private void havePlayersTakeGuesses() {
        // take a guess for each player
        for (Player player : this.players) {

            int guessedNumber = 0;
            if (player.isBot) {
                guessedNumber = player.guess();
            } else {
                // read input stream for player
                guessedNumber = GameLauncher.getIntFromInput("It's your turn to take a guess:");
                System.out.println("Does not wait");
            }

            System.out.println(String.format("%s guessed %2d.", player.name, guessedNumber));

            player.guessedRight = this.targetNumber == guessedNumber;
            // if the player guessed right let the game know the number was guessed
            if (player.guessedRight) {
                this.guessed = true;
            }
        }
    }

    /**
     * Run the game for the player
     *
     * @return void
     */
    public void startGame() {
        // determine the target number to guess
        this.targetNumber = (int) (Math.random() * MAX_NUMBER + 1);

        System.out.println(String.format("I'm thinking of a number between %2d and %2d", 1, MAX_NUMBER));

        // keep guessing untill the right number has been guessed
        while (!guessed) {
            this.havePlayersTakeGuesses();

            // check if anyone guessed right
            if (guessed) {
                System.out.println("We have a winner!");
                for (Player player : this.players) {
                    System.out
                            .println(String.format("%s guessed %s.", player.name,
                                    player.guessedRight ? "right" : "wrong"));
                }
                System.out.println("The game is over.");
            } else {
                System.out.println("None of the players guessed it, let's try again.");
            }
        }
    }

}
