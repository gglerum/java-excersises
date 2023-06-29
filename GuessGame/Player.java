public class Player {
    public String name = "";
    public int number = 0;
    public boolean guessedRight = false;
    public boolean isBot = false;

    public Player(String name, boolean isBot) {
        this.name = name;
        this.isBot = isBot;
    }

    /**
     * Have the player/bot take a guess
     *
     * @return int the number that was guessed by the player.
     */
    public int guess() {
        this.number = (int) (Math.random() * GuessGame.MAX_NUMBER + 1);
        System.out.println(String.format("%s: I'm guessing %2d", this.name, this.number));
        return this.number;
    }
}
