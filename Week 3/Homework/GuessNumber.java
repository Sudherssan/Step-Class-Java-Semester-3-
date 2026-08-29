import java.util.Scanner;

public class GuessNumber {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && !guessed) {
            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int secretNumber = sc.nextInt();
        int maxTries = sc.nextInt();

        int[] guesses = new int[maxTries];

        for (int i = 0; i < maxTries; i++) {
            guesses[i] = sc.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);

        sc.close();
    }
}