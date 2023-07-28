package javales.src.chapters;

import java.util.BitSet;

import javales.src.Utils;

//using the Sieve of Eratosthenes with a bitset to find prime numbers between two given ints
public class Chapter2PrimeNumbers {
    public static void main(String[] args) {
        int s = 0, n = 0;
        // keep looping untill the correct input is provided
        while (true) {
            s = Integer.parseInt(Utils.getFromInput(
                    "From which number do we need to start looking up for prime numbers?",
                    "\\d+"));
            n = Integer.parseInt(Utils.getFromInput(
                    "At what number do we need to stop looking for primes?",
                    "\\d+"));

            if (s < n)
                break;

            System.out.println("Specify a correct range.");
        }

        BitSet primes = findPrimes(s, n);

        System.out.println("Prime Numbers between 2 and " + n + ":");
        printPrimes(primes, s, n);

        Utils.closeInputStream();
    }

    private static void printPrimes(BitSet primes, int s, int n) {
        printPrimes(primes, s, n, 10000);
    }

    private static void printPrimes(BitSet primes, int s, int n, int x) {
        int c = x <= n ? x : x - n;
        for (int i = s; i <= c; i++) {
            if (primes.get(i)) { // Check if the 'i'-th bit is set to true (indicating a prime number)
                System.out.print(i + " "); // Print the prime number followed by a space
            }
        }
        if (n > c && Utils.getFromInput(
                "\nPrint the next 10,000 prime numbers Yes (y) or No (n)?",
                "y|n").equals("y")) {
            System.out.println();
            printPrimes(primes, c, n, c + 10000);
        }
    }

    /**
     * Method to calculate prime numbers up to 'n' using Sieve of Eratosthenes
     * 
     * @param int s to start search from
     * @param int n to stop searching at
     * @return BitSet prime numbers
     */
    private static BitSet findPrimes(int s, int n) {
        BitSet primes = new BitSet(n + 1);

        primes.set(s, n + 1); // Set all bits from index s to 'n' to true (considering 0 and 1 as non-prime)

        System.out.print("Loading: ");

        // Loop through numbers starting from s (the first prime number)
        // and stop when the square of 'p' is greater than 'n'
        for (int p = s; p * p <= n; p++) {
            if (primes.get(p)) { // Check if the 'p'-th bit is set to true (indicating 'p' is a prime number)
                // Mark multiples of 'p' as non-prime by setting their bits to false
                for (int i = p * p; i <= n; i += p) {
                    primes.clear(i);
                }
            }
        }

        return primes;
    }
}
