package BeerSong;

public class BeerSong {

    public static void main(String[] args) {
        int beerNum = 99;
        String word = "bottles";

        while (beerNum > 0) {
            System.out.println();
            if (beerNum == 1) {
                word = "bottle";
            }

            System.out.println(String.format("%2d %s of beer on the wall.", beerNum, word));
            System.out.println(String.format("%2d %s of beer.", beerNum, word));
            System.out.println("Take one down.");
            System.out.println("Pass it around.");
            beerNum--;

            if (beerNum > 0) {
                System.out.println(String.format("%2d %s of beer on the wall.", beerNum, word));
                continue;
            }
            System.out.println("No more bottles of beer on the wall.");
        }
    }

}
